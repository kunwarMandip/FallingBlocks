package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.listeners.enemy.observers.EnemyDeathObserver;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyScoreCalculator;
import com.libgdx.fallingblocks.listeners.state.ScoreChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class GameScore implements EnemyDeathObserver {

    private int score;
    private final List<ScoreChangeObserver> scoreChangeObservers = new ArrayList<>();

    private final EnemyScoreCalculator enemyScoreCalculator;

    public GameScore(){
        this.score=0;
        this.enemyScoreCalculator= new EnemyScoreCalculator();
    }

    public void addScoreObserver(ScoreChangeObserver scoreChangeObserver){
        this.scoreChangeObservers.add(scoreChangeObserver);
    }

    public void addScore(int score){
        this.score+=score;
        notifyObservers();
    }

    @Override
    public void onEnemyDeath(Enemy enemy) {
        addScore(enemyScoreCalculator.calculateScore(enemy));
    }

    private void notifyObservers(){
        for(ScoreChangeObserver scoreChangeObserver : scoreChangeObservers){
            scoreChangeObserver.onScoreUpdated(score);
        }
    }

}
