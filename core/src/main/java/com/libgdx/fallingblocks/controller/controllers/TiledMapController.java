package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.TiledMapDto;
import com.libgdx.fallingblocks.map.TiledObjectLoader;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;

public class TiledMapController {

    private final TiledMap tiledMap;
    private final TiledMapDto tiledMapDto;
    private final TiledObjectLoader tiledObjectLoader;

    public TiledMapController(World world, TiledMapDto tiledMapDto){
        this.tiledMapDto= tiledMapDto;
        this.tiledMap= new TmxMapLoader().load(tiledMapDto.getMapPath());
        this.tiledObjectLoader= new TiledObjectLoader(world, tiledMap);
    }


    public void update(float delta){
    }

    public Map<MovementDirection, Vector2> getSpawnAreas() {
        return tiledObjectLoader.getSpawnAreas();
    }
}
