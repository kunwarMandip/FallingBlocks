package com.libgdx.fallingblocks.entity.common.dto;

import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;

public class EnemyDto {

    private final EnemyType enemyType;

    public EnemyDto(EnemyType enemyType){
        this.enemyType = enemyType;
    }

    public EnemyType getEnemyType(){
        return enemyType;
    }
}
