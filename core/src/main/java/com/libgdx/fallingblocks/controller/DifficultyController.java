package com.libgdx.fallingblocks.controller;



import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRateController;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.TimeBasedSpawnCondition;

public class DifficultyController {

    private final SpawnRateController spawnRateController;



    public DifficultyController(){

        this.spawnRateController= new SpawnRateController();

        setSpawnRateController();
    }


    private void setSpawnRateController(){
        spawnRateController.addSpawnCondition(new TimeBasedSpawnCondition(10f));
    }


    public void updateSpawnRate(int score, int numEnemyDied, float delta){
        spawnRateController.update(score, numEnemyDied, delta);
    }

}
