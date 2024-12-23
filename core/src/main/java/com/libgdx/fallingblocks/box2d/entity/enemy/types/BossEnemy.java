package com.libgdx.fallingblocks.box2d.entity.enemy.types;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.entity.common.Entity;
import com.libgdx.fallingblocks.box2d.entity.common.behaviour.strategies.DashMovement;
import com.libgdx.fallingblocks.box2d.entity.common.behaviour.strategies.MeleeAttack;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;

public final class BossEnemy extends Enemy {

    public BossEnemy(World world, Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed) {
        super(5,  world, spawnPosition, bodyDimension, speed, new MeleeAttack(), new DashMovement());
    }

    @Override
    public void update(float delta) {
        body.setLinearVelocity(new Vector2( -0.5f, -0.5f));
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
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
