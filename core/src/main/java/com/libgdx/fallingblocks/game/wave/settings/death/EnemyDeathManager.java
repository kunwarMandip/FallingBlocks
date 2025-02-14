package com.libgdx.fallingblocks.game.wave.settings.death;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.observers.Subject;

import java.util.HashMap;
import java.util.Map;

public class EnemyDeathManager {

    private Map<Enemy, Integer> enemyDeathMap= new HashMap<>();
    private final Subject<Enemy> deathObserver= new Subject<>();

    public EnemyDeathManager(){}
    public EnemyDeathManager(Map<Enemy, Integer> enemyDeathMap){
        this.enemyDeathMap= enemyDeathMap;
    }



    public void addEnemyDeath(Enemy enemy){
        enemyDeathMap.putIfAbsent(enemy, 0);
        enemyDeathMap.put(enemy, enemyDeathMap.get(enemy)+1);




    }



    public Subject<Enemy> getScoreObservers(){
        return deathObserver;
    }

}
