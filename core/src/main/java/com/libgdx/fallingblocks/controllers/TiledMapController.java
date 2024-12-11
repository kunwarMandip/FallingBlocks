package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.TiledMapDto;

import java.util.HashMap;
import java.util.Map;

public class TiledMapController {

    private TiledMap tiledMap;
    private TiledMapDto tiledMapDto;
    private final Map<String, Vector2> spawnAreas= new HashMap<>();

    public TiledMapController(World world, TiledMapDto tiledMapDto){
        this.tiledMapDto= tiledMapDto;
        this.tiledMap= new TiledMap();
    }

    public void update(float delta){

    }

    public Map<String, Vector2> getSpawnAreas() {
        return spawnAreas;
    }
}
