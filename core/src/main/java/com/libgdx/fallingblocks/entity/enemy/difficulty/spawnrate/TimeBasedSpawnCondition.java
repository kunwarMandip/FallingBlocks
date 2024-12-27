package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class TimeBasedSpawnCondition extends SpawnRate {

    private final float spawnRate;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnRate) {
        this.spawnRate = spawnRate;
        this.spawnRateCounter = 0f;
    }

    public void update(float delta) {
        if(spawnRateCounter < spawnRate){
            spawnRateCounter += delta;
            return;
        }

        notifySpawnSetters(1);
        spawnRateCounter = 0f;
    }
}
