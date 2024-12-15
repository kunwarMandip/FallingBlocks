package com.libgdx.fallingblocks.map.objects.spawnArea;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.map.objects.TileObjects;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_ENEMY_SPAWN_AREA;

public class EnemySpawnArea extends TileObjects {

    public EnemySpawnArea(World world, TiledMap tiledMap, MapObject object) {
        super(world, tiledMap, object);
        fixture.setSensor(true);
        fixture.setUserData(this);
        setCategoryFilter(CATEGORY_ENEMY_SPAWN_AREA);
    }

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public MovementDirection getTraversalDirection(){
        String spawnDirection=mapObject.getProperties().get("name", String.class);
        return MovementDirection.valueOf(spawnDirection.toUpperCase());
    }

}
