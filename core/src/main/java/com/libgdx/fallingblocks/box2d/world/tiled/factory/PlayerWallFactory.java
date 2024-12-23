package com.libgdx.fallingblocks.box2d.world.tiled.factory;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.generic.PlayerWall;

public class PlayerWallFactory implements TiledFactory<PlayerWall> {

    @Override
    public PlayerWall loadObject(World world, MapObject object) {
        return new PlayerWall(world, object);
    }
}
