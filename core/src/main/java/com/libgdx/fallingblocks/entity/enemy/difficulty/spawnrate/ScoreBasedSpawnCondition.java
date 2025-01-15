package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.observers.Observer;

public class ScoreBasedSpawnCondition extends Spawn implements Observer<Integer> {

    private int currentScore;
    private final int scoreThreshold;

    public ScoreBasedSpawnCondition(int scoreThreshold,SpawnSetter spawnSetter){
        super(spawnSetter);
        this.scoreThreshold=scoreThreshold;
    }

    @Override
    public void notify(Integer event) {
        int scoreChange= event - currentScore;

        if(scoreChange % scoreThreshold== 0){
            spawnSetter.setNumEnemyToSpawn(1);
        }

        currentScore+=scoreChange;
    }
}
