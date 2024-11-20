package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.map.TiledObjectLoader;

public class TiledMapController {

    private TiledObjectLoader tiledObjectLoader;

    public TiledMapController(World world, TiledMap tiledMap){
        tiledObjectLoader= new TiledObjectLoader(world, tiledMap);
    }
}
