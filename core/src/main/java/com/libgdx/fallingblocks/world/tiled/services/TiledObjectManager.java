package com.libgdx.fallingblocks.world.tiled.services;


import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.world.tiled.factory.OuterBoundFactory;
import com.libgdx.fallingblocks.world.tiled.objects.TiledObject;

public class TiledObjectManager {

    private final Array<TiledObject> tiledObjectArray= new Array<>();

    public TiledObjectManager(World world, TiledMap tiledMap) {
        MapLayer layer= tiledMap.getLayers().get("OuterBound");
        GenericLayerLoader outerBoundFactory= new GenericLayerLoader(new OuterBoundFactory());
        tiledObjectArray.addAll(outerBoundFactory.loadObject(world, tiledMap, layer));
    }

    public Array<TiledObject> getTiledObjectArray() {
        return tiledObjectArray;
    }
}
