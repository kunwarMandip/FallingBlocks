package com.libgdx.fallingblocks.game.spawn;

public class EnemySpawn implements SpawnAble {

    private int numEnemyToSpawn;

    public EnemySpawn(){
        this.numEnemyToSpawn= 1;
    }

    public EnemySpawn(int numEnemyToSpawn){
        this.numEnemyToSpawn= numEnemyToSpawn;
    }

    public int getNumEnemyToSpawn(){
        return this.numEnemyToSpawn;
    }

    @Override
    public void setNumToSpawn(int numToSpawn) {
        this.numEnemyToSpawn= numToSpawn;
    }
}
