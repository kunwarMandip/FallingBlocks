package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.WorldDto;


public class WorldController {

    private World world;
    public WorldController(WorldDto worldDto){
        this.world= new World(worldDto.getGravity(), worldDto.isDoSleep());
    }


    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
