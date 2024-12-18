package com.libgdx.fallingblocks.entity.enemy.strategies.spawnStrategy;

public abstract class SpawnRate implements SpawnStrategy {

    float currentSpawnRate, spawnRateIncrease;

    public SpawnRate(float currentSpawnRate, float spawnRateIncrease){
        this.currentSpawnRate= currentSpawnRate;
        this.spawnRateIncrease= spawnRateIncrease;
    }


}
