package com.libgdx.fallingblocks.entity.enemy.service;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.ScoreBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnSetter;

public class SpawnRateController implements SpawnSetter {

    private int numEnemyToSpawn= 1;

//    public DeathBasedSpawnCondition setDeathBaseSpawnRate(int deathThreshold){
//        return new DeathBasedSpawnCondition(deathThreshold, this);
//    }

    public ScoreBasedSpawnCondition setScoreBasedSpawnRate(int scoreThreshold){
        return new ScoreBasedSpawnCondition(scoreThreshold, this);
    }

    @Override
    public void setNumEnemiesToSpawn(int numEnemyToSpawn) {
        this.numEnemyToSpawn= numEnemyToSpawn;
    }

    public void resetNumEnemyToSpawn(){
        this.numEnemyToSpawn= 0;
    }

    public int getNumEnemyToSpawn(){
        return this.numEnemyToSpawn;
    }
}
