package com.libgdx.fallingblocks.entity.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.animation.Animation;

public class Player extends Entity {
    private final Animation animation;
    public Player(int health, Vector2 spawnPosition, Vector2 bodyDimension) {
        super(health, spawnPosition, bodyDimension);
        this.animation= new Animation(bodyDimension, new Texture("map/images/arrows/arrow.png"));
    }

    @Override
    public void update(float delta) {
//        body.setLinearVelocity(new Vector2(5, 5));
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        animation.draw( getBodyPosition(), spriteBatch);

    }

    @Override
    public void onDeath(Entity entity) {

    }

    @Override
    public void onHit(Entity a, Entity b) {

    }

    @Override
    public void collide(Entity entity) {

    }
}
