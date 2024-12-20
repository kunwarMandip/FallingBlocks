package com.libgdx.fallingblocks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.libgdx.fallingblocks.controller.*;
import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.WaveDto;
import com.libgdx.fallingblocks.parser.GameDtoParser;
import com.libgdx.fallingblocks.screen.hud.GameRunningHud;


public class GameRunner {

    private final int level;
    private final SpriteBatch spriteBatch;

    private WaveDto waveDto;
    private final GameDto gameDto;
    private final GameStateController gameStateController;

    private final GameRunningHud gameRunningHud;
    private final WorldController worldController;
    private final SceneController sceneController;
    private final PlayerController playerController;
    private final EnemiesController enemiesController;


    public GameRunner(int level, SpriteBatch spriteBatch){
        this.level=level;
        this.spriteBatch= spriteBatch;

        gameDto= new GameDtoParser().getGameDto(level);
        waveDto = gameDto.getNextWave();

        gameStateController = new GameStateController();

        gameRunningHud = new GameRunningHud(spriteBatch);

        sceneController = new SceneController(waveDto.getTiledMapDto());
        worldController = new WorldController(true, waveDto.getWorldDto(), sceneController.getTiledMap());
        playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto());
        enemiesController = new EnemiesController(worldController.getWorld(),waveDto.getEnemyInfoDto(), worldController.getSpawnAreas());

        gameStateController.addScoreObserver(gameRunningHud);
        enemiesController.addDeathListener(gameStateController.getGameScoreController());
    }


    public void update(float delta){
        worldController.update();
        sceneController.render();
        playerController.update(delta);
        enemiesController.update(delta, playerController.getPlayer().getBodyPosition());
    }


    public void render(float delta){
        sceneController.render();
        worldController.render(sceneController.getOrthographicGameCamera());
        spriteBatch.setProjectionMatrix(sceneController.getOrthographicGameCamera().combined);

        spriteBatch.begin();
        playerController.draw(spriteBatch);
        enemiesController.draw(spriteBatch);
        spriteBatch.end();

        gameRunningHud.render(delta);
    }

    public void resize(int width, int height){
        sceneController.resize(width, height);
        gameRunningHud.resize(width, height);
    }



}
