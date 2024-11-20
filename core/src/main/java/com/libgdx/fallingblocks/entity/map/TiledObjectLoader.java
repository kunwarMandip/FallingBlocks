package com.libgdx.fallingblocks.entity.map;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.map.objects.EnemySpawnArea;
import com.libgdx.fallingblocks.entity.map.objects.OuterBound;
import com.libgdx.fallingblocks.entity.map.objects.PlayerWall;


public class TiledObjectLoader {

    private final World world;
    private final TiledMap tiledMap;

    public TiledObjectLoader(World world, TiledMap tiledMap){
        this.world=world;
        this.tiledMap=tiledMap;
        loadWall();
        loadOuterBound();
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

    private void loadEnemySpawnArea(){
        MapLayer targetLayer = tiledMap.getLayers().get("EnemySpawn");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            new EnemySpawnArea(world, tiledMap, object);
        }
    }



}
