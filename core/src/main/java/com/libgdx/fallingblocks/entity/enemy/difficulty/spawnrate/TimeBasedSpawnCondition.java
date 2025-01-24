package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class TimeBasedSpawnCondition extends Spawn implements TimeAble{

    private float spawnTimer;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnTimer, SpawnAble spawnAble) {
        this.spawnTimer = spawnTimer;
        this.spawnRateCounter= 0f;
    }

    @Override
    public void update(float delta) {
        if(spawnRateCounter < spawnTimer){
            spawnRateCounter += delta;
            return;
        }

        spawnAble.setAmountToSpawn(1);
        spawnRateCounter = 0f;
    }
}
