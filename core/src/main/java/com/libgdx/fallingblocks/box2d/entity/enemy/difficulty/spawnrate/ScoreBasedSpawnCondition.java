package com.libgdx.fallingblocks.box2d.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.listeners.state.ScoreChangeObserver;


public class ScoreBasedSpawnCondition extends SpawnRate implements ScoreChangeObserver {

    private int currentScore;
    private final int scoreThreshold;

    public ScoreBasedSpawnCondition(int scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
        this.currentScore = 0;
    }


    @Override
    public void onScoreUpdated(int score) {
        int scoreChange= score - currentScore;

        if(scoreChange % scoreThreshold ==0){
            Logger.log(Logger.Tags.SPAWN_RATE_INCREASE, "Score increased by " + scoreChange + " and is a multiple of " + scoreThreshold);
            notifySpawnSetters(1);
        }

        currentScore+=scoreChange;
    }

}
