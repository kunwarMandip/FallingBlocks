package com.libgdx.fallingblocks.game.wave;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.controller.*;
import com.libgdx.fallingblocks.GameLoader;
import com.libgdx.fallingblocks.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.player.PlayerState;
import com.libgdx.fallingblocks.game.score.GameScore;
import com.libgdx.fallingblocks.game.state.GameState;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.parser.dto.WaveDto;
import com.libgdx.fallingblocks.screen.hud.GameOver;
import com.libgdx.fallingblocks.screen.hud.GameOverHud;
import com.libgdx.fallingblocks.screen.hud.GameRunningHud;
import com.libgdx.fallingblocks.screen.overlay.GameOverLayHud;


import static com.libgdx.fallingblocks.Logger.Tags.GAME_OVER_STATE;

public class WaveRunner {

    private final WaveDto waveDto;
    private final SpriteBatch spriteBatch;

    private final HudController hudController;
    private final GameOverHud gameOverHud;
    private final GameRunningHud gameRunningHud;
    private final GameOverLayHud gameOverLayHud;

    private final GameSettingsController gameSettingsController;
    private final WorldController worldController;
    private final SceneController sceneController;
    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    private final InputListenerManager inputListenerManager= new InputListenerManager();

    //todo:: instead of passing gameLoader, pass a listener to tell it to stop Listening
    public WaveRunner(WaveDto waveDto, SpriteBatch spriteBatch, GameLoader gameLoader){
        this.waveDto= waveDto;
        this.spriteBatch= spriteBatch;

        this.hudController= new HudController(inputListenerManager);
        hudController.addActiveHud(new GameOver(null, spriteBatch));

        this.gameOverLayHud= new GameOverLayHud(spriteBatch);

        this.gameSettingsController = new GameSettingsController();
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
        GameScore gameScore= gameSettingsController.getGameScore();
        gameScore.getScoreObservers().addObserver(gameRunningHud);
        gameScore.getScoreObservers().addObserver(enemiesController.getEnemySpawnManager().setSpawnConditions().setScoreBasedSpawnRate(20));

        Subject<Enemy> enemyDeathNotifier= enemiesController.getEnemyDeathManager().getEnemyDeathNotifier();
        enemyDeathNotifier.addObserver(gameSettingsController.getGameScore());

        Subject<PlayerState> playerStateSubject= playerController.getPlayerStateSubject();
        playerStateSubject.addObserver(gameSettingsController.getGameStateManager());
    }


    public void update(float delta){
        GameState gameState= gameSettingsController.getGameStateManager().getGameState();
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
        gameSettingsController.getGameStateManager().setGameState(GameState.RUNNING);
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
        GameState gameState= gameSettingsController.getGameStateManager().getGameState();

        if(gameState== GameState.GAME_OVER){
            hudController.render(delta);
        }
    }


    public void resize(int width, int height){
        sceneController.resize(width, height);
        gameRunningHud.resize(width, height);
        gameOverHud.resize(width, height);
        hudController.resize(width, height);
    }

    public void dispose(){
        hudController.disposeAll();
        inputListenerManager.dispose();
    }

}
