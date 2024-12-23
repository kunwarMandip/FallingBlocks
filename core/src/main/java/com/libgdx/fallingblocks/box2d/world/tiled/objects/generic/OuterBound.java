package com.libgdx.fallingblocks.box2d.world.tiled.objects.generic;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.TiledObject;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_OUTER_BOUND;

/**
 * Responsible for deleting the enemy when they touch the outerBound of the tiledMap
 */
public class OuterBound extends TiledObject {
    public OuterBound(World world, MapObject object) {
        super(world, object);
        fixture.setSensor(true);
        fixture.setUserData(this);
        setCategoryFilter(CATEGORY_OUTER_BOUND);
    }
}
