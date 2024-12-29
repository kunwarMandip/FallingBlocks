package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.entity.common.observers.Observers;
import com.libgdx.fallingblocks.entity.common.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyScoreCalculator;

public class GameScore implements Observers<Enemy> {

    private int score;
    private final Subject<Integer> scoreObservers;
    private final EnemyScoreCalculator enemyScoreCalculator;

    public GameScore(){
        this.score=0;
        this.scoreObservers= new Subject<>();
        this.enemyScoreCalculator= new EnemyScoreCalculator();
    }

    public GameScore(int score){
        this.score=score;
        this.scoreObservers= new Subject<>();
        this.enemyScoreCalculator= new EnemyScoreCalculator();
    }

    private void setScore(int score){
        this.score+=score;
        scoreObservers.notify(score);
    }

    public Subject<Integer> getScoreObservers(){
        return this.scoreObservers;
    }

    @Override
    public void notify(Enemy event) {
        setScore(enemyScoreCalculator.calculateScore(event));
    }

}
