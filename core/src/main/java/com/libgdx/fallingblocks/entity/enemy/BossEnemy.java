package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.Entity;

public final class BossEnemy extends Enemy {

    public BossEnemy(World world, int health, int attackPower, Vector2 spawnPosition, Vector2 bodyDimension) {
        super(world, health, attackPower, spawnPosition, bodyDimension);
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
    public void onHit(Entity a, Entity b) {

    }


}
