package com.libgdx.fallingblocks.world.tiled.factory;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.world.tiled.objects.generic.OuterBound;

public class OuterBoundFactory implements TiledFactory<OuterBound> {

    @Override
    public OuterBound loadObject(World world, MapObject object) {
        return new OuterBound(world, object);
    }
}
