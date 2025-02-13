package com.libgdx.fallingblocks.game.wave.settings.score;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

public class ScoreCalculator {

    private int scoreMultiplier= 1;

    public int calculateScore(Enemy enemy){
        return getBaseScore(enemy) * scoreMultiplier;
    }

    private int getBaseScore(Enemy enemy){

        Integer score= enemy.getScore();

        if(score == null){
            return 5;
        }

        return 10;
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

}
