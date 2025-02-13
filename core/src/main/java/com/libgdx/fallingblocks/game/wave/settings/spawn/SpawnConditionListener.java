package com.libgdx.fallingblocks.game.wave.settings.spawn;


public class SpawnConditionListener implements SpawnAble {

    private int numEnemiesToSpawn;

    public void addSpawnCondition(Spawn spawnCondition){
        spawnCondition.addListener(this);
    }

    public int getNumEnemiesToSpawn(){
        return numEnemiesToSpawn;
    }

    @Override
    public void setAmountToSpawn(int amountToSpawn) {
        this.numEnemiesToSpawn= amountToSpawn;
    }

}
