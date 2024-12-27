package com.libgdx.fallingblocks.entity.enemy.types;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.abilites.movement.DashMovement;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.MeleeAttack;

public final class QuickEnemy extends Enemy {

    public QuickEnemy(Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed) {
        super(2, spawnPosition, bodyDimension, speed, new MeleeAttack(), new DashMovement());
    }

    @Override
    public void update(float delta) {

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
