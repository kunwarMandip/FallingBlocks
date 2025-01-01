package com.libgdx.fallingblocks.parser.dto.levelDto;


import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;

public class EnemyDto {

    public EnemyType enemyType;
    public MovementDirection movementDirection;

    public Vector2 speed;
    public Vector2 spawnPosition;
    public Vector2 bodyDimension;;

    public EnemyDto(EnemyType enemyType, MovementDirection movementDirection, Vector2 speed, Vector2 spawnPosition) {
        this.enemyType = enemyType;
        this.movementDirection = movementDirection;
        this.speed = speed;
        this.spawnPosition = spawnPosition;
    }


    public EnemyType getEnemyType() {
        return enemyType;
    }

    public Vector2 getSpawnPosition() {
        return spawnPosition;
    }

    public MovementDirection getMovementDirection() {
        return movementDirection;
    }

    public Vector2 getSpeed() {
        return speed;
    }
}
