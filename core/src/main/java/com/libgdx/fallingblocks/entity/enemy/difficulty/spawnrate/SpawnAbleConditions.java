package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public class SpawnAbleConditions implements SpawnAble {

    private int amountToSpawn;

    public SpawnAbleConditions(){
        this.amountToSpawn= 0;
    }
    public SpawnAbleConditions(int amountToSpawn){
        this.amountToSpawn= amountToSpawn;
    }

    public void addListener(Spawn spawn){
        spawn.addListener(this);
    }

    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        this.amountToSpawn = amountToSpawn;
    }

    public int getAmountToSpawn(){
        int tempAmountToSpawn= amountToSpawn;
        this.amountToSpawn= 0;
        return tempAmountToSpawn;
    }
}
