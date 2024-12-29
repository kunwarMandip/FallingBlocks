package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class TimeBasedSpawnCondition extends Spawn {

    private final float spawnRate;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnRate, SpawnSetter spawnSetter) {
        super(spawnSetter);
        this.spawnRate= spawnRate;
        this.spawnRateCounter= 0f;
    }

    public void update(float delta) {
        if(spawnRateCounter < spawnRate){
            spawnRateCounter += delta;
            return;
        }

        spawnSetter.setNumEnemyToSpawn(1);
        spawnRateCounter = 0f;
    }
}
