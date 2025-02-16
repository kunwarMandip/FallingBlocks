package com.libgdx.fallingblocks.game.wave.settings.death;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;
import com.libgdx.fallingblocks.observers.Subject;

import java.util.Map;

/**
 * Responsible for notifying the death of an enemy.
 * Keeps track of the number of deaths of each enemy type.
 */
public class EnemyDeathManager {

    private final EnemyDeathStat enemyDeathStat;
    private final Subject<Enemy> deathObserver= new Subject<>();

    public EnemyDeathManager(){
        this.enemyDeathStat= new EnemyDeathStat();
    }
    public EnemyDeathManager(Map<EnemyType, Integer> enemyDeathMap){
        this.enemyDeathStat= new EnemyDeathStat(enemyDeathMap);
    }


    public Subject<Enemy> getDeathObserver(){
        return deathObserver;
    }

}
