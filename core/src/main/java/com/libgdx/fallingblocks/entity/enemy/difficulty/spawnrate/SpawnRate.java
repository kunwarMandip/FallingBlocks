package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import java.util.ArrayList;
import java.util.List;

public abstract class SpawnRate {

    private final List<SpawnSetter> spawnSetter = new ArrayList<>();


    public void addSpawnSetter(SpawnSetter spawnSetter){
        this.spawnSetter.add(spawnSetter);
    }

    public void removeSpawnSetter(SpawnSetter spawnSetter){
        this.spawnSetter.remove(spawnSetter);
    }

    protected void notifySpawnSetters(int numEnemiesToSpawn){
        for(SpawnSetter spawnSetter : this.spawnSetter){
            spawnSetter.setNumEnemyToSpawn(numEnemiesToSpawn);
        }
    }


}
