package com.libgdx.fallingblocks.entity.enemy.types;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.AttackBehaviour;
import com.libgdx.fallingblocks.entity.common.behaviour.interfaces.Moveable;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_ENEMY;
import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_WALL;

public abstract class Enemy extends Entity {
    protected Vector2 speed;
    private AttackBehaviour attackBehaviour;
    private Moveable moveAble;

    private EnemyType enemyType;

    public Enemy(int health, Vector2 spawnPosition, Vector2 bodyDimension, Vector2 speed, AttackBehaviour attackBehaviour, Moveable moveAble) {
        super(health, spawnPosition, bodyDimension);
        this.speed=speed;
        this.attackBehaviour=attackBehaviour;
        this.moveAble = moveAble;
//        setMaskBit(CATEGORY_ENEMY, (short) ~(CATEGORY_WALL | CATEGORY_ENEMY));
    }

    public EnemyType getEnemyType(){
        return enemyType;
    }

    public void performAttack(float delta){
        attackBehaviour.attack(delta);
    }

    public void performMovement(float delta){
        moveAble.movement(delta);
    }

    public void setAttackBehaviour(AttackBehaviour attackBehaviour) {
        this.attackBehaviour = attackBehaviour;
    }

    public void setMovementBehaviour(Moveable moveAble) {
        this.moveAble = moveAble;
    }

}
