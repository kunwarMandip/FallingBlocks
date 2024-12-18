package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.controllers.*;
import com.libgdx.fallingblocks.jsonParser.dto.GameDto;
import com.libgdx.fallingblocks.jsonParser.dto.WaveDto;
import com.libgdx.fallingblocks.jsonParser.GameDtoParser;

public class LevelManager {

    private final SpriteBatch spriteBatch;

    private WaveDto waveDto;
    private final GameDto gameDto;

    private final WorldController worldController;
    private final SceneGraphController sceneGraphController;

    private final PlayerController playerController;
    private final EnemiesController enemiesController;


    public LevelManager(int level, SpriteBatch spriteBatch){
        this.gameDto= new GameDtoParser().getGameDto(level);
        this.waveDto = gameDto.getNextWave();

        this.spriteBatch= spriteBatch;

        this.sceneGraphController= new SceneGraphController(waveDto.getTiledMapDto());
        this.worldController = new WorldController(true, waveDto.getWorldDto(), sceneGraphController.getTiledMap());

        this.playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto());
        this.enemiesController = new EnemiesController(worldController.getWorld(),waveDto.getEnemyInfoDto(), worldController.getSpawnAreas());
    }

    public void update(float delta){
        worldController.update();
        sceneGraphController.render();
        playerController.update(delta);
        enemiesController.updateEnemies(delta, playerController.getPlayerPosition());
    }


    public void render(){
        sceneGraphController.render();
        worldController.render(sceneGraphController.getOrthographicGameCamera());
        spriteBatch.setProjectionMatrix(sceneGraphController.getOrthographicGameCamera().combined);

        spriteBatch.begin();
        playerController.draw(spriteBatch);
        enemiesController.draw(spriteBatch);
        spriteBatch.end();
    }



    public void resize(int width, int height){
        sceneGraphController.resize(width, height);
    }



}
