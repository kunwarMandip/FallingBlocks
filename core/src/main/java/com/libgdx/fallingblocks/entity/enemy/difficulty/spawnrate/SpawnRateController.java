package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.DeathBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.ScoreBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.SpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.TimeBasedSpawnCondition;

import java.util.ArrayList;
import java.util.List;

public class SpawnRateController implements SpawnAble {

    private int numEnemyToSpawn=0;

    private final List<SpawnCondition> spawnConditions= new ArrayList<>();

    public void addSpawnCondition(SpawnCondition spawnCondition){
        spawnConditions.add(spawnCondition);
    }


    public void update(int score, int deaths, float delta){

        for(SpawnCondition spawnCondition: spawnConditions){

            if(spawnCondition instanceof TimeBasedSpawnCondition){
                ((TimeBasedSpawnCondition) spawnCondition).update(delta);
            }

            if(spawnCondition instanceof ScoreBasedSpawnCondition){
                ((ScoreBasedSpawnCondition) spawnCondition).update(score);
            }

            if(spawnCondition instanceof DeathBasedSpawnCondition){
                ((DeathBasedSpawnCondition) spawnCondition).update(deaths);
            }

            //Update SpawnRate
            if(spawnCondition.shouldSpawn()){
                numEnemyToSpawn++;
            }
        }
    }

    @Override
    public int getNumEnemyToSpawn(){
        return numEnemyToSpawn;
    }

    @Override
    public void resetNumEnemyToSpawn() {
        this.numEnemyToSpawn =0;
    }

}
