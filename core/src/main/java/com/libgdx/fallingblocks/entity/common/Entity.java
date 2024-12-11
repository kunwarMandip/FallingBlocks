package com.libgdx.fallingblocks.entity.common;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.DeathBehaviour;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.OnHitBehaviour;


public abstract class Entity implements DeathBehaviour, OnHitBehaviour {

    //Box2d setters
    protected Body body;
    protected Fixture fixture;

    protected int health;
    protected boolean isDead;
    protected Vector2 spawnPosition, bodyDimension;

    public Entity(World world, int health, Vector2 spawnPosition, Vector2 bodyDimension){
        this.isDead=false;
        this.health=health;
        this.spawnPosition=spawnPosition;
        this.bodyDimension=bodyDimension;
        setBody(world);
    }

    public abstract void update(float delta);

    public abstract void draw(SpriteBatch spriteBatch);

    public void setToDestroy(){
        isDead=true;
    }

    protected void setBody(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(spawnPosition.x, spawnPosition.y);
        bodyDef.fixedRotation = true;
        body = world.createBody(bodyDef);

        //Create shape for the body
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(bodyDimension.x, bodyDimension.y);

        // Creates fixture definition and applies to body
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectangleShape;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 0.0f;

        fixture= body.createFixture(fixtureDef);
        fixture.setUserData(this);
        rectangleShape.dispose();
    }

    public void setCategoryFilter(short filterBit) {
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        fixture.setFilterData(filter);
    }

    public void setMaskBit(short filterBit, short maskBit) {
        Filter filter = new Filter();
        filter.categoryBits = filterBit;
        filter.maskBits=maskBit;
        fixture.setFilterData(filter);
    }

    public void destroyBody(World world){
        world.destroyBody(body);
    }

    public Vector2 getBodyDimension(){
        return bodyDimension;
    }

    public void setBodyDimension(Vector2 bodyDimension){
        this.bodyDimension=bodyDimension;
    }
}
