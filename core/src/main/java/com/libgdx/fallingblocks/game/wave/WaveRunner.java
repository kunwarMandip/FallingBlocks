package com.libgdx.fallingblocks.game.wave;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.controller.*;
import com.libgdx.fallingblocks.GameLoader;
import com.libgdx.fallingblocks.controller.WaveSettings;
import com.libgdx.fallingblocks.game.state.GameStateManager;
import com.libgdx.fallingblocks.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.player.PlayerState;
import com.libgdx.fallingblocks.game.wave.settings.score.GameScore;
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

    private final WaveSettings waveSettings;
    private final WorldController worldController;
    private final SceneController sceneController;
    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    private final GameStateManager gameStateManager;

    private final InputListenerManager inputListenerManager= new InputListenerManager();

    //todo:: instead of passing gameLoader, pass a listener to tell it to stop Listening
    public WaveRunner(WaveDto waveDto, GameLoader gameLoader, SpriteBatch spriteBatch){
        this.waveDto            = waveDto;
        this.spriteBatch        = spriteBatch;

        this.gameStateManager   = new GameStateManager();
        this.waveSettings       = new WaveSettings(waveDto.getWaveSettingDto());

        this.hudController      = new HudController(inputListenerManager);
        this.hudController.addActiveHud(new GameOver(null, spriteBatch));

        this.gameOverLayHud     = new GameOverLayHud(spriteBatch);

        this.gameRunningHud     = new GameRunningHud(spriteBatch);
        this.sceneController    = new SceneController(waveDto.getTiledMapDto());
        this.worldController    = new WorldController(waveDto.getWorldDto(), sceneController.getTiledMap());
        this.playerController   = new PlayerController(worldController.getWorld(), waveDto.getPlayerDto(), inputListenerManager);
        this.enemiesController  = new EnemiesController(worldController.getWorld(), playerController.getPlayer().getBodyPosition(), waveSettings.getSpawnConditions() ,waveDto.getEnemyInfoDto(), worldController.getSpawnAreas());

        this.gameOverHud        = new GameOverHud(spriteBatch, this, gameLoader);
        inputListenerManager.addInputProcessor(gameOverHud.getStage());

        setListeners();
    }

    private void setListeners(){
        GameScore gameScore= waveSettings.getGameScore();
        gameScore.getScoreObservers().addObserver(gameRunningHud);
//        gameScore.getScoreObservers().addObserver(enemiesController.getEnemySpawnManager().setSpawnConditions().setScoreBasedSpawnRate(20));

        Subject<Enemy> enemyDeathNotifier= enemiesController.getEnemyDeathManager().getEnemyDeathNotifier();
        enemyDeathNotifier.addObserver(waveSettings.getGameScore());

        Subject<PlayerState> playerStateSubject= playerController.getPlayerStateSubject();
        playerStateSubject.addObserver(gameStateManager);
    }

    public void update(float delta){
        GameState gameState= gameStateManager.getGameState();
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
        waveSettings.update(delta);
        playerController.update(delta);
        enemiesController.update(delta);
    }

//    public void reset(){
//        enemiesController.getEnemyDeathManager().reset();
//        playerController.reset();
//
////        waveSettings.getGameStateManager().setGameState(GameState.RUNNING);
//    }

    public void draw(float delta){
        sceneController.render();
        worldController.render(sceneController.getOrthographicGameCamera());
        spriteBatch.setProjectionMatrix(sceneController.getOrthographicGameCamera().combined);

        spriteBatch.begin();
        playerController.getPlayer().draw(spriteBatch);
        enemiesController.draw(spriteBatch);
        spriteBatch.end();

        gameRunningHud.render(delta);
        GameState gameState= gameStateManager.getGameState();

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
