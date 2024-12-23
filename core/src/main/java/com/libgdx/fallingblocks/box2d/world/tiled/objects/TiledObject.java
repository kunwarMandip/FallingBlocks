package com.libgdx.fallingblocks.box2d.world.tiled.objects;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
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

    public TiledObject(World world, MapObject object) {
        this.mapObject = object;
        this.world = world;
        this.bounds = ((RectangleMapObject) object).getRectangle();

        BodyDef bodyDef = new BodyDef();
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set((bounds.getX() + bounds.getWidth() / 2) / PPM, (bounds.getY() + bounds.getHeight() / 2) / PPM);

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

    public TiledMapTileLayer.Cell getCell(TiledMap tiledMap) {
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        return layer.getCell((int) (body.getPosition().x * PPM / 16),
                (int) (body.getPosition().y * PPM / 16));
    }

    public void destroy(){
        world.destroyBody(body);
    }
}

