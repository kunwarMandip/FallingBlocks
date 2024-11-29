package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.map.TiledObjectLoader;

public class MapController {

    private TiledMap tiledMap;
    private final TiledObjectLoader tiledObjectLoader;

    public MapController(World world, TiledMap tiledMap){
        this.tiledMap=tiledMap;
        tiledObjectLoader= new TiledObjectLoader(world, tiledMap);
    }

    public void update(){

    }
}
