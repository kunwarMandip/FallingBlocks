package com.libgdx.fallingblocks.box2d.entity.enemy.services;

import com.libgdx.fallingblocks.box2d.entity.enemy.difficulty.spawnrate.SpawnRate;
import com.libgdx.fallingblocks.box2d.entity.enemy.difficulty.spawnrate.SpawnSetterListener;

public class EnemySpawnRateController implements SpawnSetterListener {

    private int numEnemyToSpawn=0;

    public void addListeners(SpawnRate spawnRate){
        spawnRate.addSpawnSetter(this);
    }

    @Override
    public void setNumEnemyToSpawn(int numEnemyToSpawn) {
        this.numEnemyToSpawn+=numEnemyToSpawn;
    }

    public int getNumEnemyToSpawn(){
        int tempNumEnemyToSpawn= numEnemyToSpawn;
        this.numEnemyToSpawn=0;
        return tempNumEnemyToSpawn;
    }
}
