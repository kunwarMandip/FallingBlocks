package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.entity.common.listener.DeathListener;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyScoreCalculator;
import com.libgdx.fallingblocks.state.ScoreObserver;
import com.libgdx.fallingblocks.state.ScoreUpdateAble;

import java.util.ArrayList;
import java.util.List;

public class GameScoreController implements ScoreUpdateAble, DeathListener {

    private int score;
    private final List<ScoreObserver> scoreObservers= new ArrayList<>();

    private final EnemyScoreCalculator enemyScoreCalculator;

    public GameScoreController(){
        this.score=0;
        this.enemyScoreCalculator= new EnemyScoreCalculator();
    }

    public void addScoreObserver(ScoreObserver scoreObserver){
        this.scoreObservers.add(scoreObserver);
    }

    private void notifyObservers(){
        for(ScoreObserver scoreObserver: scoreObservers){
            scoreObserver.onScoreUpdated(score);
        }
    }

    @Override
    public void addScore(int score){
        this.score+=score;
        notifyObservers();
    }

    @Override
    public void onDeath(Enemy enemy) {
        addScore(enemyScoreCalculator.calculateScore(enemy));
    }
}
