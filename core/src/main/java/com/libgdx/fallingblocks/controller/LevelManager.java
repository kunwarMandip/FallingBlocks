package com.libgdx.fallingblocks.controller;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor;
import com.libgdx.fallingblocks.map.objects.EnemySpawnArea;

public class LevelManager {

    private final World world;
    private final TiledMap tiledMap;
    private final GameLevelDto gameLevelDto;
    private final MapController mapController;
    private final WaveController waveController;

    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
        this.world=world;
        this.tiledMap=tiledMap;
        this.gameLevelDto= new JsonDataExtractor().getGameLevelDto(levelToLoad);
        EnemyWaveDto enemyWaveDto= gameLevelDto.getWaveDtoArray().pop();
        this.waveController = new WaveController(world, enemyWaveDto,getEnemySpawnAreas());
        this.mapController = new MapController(world, tiledMap);
    }

    public void update(float delta) {
        waveController.update(delta);
        mapController.update();
    }

    public void draw(SpriteBatch spriteBatch){
        waveController.draw(spriteBatch);
    }

    private Array<EnemySpawnArea> getEnemySpawnAreas(){
        Array<EnemySpawnArea> enemySpawnAreas= new Array<>();
        MapLayer targetLayer = tiledMap.getLayers().get("EnemySpawn");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            enemySpawnAreas.add(new EnemySpawnArea(world, tiledMap, object));
        }
        return enemySpawnAreas;
    }

}
