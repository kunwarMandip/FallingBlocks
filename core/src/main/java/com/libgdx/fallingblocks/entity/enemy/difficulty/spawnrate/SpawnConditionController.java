package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.badlogic.gdx.utils.Array;

public class SpawnConditionController implements SpawnAble{

    private int numEnemiesToSpawn;
    private final Array<TimeAble> timedSpawnConditions= new Array<>();

    public void addSpawnCondition(Spawn spawnCondition){
        if(spawnCondition instanceof TimeAble){
            timedSpawnConditions.add((TimeAble) spawnCondition);
        }
        spawnCondition.addListener(this);
    }

    public void removeSpawnCondition(){

    }

    public void update(float delta){
        for(TimeAble timeAble: timedSpawnConditions){
            timeAble.update(delta);
        }
    }

    public int getNumEnemiesToSpawn(){
        return numEnemiesToSpawn;
    }

    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        this.numEnemiesToSpawn= amountToSpawn;
    }
}
