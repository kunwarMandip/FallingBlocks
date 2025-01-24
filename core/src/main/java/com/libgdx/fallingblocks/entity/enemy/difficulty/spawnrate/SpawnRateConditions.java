package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.observers.Subject;

public class SpawnRateConditions implements SpawnAble {

    private final Subject<Integer> spawnAbleListener= new Subject<>();

    public void addSpawnCondition(Spawn spawn){
        spawn.addListener(this);
    }


    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        spawnAbleListener.notify(amountToSpawn);
    }


}
