package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.contacts.GameContactListener;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;
import com.libgdx.fallingblocks.box2d.world.tiled.services.TiledObjectLoader;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;

import java.util.Map;


public class WorldController {

    private World world;
    private final TiledObjectLoader tiledObjectLoader;
    private Box2DDebugRenderer box2DDebugRenderer;

    public WorldController(boolean renderDebug, WorldDto worldDto, TiledMap tiledMap){
        world= new World(worldDto.getGravity(), worldDto.isDoSleep());
        tiledObjectLoader= new TiledObjectLoader(world, tiledMap);
        world.setContactListener(new GameContactListener());

        if(renderDebug){
            box2DDebugRenderer= new Box2DDebugRenderer();
            box2DDebugRenderer.SHAPE_STATIC.set(0,0, 0,0);
            box2DDebugRenderer.setDrawBodies(true);
        }
    }

    public void update(){
        world.step(1/60f, 6, 2);
    }

    public void render(OrthographicCamera orthographicGameCamera){
        box2DDebugRenderer.render(world, orthographicGameCamera.combined);
    }

    public Map<MovementDirection, Vector2> getSpawnAreas() {
        return tiledObjectLoader.getSpawnAreas();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
