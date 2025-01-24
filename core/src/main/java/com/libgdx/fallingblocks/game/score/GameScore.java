package com.libgdx.fallingblocks.game.score;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.observers.Observable;
import com.libgdx.fallingblocks.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

import static com.libgdx.fallingblocks.Logger.Tags.SCORE_SETTER;

public class GameScore implements Observable<Enemy> {

    private int score;
    private final ScoreCalculator scoreCalculator= new ScoreCalculator();
    private final Subject<Integer> scoreObservers= new Subject<>();

    public GameScore(){
        this.score=0;
    }

    private void setScore(int score){
        this.score+=score;
        scoreObservers.notify(this.score);
    }

    public Subject<Integer> getScoreObservers(){
        return this.scoreObservers;
    }

    @Override
    public void onEvent(Enemy event) {
        Logger.log(SCORE_SETTER, "Setting ScoreLabel");
        this.setScore(scoreCalculator.calculateScore(event));
    }

}
