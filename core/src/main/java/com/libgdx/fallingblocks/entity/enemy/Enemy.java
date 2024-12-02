package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.behaviour.interfaces.AttackBehaviour;
import com.libgdx.fallingblocks.entity.behaviour.interfaces.MovementBehaviour;
import com.libgdx.fallingblocks.entity.Entity;

public abstract class Enemy extends Entity {
    protected Vector2 speed;
    private AttackBehaviour attackBehaviour;
    private MovementBehaviour movementBehaviour;

    public Enemy(World world, int health, Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed, AttackBehaviour attackBehaviour, MovementBehaviour movementBehaviour) {
        super(world, health, spawnPosition, bodyDimension);
        this.speed=speed;
        this.attackBehaviour=attackBehaviour;
        this.movementBehaviour=movementBehaviour;
    }

    public void performAttack(float delta){
        attackBehaviour.attack(delta);
    }

    public void performMovement(float delta){
        movementBehaviour.movement(delta);
    }

    public void setAttackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
    }

    public void setMovementBehaviour(MovementBehaviour movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }
}
