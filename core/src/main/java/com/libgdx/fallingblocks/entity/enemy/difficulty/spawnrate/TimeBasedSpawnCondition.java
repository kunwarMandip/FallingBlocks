package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class TimeBasedSpawnCondition extends SpawnRate implements Timed {

    private final float spawnRate;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnRate) {
        this.spawnRate = spawnRate;
        this.spawnRateCounter = 0f;
    }

    @Override
    public void update(float delta) {
        spawnRateCounter += delta;
        if (spawnRateCounter >= spawnRate) {
            notifySpawnSetters(1);
            spawnRateCounter = 0f;
        }
    }
}
