package com.libgdx.fallingblocks.world.tiled.services;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.world.tiled.objects.TiledObject;

public interface ObjectLoader{
    Array<TiledObject> loadObject(World world, TiledMap tiledMap, MapLayer layer);
}
