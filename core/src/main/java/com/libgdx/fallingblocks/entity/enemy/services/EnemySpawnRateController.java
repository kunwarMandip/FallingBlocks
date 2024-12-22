package com.libgdx.fallingblocks.entity.enemy.services;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRate;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnSetterListener;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.TimeBasedSpawnCondition;

import java.util.ArrayList;
import java.util.List;

public class EnemySpawnRateController implements SpawnSetterListener {

    private int numEnemyToSpawn=0;
    private final List<SpawnRate> activeSpawnRate= new ArrayList<>();

    public void addListener(SpawnRate spawnRate){
        spawnRate.addSpawnSetter(this);
        if(spawnRate instanceof TimeBasedSpawnCondition){
            this.activeSpawnRate.add(spawnRate);
        }
    }

    public void update(float delta){
        for(SpawnRate spawnRate : activeSpawnRate){
            if(spawnRate instanceof TimeBasedSpawnCondition){
                ((TimeBasedSpawnCondition) spawnRate).update(delta);
            }
        }
    }

    @Override
    public void setNumEnemyToSpawn(int numEnemyToSpawn) {
        this.numEnemyToSpawn+=numEnemyToSpawn;
    }

    public int getNumEnemyToSpawn(int numEnemyToSpawn){
        return this.numEnemyToSpawn;
    }
}
