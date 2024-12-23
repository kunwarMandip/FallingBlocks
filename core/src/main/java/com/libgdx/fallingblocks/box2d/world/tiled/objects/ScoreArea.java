package com.libgdx.fallingblocks.box2d.world.tiled.objects;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class ScoreArea{

    private Rectangle rectangleArea;

    public ScoreArea(World world, TiledMap tiledMap) {
        MapLayer targetLayer= tiledMap.getLayers().get("GameScore");
        for (RectangleMapObject object : targetLayer.getObjects().getByType(RectangleMapObject.class)) {
            this.rectangleArea = object.getRectangle();
        }
    }

    public Rectangle getRectangleArea(){
        return rectangleArea;
    }
}
