package com.libgdx.fallingblocks.box2d.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.listeners.common.EntityDeathObserver;

public class DeathBasedSpawnCondition extends SpawnRate implements EntityDeathObserver<Enemy> {

    private int currentDeaths;
    private final int deathThreshold;

    public DeathBasedSpawnCondition(int deathThreshold) {
        this.deathThreshold = deathThreshold;
        this.currentDeaths = 0;
    }

    @Override
    public void handleEntityDeath(Enemy entity) {
        currentDeaths++;
        if(currentDeaths % deathThreshold ==0){
            notifySpawnSetters(1);
            currentDeaths=0;
        }
    }
}
