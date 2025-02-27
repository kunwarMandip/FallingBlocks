package com.libgdx.fallingblocks.game.wave.settings.spawn;

import com.libgdx.fallingblocks.Logger;

public class SpawnConditionListener implements SpawnAble {

    private int numEnemiesToSpawn;

    public SpawnConditionListener(){
        this.numEnemiesToSpawn= 0;
    }

    public SpawnConditionListener(int numEnemiesToSpawn){
        this.numEnemiesToSpawn= numEnemiesToSpawn;
    }

    public void addSpawnCondition(Spawn spawnCondition){
        spawnCondition.addListener(this);
    }

    public int getNumEnemiesToSpawn(){
        int tmp= numEnemiesToSpawn;
        this.numEnemiesToSpawn=0;
        return tmp;
    }

    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        Logger.log(Logger.Tags.SPAWN_CONDITION, "Setting amount to spawn to: " + amountToSpawn);
        this.numEnemiesToSpawn= amountToSpawn;
    }

}
