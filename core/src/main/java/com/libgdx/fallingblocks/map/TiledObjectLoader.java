package com.libgdx.fallingblocks.map;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.map.objects.spawnArea.EnemySpawnArea;
import com.libgdx.fallingblocks.map.objects.OuterBound;
import com.libgdx.fallingblocks.map.objects.PlayerWall;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.HashMap;
import java.util.Map;

public class TiledObjectLoader {

    private final  World world;
    private final TiledMap tiledMap;
    private final Map<MovementDirection, Vector2> spawnAreas= new HashMap<>();

    public TiledObjectLoader(World world, TiledMap tiledMap){
        this.world=world;
        this.tiledMap=tiledMap;
        loadWall();
        loadOuterBound();
        loadSpawnAreas();
    }

    public void loadSpawnAreas(){
        MapLayer targetLayer = tiledMap.getLayers().get("EnemySpawn");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            EnemySpawnArea enemySpawnArea= new EnemySpawnArea(world, tiledMap, object);
            spawnAreas.put(enemySpawnArea.getTraversalDirection(), enemySpawnArea.getPosition());
            enemySpawnArea.destroy();
        }
    }

    public void loadWall(){
        MapLayer targetLayer= tiledMap.getLayers().get("Wall");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            new PlayerWall(world, tiledMap, object);
        }
    }

    public void loadOuterBound(){
        MapLayer targetLayer= tiledMap.getLayers().get("OuterBound");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            new OuterBound(world, tiledMap, object);
        }
    }

    public Map<MovementDirection, Vector2> getSpawnAreas() {
        return spawnAreas;
    }
}
