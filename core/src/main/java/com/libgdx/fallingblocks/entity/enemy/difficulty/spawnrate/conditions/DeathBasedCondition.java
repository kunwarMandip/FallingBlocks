package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.game.wave.settings.spawn.Spawn;
import com.libgdx.fallingblocks.observers.Observable;

public class DeathBasedCondition extends Spawn implements Observable<Enemy> {

    private int deathCounter = 0;
    private final int deathThreshold;

    public DeathBasedCondition(int deathThreshold){
        this.deathThreshold=deathThreshold;
    }

    @Override
    public void onEvent(Enemy event) {
        int numEnemyToSpawn= deathCounter/deathThreshold;

        if(numEnemyToSpawn >= 0){
            spawnAble.setAmountToSpawn(numEnemyToSpawn);
            deathCounter%= deathThreshold;
        }
    }
}
