package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.game.wave.settings.spawn.Spawn;
import com.libgdx.fallingblocks.observers.TimeAble;

public class TimeBasedSpawnCondition extends Spawn implements TimeAble {

    private float spawnTimer;
    private float spawnRateCounter;

    public TimeBasedSpawnCondition(float spawnTimer) {
        this.spawnTimer = spawnTimer;
        this.spawnRateCounter= 0f;
    }

    @Override
    public void update(float delta) {
        if(spawnRateCounter < spawnTimer){
            spawnRateCounter += delta;
            return;
        }

        Logger.log(Logger.Tags.SPAWN_CONDITION, "TimeBasedSpawnCondition: update: Spawning enemy");
        spawnAble.setAmountToSpawn(1);
        spawnRateCounter = 0f;
    }
}
