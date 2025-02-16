package com.libgdx.fallingblocks.game.wave.settings.death;

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

    /**
     * @return a map of the total number of deaths of each enemy type
     */
    public Map<EnemyType, Integer> totalEnemyDeath(){
        return enemyDeathMap;
    }


    /**
     * Records the death the give enemyType to the map
     * @param enemyType @EnemyType the enemy type that died
     */
    public void addEnemyDeath(EnemyType enemyType){
        enemyDeathMap.putIfAbsent(enemyType, 0);
        enemyDeathMap.put(enemyType, enemyDeathMap.get(enemyType)+1);
    }


    /**
     * @param enemyType @EnemyType Enemy type to get the death count of
     * @return Total number of times the given enemy type has died
     */
    public EnemyTypeDeathStat getEnemyTypeDeathStat(EnemyType enemyType){
        int deathCount= enemyDeathMap.getOrDefault(enemyType, 0);
        return new EnemyTypeDeathStat(enemyType, enemyDeathMap.get(enemyType));
    }


}
