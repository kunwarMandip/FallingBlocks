package com.libgdx.fallingblocks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.libgdx.fallingblocks.controller.*;
import com.libgdx.fallingblocks.entity.common.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.DeathBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.player.PlayerState;
import com.libgdx.fallingblocks.game.GameScore;
import com.libgdx.fallingblocks.game.GameState;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.WaveDto;
import com.libgdx.fallingblocks.parser.GameDtoParser;
import com.libgdx.fallingblocks.screen.hud.GameRunningHud;

import static com.libgdx.fallingblocks.Logger.Tags.GAME_OVER_STATE;


public class GameRunner {

    private final int level;
    private final SpriteBatch spriteBatch;
    private final InputListenerManager inputListenerManager;

    private WaveDto waveDto;
    private final GameDto gameDto;
    private final GameController gameController;

    private final GameRunningHud gameRunningHud;
    private final WorldController worldController;
    private final SceneController sceneController;
    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    public GameRunner(int level, SpriteBatch spriteBatch, InputListenerManager inputListenerManager){
        this.level=level;
        this.spriteBatch= spriteBatch;
        this.inputListenerManager= inputListenerManager;

        this.gameDto= new GameDtoParser().getGameDto(level);
        this.waveDto = gameDto.getNextWave();
        this.gameController = new GameController();
        this.gameRunningHud = new GameRunningHud(spriteBatch);
        this.sceneController = new SceneController(waveDto.getTiledMapDto());
        this.worldController = new WorldController(true, waveDto.getWorldDto(), sceneController.getTiledMap());
        this.playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto(), inputListenerManager);
        this.enemiesController= new EnemiesController(worldController.getWorld(), playerController.getPlayer().getBodyPosition(), waveDto.getEnemyInfoDto(), worldController.getSpawnAreas());

        setScoreListeners();
        setEnemyDeathListeners();
        setPlayerState();
    }

    private void setScoreListeners(){
        GameScore gameScore= gameController.getGameScore();
        gameScore.getScoreObservers().addObserver(gameRunningHud);
        gameScore.getScoreObservers().addObserver(enemiesController.getEnemySpawnManager().setSpawnConditions().setScoreBasedSpawnRate(5));
    }

    private void setEnemyDeathListeners(){
        Subject<Enemy> enemyDeathNotifier= enemiesController.getEnemyDeathManager().getEnemyDeathNotifier();
        enemyDeathNotifier.addObserver(gameController.getGameScore());
    }

    private void setPlayerState(){
        Subject<PlayerState> playerStateSubject= playerController.getPlayerStateSubject();
        playerStateSubject.addObserver(gameController.getGameStateManager());
    }


//    public void update(float delta){
////        if(gameController.getGameStatistics().isPlayerDead()){
////
////            enemiesController.emptyList();
////            return;
////        }
//        worldController.update();
//        sceneController.render();
//        playerController.update(delta);
//        enemiesController.update(delta);
//    }


    private void gameRunning(float delta){
        worldController.update();
        sceneController.render();
        playerController.update(delta);
        enemiesController.update(delta);
    }

    private void gameOver(){
        Logger.log(GAME_OVER_STATE, "Game Over");
    }

    public void update(float delta){
        GameState gameState= gameController.getGameStateManager().getGameState();
        switch(gameState){
            case RUNNING:
                gameRunning(delta);
                break;
            case GAME_OVER:
                gameOver();
        }
    }


    public void render(float delta){
        sceneController.render();
        worldController.render(sceneController.getOrthographicGameCamera());
        spriteBatch.setProjectionMatrix(sceneController.getOrthographicGameCamera().combined);

        spriteBatch.begin();
        playerController.getPlayer().draw(spriteBatch);
        enemiesController.draw(spriteBatch);
        spriteBatch.end();

        gameRunningHud.render(delta);
    }

    public void resize(int width, int height){
        sceneController.resize(width, height);
        gameRunningHud.resize(width, height);
    }

}
