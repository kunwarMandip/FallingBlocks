package com.libgdx.fallingblocks.game.wave.settings.spawn;

public abstract class Spawn {

    protected SpawnAble spawnAble;

    public void addListener(SpawnAble spawnAble){
        this.spawnAble= spawnAble;
    }

    public void removeListener(){
        this.spawnAble=null;
    }
}
