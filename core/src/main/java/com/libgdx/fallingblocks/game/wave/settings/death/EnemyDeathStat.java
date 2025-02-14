package com.libgdx.fallingblocks.game.wave.settings.death;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;

import java.util.HashMap;
import java.util.Map;

/**
 * Used ONLY to keep track of the number of deaths of each enemy type
 */
public class EnemyDeathStat {

    private Map<EnemyType, Integer> enemyDeathMap= new HashMap<>();

    public EnemyDeathStat(){}
    public EnemyDeathStat(Map<EnemyType, Integer> enemyDeathMap){
        this.enemyDeathMap= enemyDeathMap;
    }

    public int totalEnemyDeath(){
        return enemyDeathMap.values().stream().max(Integer::compareTo).orElse(0);
    }

    public void addEnemyDeath(Enemy enemy){
        EnemyType enemyType= enemy.getEnemyType();
        enemyDeathMap.putIfAbsent(enemyType, 0);
        enemyDeathMap.put(enemyType, enemyDeathMap.get(enemyType)+1);
    }

    public EnemyTypeDeathStat getEnemyTypeDeathStat(EnemyType enemyType){
        int deathCount= enemyDeathMap.getOrDefault(enemyType, 0);
        return new EnemyTypeDeathStat(enemyType, enemyDeathMap.get(enemyType));
    }

    public static class EnemyTypeDeathStat{
        public int deathCount;
        public EnemyType enemyType;

        public EnemyTypeDeathStat(EnemyType enemyType, int deathCount){
            this.enemyType= enemyType;
            this.deathCount= deathCount;
        }
    }

}
