package com.libgdx.fallingblocks.entity.enemy.strategies.spawnStrategy;


public class FixedRateSpawn extends SpawnRate {

    public FixedRateSpawn(float currentSpawnRate, float spawnRateIncrease) {
        super(currentSpawnRate, spawnRateIncrease);
    }

    @Override
    public void spawnEnemy(float delta) {
    }
}
