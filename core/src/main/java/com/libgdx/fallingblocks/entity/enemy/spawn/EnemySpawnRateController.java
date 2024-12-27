package com.libgdx.fallingblocks.entity.enemy.spawn;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRate;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnSetter;

public class EnemySpawnRateController implements SpawnSetter {

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
