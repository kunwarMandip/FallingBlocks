package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.observers.Subject;

public class SpawnRateConditions implements SpawnAble {

    private final Subject<Integer> spawnAbleListener= new Subject<>();

    public SpawnRateConditions(){
        setSpawnConditions("timed");
    }

    public SpawnRateConditions(String spawnConditions){
        setSpawnConditions(spawnConditions);
    }

    private void setSpawnConditions(String spawnConditions){
        Spawn spawn;
        switch (spawnConditions){
            case "timed":
                spawn = new TimeBasedSpawnCondition(10);
                break;

            case "score":
                spawn= new ScoreBasedSpawnCondition(10);
                break;

            default:
                throw new IllegalStateException("Unknown SpawnConditions");
        }

        spawn.addListener(this);
    }

    public void addSpawnAbleListener(){

    }

    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        spawnAbleListener.notify(amountToSpawn);
    }

}
