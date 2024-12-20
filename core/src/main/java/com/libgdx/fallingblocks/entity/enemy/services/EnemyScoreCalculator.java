package com.libgdx.fallingblocks.entity.enemy.services;

import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.game.state.listeners.ScoreUpdateAble;

public class EnemyScoreCalculator {

    private int scoreMultiplier=1;
    private final ScoreUpdateAble scoreUpdateAble;

    public EnemyScoreCalculator(ScoreUpdateAble scoreUpdateAble){
        this.scoreUpdateAble=scoreUpdateAble;
    }

    public void calculateScore(Enemy enemy){
        int score= getBaseScore(enemy) * scoreMultiplier;
        scoreUpdateAble.addScore(score);
    }

    private int getBaseScore(Enemy enemy){

        return 5;
//        EnemyType enemyType= enemy.getEnemyType();
//        switch (enemyType){
//            case NORMAL:
//                return 5;
//            case BOSS:
//                return 10;
//            case QUICK:
//                return 20;
//            default:
//                throw new IllegalStateException("Unknown Enemy Type");
//        }
    }

    public void setScoreMultiplier(int scoreMultiplier){
        this.scoreMultiplier=scoreMultiplier;
    }

    public void resetScoreMultiplier(){
        this.scoreMultiplier=1;
    }
}
