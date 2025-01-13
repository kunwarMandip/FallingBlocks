package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;

import java.util.HashMap;
import java.util.Map;

public class GameStat {

    private int score;
    private final Map<EnemyType, Integer> killCount= new HashMap<>();

    public GameStat(int score){
        this.score=0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<EnemyType, Integer> getKillCount() {
        return killCount;
    }
}
