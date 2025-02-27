package com.libgdx.fallingblocks.game.wave.settings.death;

import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;


public class EnemyTypeDeathStat{

    private final int deathCount;
    private final EnemyType enemyType;

    public EnemyTypeDeathStat(EnemyType enemyType, int deathCount){
        this.enemyType= enemyType;
        this.deathCount= deathCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
