package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.game.wave.settings.spawn.Spawn;
import com.libgdx.fallingblocks.observers.Observable;

public class ScoreBasedSpawnCondition extends Spawn implements Observable<Integer> {

    private int currentScore;
    private final int scoreThreshold;

    public ScoreBasedSpawnCondition(int scoreThreshold){
        this.scoreThreshold=scoreThreshold;
    }

    @Override
    public void onEvent(Integer event) {
        int scoreChange= event - currentScore;

        if(scoreChange % scoreThreshold== 0){
            Logger.log(Logger.Tags.SPAWN_CONDITION, "ScoreBasedCondition: update: Spawning enemy");
            spawnAble.setAmountToSpawn(1);
        }

        currentScore+=scoreChange;
    }
}
