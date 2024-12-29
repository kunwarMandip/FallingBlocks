package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

public abstract class Spawn {

    protected final SpawnSetter spawnSetter;

    public Spawn(SpawnSetter spawnSetter){
        this.spawnSetter = spawnSetter;
    }
}
