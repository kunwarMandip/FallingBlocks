package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.game.wave.settings.spawn.Spawn;
import com.libgdx.fallingblocks.observers.DeathObserver;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

public class DeathBasedSpawnCondition extends Spawn implements DeathObserver<Enemy>{

    private int deathCounter = 0;
    private final int deathThreshold;

    public DeathBasedSpawnCondition(int deathThreshold){
        this.deathThreshold=deathThreshold;
    }

    @Override
    public void onEntityDeath(Array<Enemy> killedEntities) {
        deathCounter+= killedEntities.size;

        int numEnemyToSpawn= deathCounter/deathThreshold;

        if(numEnemyToSpawn >= 0){
            spawnAble.setAmountToSpawn(numEnemyToSpawn);
            deathCounter%= deathThreshold;
        }
    }
}
