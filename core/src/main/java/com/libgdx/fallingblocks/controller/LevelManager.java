package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor;

public class LevelManager {

    private final GameLevelDto gameLevelDto;

    private TiledMapController tiledMapController;
    private EnemyWavesController enemyWavesController;

    private boolean isWaveDurationElapsed =false;

    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
        JsonDataExtractor jsonDataExtractor= new JsonDataExtractor();
        this.gameLevelDto =jsonDataExtractor.getGameLevelDto(levelToLoad);

        EnemyWaveDto enemyWaveDto= gameLevelDto.getWaveDtoArray().pop();
        this.enemyWavesController= new EnemyWavesController(this, enemyWaveDto);
        this.tiledMapController= new TiledMapController(world, tiledMap);
    }


    public void update(float delta) {
        enemyWavesController.update(delta);
        tiledMapController.update();
    }

    public void draw(SpriteBatch spriteBatch){
        enemyWavesController.draw(spriteBatch);
    }



    public void setWaveDurationComplete(){
        this.isWaveDurationElapsed=true;
    }


}
