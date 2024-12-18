package com.libgdx.fallingblocks.jsonParser.dto.levelDto;


import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

public class EnemyDto {

    private final EnemyType enemyType;
    private final MovementDirection movementDirection;

    private final Vector2 speed;
    private final Vector2 spawnPosition;

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
