package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import com.libgdx.fallingblocks.entity.behaviour.AttackBehaviour;
import com.libgdx.fallingblocks.entity.behaviour.MovementBehaviour;
import com.libgdx.fallingblocks.entity.Entity;

public abstract class Enemy extends Entity {
    protected Vector2 speed;
    protected float spawnTime;
    String behavior, effect;


    private AttackBehaviour attackBehaviour;
    private MovementBehaviour movementBehaviour;

    public Enemy(World world, int health, int attackPower, Vector2 spawnPosition, Vector2 bodyDimension) {
        super(world, health, attackPower, spawnPosition, bodyDimension);
    }

}
