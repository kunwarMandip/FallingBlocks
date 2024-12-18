package com.libgdx.fallingblocks.entity.enemy.difficulty.spawn;

public class DeathSpawnRateManager implements SpawnStrategy {

    private float spawnRate, spawnRateIncrement;

    public DeathSpawnRateManager(float spawnRate, float spawnRateIncrement){
        this.spawnRate=spawnRate;
        this.spawnRateIncrement=spawnRateIncrement;
    }


    @Override
    public void updateSpawnRate(float delta) {
        spawnRate+=spawnRateIncrement;
    }
}
