package com.libgdx.fallingblocks.map.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.map.TileObjects;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_WALL;

/**
 * Creates a closed Group of Box2D bodies where enemies can't escape from
 */
public class PlayerWall extends TileObjects {
    public PlayerWall(World world, TiledMap tiledMap, MapObject object) {
        super(world, tiledMap, object);
        fixture.setUserData(this);
        setCategoryFilter(CATEGORY_WALL);
    }
}
