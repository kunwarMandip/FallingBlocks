package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

public class ScoreBasedSpawnCondition implements SpawnCondition {

    private int currentScore;
    private final int scoreThreshold;

    public ScoreBasedSpawnCondition(int scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
        this.currentScore = 0;
    }

    public void update(int score) {
        currentScore = score;
    }

    @Override
    public boolean shouldSpawn() {
        return currentScore >= scoreThreshold;
    }

}
