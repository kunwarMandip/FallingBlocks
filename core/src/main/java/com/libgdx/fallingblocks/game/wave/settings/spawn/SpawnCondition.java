package com.libgdx.fallingblocks.game.wave.settings.spawn;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.observers.TimeAble;

public class SpawnCondition implements SpawnAble {

    private int numEnemiesToSpawn;
    private final Array<Spawn> spawnConditions= new Array<>();
    private final Array<TimeAble> timedSpawnConditions= new Array<>();

    public void addSpawnCondition(Spawn spawnCondition){
        if(spawnCondition instanceof TimeAble){
            timedSpawnConditions.add((TimeAble) spawnCondition);
        }else{
            spawnConditions.add(spawnCondition);
        }
        spawnCondition.addListener(this);
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
