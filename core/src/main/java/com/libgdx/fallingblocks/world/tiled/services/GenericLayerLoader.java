package com.libgdx.fallingblocks.world.tiled.services;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.world.tiled.factory.TiledFactory;
import com.libgdx.fallingblocks.world.tiled.objects.TiledObject;


public class GenericLayerLoader implements ObjectLoader{

    private final TiledFactory<? extends TiledObject> factory;

    public GenericLayerLoader(TiledFactory<? extends TiledObject> factory){
        this.factory = factory;
    }

    @Override
    public Array<TiledObject> loadObject(World world, TiledMap tiledMap, MapLayer layer) {
        Array<TiledObject> tiledObjectArray= new Array<>();
        for (RectangleMapObject object : layer.getObjects().getByType(RectangleMapObject.class)) {
            tiledObjectArray.add(factory.loadObject(world, object));
        }
        return tiledObjectArray;
    }
}
