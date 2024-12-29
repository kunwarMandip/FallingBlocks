package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.entity.common.observers.Observers;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;

import java.util.HashMap;
import java.util.Map;

public class GameStatistics implements Observers<Enemy> {

    private int totalEnemyKilled;
    private final Map<EnemyType, Integer> enemyKillCount= new HashMap<>();

    public GameStatistics(){
        this.totalEnemyKilled= 0;
    }

    public GameStatistics(int totalEnemyKilled){
        this.totalEnemyKilled= totalEnemyKilled;
    }

    @Override
    public void notify(Enemy event) {
        this.totalEnemyKilled++;
    }
}
