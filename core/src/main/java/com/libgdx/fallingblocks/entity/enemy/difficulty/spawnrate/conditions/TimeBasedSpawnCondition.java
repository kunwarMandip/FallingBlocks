package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

public class TimeBasedSpawnCondition implements SpawnCondition {

    private final float spawnRate;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnRate) {
        this.spawnRate = spawnRate;
        this.spawnRateCounter = 0f;
    }

    public void update(float delta) {
        spawnRateCounter += delta;
    }

    @Override
    public boolean shouldSpawn() {
        if(spawnRateCounter < spawnRate){
            return false;
        }

        spawnRateCounter = 0f;
        return true;
    }

}
