package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.dto.TiledMapDto;
import com.libgdx.fallingblocks.map.objects.EnemySpawnArea;
import com.libgdx.fallingblocks.map.objects.OuterBound;
import com.libgdx.fallingblocks.map.objects.PlayerWall;

import java.util.HashMap;
import java.util.Map;

public class TiledMapController {

    private final World world;
    private final TiledMap tiledMap;

    private TiledMapDto tiledMapDto;

    private final Map<String, Vector2> spawnAreas= new HashMap<>();
    public TiledMapController(World world, TiledMap tiledMap){
        this.world=world;
        this.tiledMap=tiledMap;

        loadWall();
        loadOuterBound();
        loadSpawnAreas();
    }

    public TiledMapController(World world, TiledMapDto tiledMapDto){
        this.world= world;
        this.tiledMapDto= tiledMapDto;
        this.tiledMap= new TiledMap();
    }

    public void update(float delta){

    }

    public Map<String, Vector2> getSpawnAreas() {
        return spawnAreas;
    }


    private void loadSpawnAreas(){
        MapLayer targetLayer = tiledMap.getLayers().get("EnemySpawn");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            EnemySpawnArea enemySpawnArea= new EnemySpawnArea(world, tiledMap, object);
            spawnAreas.put(enemySpawnArea.getSpawnDirection(), enemySpawnArea.getPosition());
            enemySpawnArea.destroy();
        }
    }

    private void loadWall(){
        MapLayer targetLayer= tiledMap.getLayers().get("Wall");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            new PlayerWall(world, tiledMap, object);
        }
    }

    private void loadOuterBound(){
        MapLayer targetLayer= tiledMap.getLayers().get("OuterBound");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            new OuterBound(world, tiledMap, object);
        }
    }

}
