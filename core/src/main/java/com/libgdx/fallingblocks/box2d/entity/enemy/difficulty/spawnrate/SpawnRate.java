package com.libgdx.fallingblocks.box2d.entity.enemy.difficulty.spawnrate;

import java.util.ArrayList;
import java.util.List;

public abstract class SpawnRate {

    private final List<SpawnSetterListener> spawnSetterListeners = new ArrayList<>();

    public void addSpawnSetter(SpawnSetterListener spawnSetterListener){
        spawnSetterListeners.add(spawnSetterListener);
    }

    public void removeSpawnSetter(SpawnSetterListener spawnSetterListener){
        spawnSetterListeners.remove(spawnSetterListener);
    }

    protected void notifySpawnSetters(int numEnemiesToSpawn){
        for(SpawnSetterListener spawnSetterListener : spawnSetterListeners){
            spawnSetterListener.setNumEnemyToSpawn(numEnemiesToSpawn);
        }
    }


}
