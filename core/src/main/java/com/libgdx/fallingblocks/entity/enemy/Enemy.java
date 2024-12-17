package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector4;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.AttackBehaviour;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.MovementBehaviour;
import com.libgdx.fallingblocks.entity.common.Entity;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_ENEMY;
import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_WALL;

public abstract class Enemy extends Entity {
    protected Vector2 speed;
    private AttackBehaviour attackBehaviour;
    private MovementBehaviour movementBehaviour;

    public Enemy(int health, Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed, AttackBehaviour attackBehaviour, MovementBehaviour movementBehaviour) {
        super(health, spawnPosition, bodyDimension);
        this.speed=speed;
        this.attackBehaviour=attackBehaviour;
        this.movementBehaviour=movementBehaviour;
//        setMaskBit(CATEGORY_ENEMY, (short) ~(CATEGORY_WALL | CATEGORY_ENEMY));
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
