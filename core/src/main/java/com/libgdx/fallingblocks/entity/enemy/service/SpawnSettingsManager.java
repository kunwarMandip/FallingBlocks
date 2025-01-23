package com.libgdx.fallingblocks.entity.enemy.service;

public class SpawnSettingsManager{

    private int numEnemiesToSpawn;

    public SpawnSettingsManager(){
        numEnemiesToSpawn= 0;
    }

    public SpawnSettingsManager(int numEnemiesToSpawn){
        this.numEnemiesToSpawn= numEnemiesToSpawn;
    }

    public int getNumEnemiesToSpawn() {
        return numEnemiesToSpawn;
    }

    public void setNumEnemiesToSpawn(int numEnemiesToSpawn) {
        this.numEnemiesToSpawn = numEnemiesToSpawn;
    }

}
