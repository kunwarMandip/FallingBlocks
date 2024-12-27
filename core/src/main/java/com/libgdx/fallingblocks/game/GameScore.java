package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.listeners.enemy.observers.EnemyDeathObserver;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyScoreCalculator;
import com.libgdx.fallingblocks.listeners.state.ScoreChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class GameScore implements EnemyDeathObserver {

    private int score=0;
    private final EnemyScoreCalculator enemyScoreCalculator;
    private final List<ScoreChangeObserver> scoreChangeObservers = new ArrayList<>();

    public GameScore(){
        this.enemyScoreCalculator= new EnemyScoreCalculator();
    }

    public void addScoreObserver(ScoreChangeObserver scoreChangeObserver){
        this.scoreChangeObservers.add(scoreChangeObserver);
    }

    public void removeScoreObserver(ScoreChangeObserver scoreChangeObserver) {
        this.scoreChangeObservers.remove(scoreChangeObserver);
    }

    public void addScore(int score){
        this.score+=score;
        notifyObservers();
    }

    public int getScore(){
        return this.score;
    }

    @Override
    public void onEnemyDeath(Enemy enemy) {
        addScore(enemyScoreCalculator.calculateScore(enemy));
    }

    private void notifyObservers(){
        for(ScoreChangeObserver scoreChangeObserver : scoreChangeObservers){
            scoreChangeObserver.onScoreChanged(score);
        }
    }

}
