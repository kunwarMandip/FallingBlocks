package com.libgdx.fallingblocks.controller;


import com.libgdx.fallingblocks.box2d.entity.enemy.services.EnemySpawnRateController;
import com.libgdx.fallingblocks.game.GameScore;

public class DifficultyController {

    private final EnemySpawnRateController enemySpawnRateController;

    public DifficultyController(GameScore gameScore){
        this.enemySpawnRateController = new EnemySpawnRateController();
//        addScoreBasedDifficulty(gameScore);
    }

//    private void addScoreBasedDifficulty(GameScore gameScore){
//        ScoreBasedSpawnCondition scoreBasedSpawnCondition= new ScoreBasedSpawnCondition(5);
//        gameScore.addScoreObserver(scoreBasedSpawnCondition);
//        enemySpawnRateController.addListener(scoreBasedSpawnCondition);
//    }



}
