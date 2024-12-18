package com.libgdx.fallingblocks.entity.enemy.strategies.spawnStrategy;

public class KillBasedSpawn implements SpawnStrategy {

    float spawnRate, spawnRateIncrement;

    public KillBasedSpawn(float spawnRate, float spawnRateIncrement){
        this.spawnRate=spawnRate;
        this.spawnRateIncrement=spawnRateIncrement;
    }


    @Override
    public void spawnEnemy(float delta) {
        spawnRate+=spawnRateIncrement;
    }
}
