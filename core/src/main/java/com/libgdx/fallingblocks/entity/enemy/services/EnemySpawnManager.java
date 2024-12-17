package com.libgdx.fallingblocks.entity.enemy.services;



//todo: Create a dto or something else to allow automatic change of spawnRate
public class EnemySpawnManager{

    private float spawnRate;
    private float spawnRateCounter;

    private int numEnemyToSpawn=0;

    public EnemySpawnManager(){
        reset();
    }

    private void reset(){
        this.spawnRate= 2f;
        this.spawnRateCounter=0f;
    }


    public void update(float delta){
        if(spawnRate > spawnRateCounter){
            spawnRateCounter+=delta;
            return;
        }

        numEnemyToSpawn++;
        spawnRateCounter=0f;
    }

    public int getNumEnemyToSpawn(){
        return numEnemyToSpawn;
    }

    public void resetNumEnemyToSpawn(){
        this.numEnemyToSpawn=0;
    }

}
