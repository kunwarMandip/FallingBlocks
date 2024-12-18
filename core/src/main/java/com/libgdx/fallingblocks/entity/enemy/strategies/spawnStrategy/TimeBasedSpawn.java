package com.libgdx.fallingblocks.entity.enemy.strategies.spawnStrategy;

public class TimeBasedSpawn extends SpawnRate {

    private float spawnRateIncreaseDelay, spawnRateIncreaseTimer;

    private boolean spawn= false;
    public TimeBasedSpawn(float spawnRate, float spawnRateIncrement,
                          float spawnRateIncreaseDelay, float spawnRateIncreaseTimer){
        super(spawnRate, spawnRateIncrement);
        this.spawnRateIncreaseDelay= spawnRateIncreaseDelay;
        this.spawnRateIncreaseTimer= spawnRateIncreaseTimer;
    }

    @Override
    public void spawnEnemy(float delta) {

        if(spawnRateIncreaseTimer >=  spawnRateIncreaseDelay){
            spawn= true;
            return;
        }

        spawn
    }
}
