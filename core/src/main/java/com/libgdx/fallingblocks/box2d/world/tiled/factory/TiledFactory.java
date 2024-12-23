package com.libgdx.fallingblocks.box2d.world.tiled.factory;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.TiledObject;

public interface TiledFactory <T extends TiledObject>{
    T loadObject(World world, MapObject object);
}
