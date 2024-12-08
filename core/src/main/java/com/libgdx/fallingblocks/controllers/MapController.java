package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.map.objects.EnemySpawnArea;
import com.libgdx.fallingblocks.map.objects.OuterBound;
import com.libgdx.fallingblocks.map.objects.PlayerWall;

public class MapController {

    private final World world;
    private final TiledMap tiledMap;
    private final Array<EnemySpawnArea> enemySpawnAreas= new Array<>();

    public MapController(World world, TiledMap tiledMap){
        this.world=world;
        this.tiledMap=tiledMap;

        loadWall();
        loadOuterBound();
        loadEnemySpawnLocation();
    }

    public void update(float delta){

    }


    public Array<EnemySpawnArea> getEnemySpawnAreas(){
        return enemySpawnAreas;
    }

    private void loadEnemySpawnLocation(){
        MapLayer targetLayer = tiledMap.getLayers().get("EnemySpawn");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            enemySpawnAreas.add(new EnemySpawnArea(world, tiledMap, object));
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
