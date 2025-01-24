package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public abstract class Spawn {

    protected SpawnAble spawnAble;

    public void addListener(SpawnAble spawnAble){
        this.spawnAble= spawnAble;
    }
}
