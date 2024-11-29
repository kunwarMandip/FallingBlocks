package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor;

public class LevelManager {

    private final MapController mapController;
    private final EnemyWavesController enemyWavesController;

    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
        JsonDataExtractor jsonDataExtractor= new JsonDataExtractor();
        GameLevelDto gameLevelDto =jsonDataExtractor.getGameLevelDto(levelToLoad);
        this.enemyWavesController= new EnemyWavesController(world,gameLevelDto.getWaveDtoArray());
        this.mapController = new MapController(world, tiledMap);
    }

    public void update(float delta) {
        enemyWavesController.update(delta);
        mapController.update();
    }

    public void draw(SpriteBatch spriteBatch){
        enemyWavesController.draw(spriteBatch);
    }

}
