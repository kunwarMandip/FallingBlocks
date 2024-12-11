package com.libgdx.fallingblocks.gameDto.levelDto;


import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;

public class EnemyDto {

    private final EnemyType enemyType;
    private final String spawnDirection;
    private final Vector2 spawnPosition;

    public EnemyDto(EnemyType enemyType, String spawnDirection, Vector2 spawnPosition) {
        this.enemyType = enemyType;
        this.spawnDirection = spawnDirection;
        this.spawnPosition = spawnPosition;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public Vector2 getSpawnPosition() {
        return spawnPosition;
    }

    public String getSpawnDirection() {
        return spawnDirection;
    }
}
