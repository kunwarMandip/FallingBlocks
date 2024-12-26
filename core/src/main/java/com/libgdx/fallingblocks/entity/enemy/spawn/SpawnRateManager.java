package com.libgdx.fallingblocks.entity.enemy.spawn;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRate;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.TimeBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.Timed;

import java.util.ArrayList;
import java.util.List;

public class SpawnRateManager {

    private final EnemySpawnRateController enemySpawnRateController;
    private final List<Timed> timeBasedSpawnRate= new ArrayList<>();

    public SpawnRateManager(){
        this.enemySpawnRateController= new EnemySpawnRateController();
    }

    public void addListeners(SpawnRate spawnRate){
        if(spawnRate instanceof TimeBasedSpawnCondition){
            timeBasedSpawnRate.add(((TimeBasedSpawnCondition) spawnRate));
        }
        enemySpawnRateController.addListeners(spawnRate);
    }

    public void update(float delta){
        for(Timed timed: timeBasedSpawnRate){
            timed.update(delta);
        }
    }
}
