package com.libgdx.fallingblocks.entity.enemy.types;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.Entity;
import com.libgdx.fallingblocks.entity.behaviour.interfaces.AttackBehaviour;
import com.libgdx.fallingblocks.entity.behaviour.interfaces.MovementBehaviour;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

public final class BossEnemy extends Enemy {

    public BossEnemy(World world, int health, Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed, AttackBehaviour attackBehaviour, MovementBehaviour movementBehaviour) {
        super(world, health, spawnPosition, bodyDimension, speed, attackBehaviour, movementBehaviour);
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
    public void onHit(Entity a, Entity b) {

    }


}
