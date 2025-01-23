package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class TimeBasedSpawnCondition implements TimeAble{

    private float spawnTimer;
    private float spawnRateCounter;
    private final SpawnSetter spawnSetter;

    public TimeBasedSpawnCondition(float spawnTimer, SpawnSetter spawnSetter) {
        this.spawnTimer = spawnTimer;
        this.spawnRateCounter= 0f;
        this.spawnSetter= spawnSetter;
    }

    @Override
    public void update(float delta) {
        if(spawnRateCounter < spawnTimer){
            spawnRateCounter += delta;
            return;
        }

        spawnSetter.setNumEnemiesToSpawn(1);
        spawnRateCounter = 0f;
    }
}
