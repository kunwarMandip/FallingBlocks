package com.libgdx.fallingblocks.controller.game;

import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;

import java.util.HashMap;
import java.util.Map;

public class GameStats {

    private int score;
    private int currentWaveNumber;
    private final Map<EnemyType, Integer> killCount= new HashMap<>();

    public GameStats(int score, int currentWaveNumber){
        this.score=0;
        this.currentWaveNumber=0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentWaveNumber() {
        return currentWaveNumber;
    }

    public void setCurrentWaveNumber(int currentWaveNumber) {
        this.currentWaveNumber = currentWaveNumber;
    }

    public Map<EnemyType, Integer> getKillCount() {
        return killCount;
    }
}
