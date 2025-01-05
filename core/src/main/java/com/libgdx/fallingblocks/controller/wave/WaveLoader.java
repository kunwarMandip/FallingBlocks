package com.libgdx.fallingblocks.controller.wave;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.controller.*;
import com.libgdx.fallingblocks.controller.game.GameLoader;
import com.libgdx.fallingblocks.entity.common.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.player.PlayerState;
import com.libgdx.fallingblocks.game.GameScore;
import com.libgdx.fallingblocks.game.GameState;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.parser.dto.WaveDto;
import com.libgdx.fallingblocks.screen.hud.GameOverHud;
import com.libgdx.fallingblocks.screen.hud.GameRunningHud;

import static com.libgdx.fallingblocks.Logger.Tags.GAME_OVER_STATE;

public class WaveLoader {

    private final WaveDto waveDto;
    private final SpriteBatch spriteBatch;

    private final GameOverHud gameOverHud;
    private final GameRunningHud gameRunningHud;
    private final GameController gameController;
    private final WorldController worldController;
    private final SceneController sceneController;
    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    private final InputListenerManager inputListenerManager= new InputListenerManager();

    public WaveLoader(WaveDto waveDto, SpriteBatch spriteBatch, GameLoader gameLoader){
        this.waveDto= waveDto;
        this.spriteBatch= spriteBatch;

        this.gameController = new GameController();
        this.gameRunningHud = new GameRunningHud(spriteBatch);
        this.sceneController = new SceneController(waveDto.getTiledMapDto());
        this.worldController = new WorldController(waveDto.getWorldDto(), sceneController.getTiledMap());
        this.playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto(), inputListenerManager);
        this.enemiesController= new EnemiesController(worldController.getWorld(), playerController.getPlayer().getBodyPosition(), waveDto.getEnemyInfoDto(), worldController.getSpawnAreas());

        this.gameOverHud= new GameOverHud(spriteBatch, this, gameLoader);
        inputListenerManager.addInputProcessor(gameOverHud.getStage());

        setListeners();
    }

    private void setListeners(){
        GameScore gameScore= gameController.getGameScore();
        gameScore.getScoreObservers().addObserver(gameRunningHud);
        gameScore.getScoreObservers().addObserver(enemiesController.getEnemySpawnManager().setSpawnConditions().setScoreBasedSpawnRate(5));

        Subject<Enemy> enemyDeathNotifier= enemiesController.getEnemyDeathManager().getEnemyDeathNotifier();
        enemyDeathNotifier.addObserver(gameController.getGameScore());

        Subject<PlayerState> playerStateSubject= playerController.getPlayerStateSubject();
        playerStateSubject.addObserver(gameController.getGameStateManager());
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

    private void gameOver(){
        Logger.log(GAME_OVER_STATE, "Game Over");
    }

    private void gameRunning(float delta){
        worldController.update();
        sceneController.render();
        playerController.update(delta);
        enemiesController.update(delta);
    }

    public void reset(){
        enemiesController.getEnemyDeathManager().reset();
        playerController.reset();
        gameController.getGameStateManager().setGameState(GameState.RUNNING);
    }

    public void draw(float delta){

        sceneController.render();
        worldController.render(sceneController.getOrthographicGameCamera());
        spriteBatch.setProjectionMatrix(sceneController.getOrthographicGameCamera().combined);

        spriteBatch.begin();
        playerController.getPlayer().draw(spriteBatch);
        enemiesController.draw(spriteBatch);
        spriteBatch.end();

        gameRunningHud.render(delta);
        GameState gameState= gameController.getGameStateManager().getGameState();
        if(gameState==GameState.GAME_OVER){
            gameOverHud.render(delta);
        }
    }

    public void dispose(){
        inputListenerManager.dispose();
    }

    public void resize(int width, int height){
        sceneController.resize(width, height);
        gameRunningHud.resize(width, height);
        gameOverHud.resize(width, height);
    }

}
