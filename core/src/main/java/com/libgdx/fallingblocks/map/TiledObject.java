package com.libgdx.fallingblocks.map;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

import static com.libgdx.fallingblocks.GlobalVariables.PPM;

public abstract class TiledObject {
    protected World world;
    protected Body body;
    protected Rectangle bounds;
    protected TiledMap tiledMap;
    protected MapObject mapObject;
    protected Fixture fixture;

    public TiledObject(World world, TiledMap tiledMap, MapObject object) {
        this.mapObject = object;
        this.world = world;
        this.tiledMap = tiledMap;
        this.bounds = ((RectangleMapObject) object).getRectangle();

        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        float x = (bounds.getX() + bounds.getWidth() / 2) / PPM;
        float y = (bounds.getY() + bounds.getHeight() / 2) / PPM;
        bodyDef.position.set(x, y);

        body = world.createBody(bodyDef);

        shape.setAsBox(bounds.getWidth() / 2 / PPM, bounds.getHeight() / 2 / PPM);
        fixtureDef.shape = shape;
        fixture = body.createFixture(fixtureDef);

    }

    public void setCategoryFilter(short filterBit) {
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }

}
