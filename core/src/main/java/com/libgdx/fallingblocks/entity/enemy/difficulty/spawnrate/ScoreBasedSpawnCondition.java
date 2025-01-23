package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.observers.Observable;

public class ScoreBasedSpawnCondition extends Spawn implements Observable<Integer> {

    private int currentScore;
    private final int scoreThreshold;

    public ScoreBasedSpawnCondition(int scoreThreshold, SpawnSetter spawnSetter){
        super(spawnSetter);
        this.scoreThreshold=scoreThreshold;
    }

    @Override
    public void onEvent(Integer event) {
        int scoreChange= event - currentScore;

        if(scoreChange % scoreThreshold== 0){
            spawnSetter.setNumEnemiesToSpawn(1);
        }

        currentScore+=scoreChange;
    }
}
