package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.observers.Observer;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

public class DeathBasedSpawnCondition extends Spawn implements Observer<Enemy> {

    private int currentDeaths;
    private final int deathThreshold;

    public DeathBasedSpawnCondition(int deathThreshold, SpawnSetter spawnSetter){
        super(spawnSetter);
        this.deathThreshold=deathThreshold;
        this.currentDeaths= 0;
    }


    @Override
    public void notify(Enemy event) {
        currentDeaths++;

        if(currentDeaths % deathThreshold == 0){
            spawnSetter.setNumEnemyToSpawn(1);
            currentDeaths= 0;
        }
    }
}
