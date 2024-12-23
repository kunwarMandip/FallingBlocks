package com.libgdx.fallingblocks.box2d.world.tiled.objects.generic;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.TiledObject;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_WALL;

/**
 * Creates a closed Group of Box2D bodies where enemies can't escape from
 */
public class PlayerWall extends TiledObject {

    public PlayerWall(World world, MapObject object) {
        super(world, object);
        fixture.setUserData(this);
        setCategoryFilter(CATEGORY_WALL);
    }

}
