package com.libgdx.fallingblocks.entity.enemy.types;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.animation.Animation;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.RangeAttack;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.SlowMovement;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

public final class NormalEnemy extends Enemy {

    private final Animation animation;
    public NormalEnemy(Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed) {
        super(1, spawnPosition, bodyDimension, speed, new RangeAttack(), new SlowMovement());
        this.animation= new Animation(new Vector2(5, 5), new Texture("map/images/arrows/arrow.png"));
    }

    @Override
    public void update(float delta) {
        body.setLinearVelocity(speed);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        animation.draw(getBodyPosition(), spriteBatch);
    }

    @Override
    public void onDeath(Entity entity) {

    }


    @Override
    public void collide(Entity entity) {

    }

    @Override
    public void onHit(Entity entity) {

    }
}
