package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;

public class EnemyDto {

    private final EnemyType enemyType;
    private final String spawnDirection;
//    private final Vector2 spawnPosition;

//    public EnemyDto(EnemyType enemyType, Vector2 spawnPosition){
//        this.enemyType=enemyType;
//        this.spawnPosition=spawnPosition;
//    }


    public EnemyDto(EnemyType enemyType, String spawnDirection) {
        this.enemyType = enemyType;
        this.spawnDirection = spawnDirection;
    }

    public EnemyType getEnemyType(){
        return enemyType;
    }

    public String getSpawnDirection() {
        return spawnDirection;
    }
    //    public Vector2 getSpawnPosition(){
//        return spawnPosition;
//    }

}
