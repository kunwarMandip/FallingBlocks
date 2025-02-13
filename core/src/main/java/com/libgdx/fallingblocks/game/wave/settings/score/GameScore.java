package com.libgdx.fallingblocks.game.wave.settings.score;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.observers.Observable;
import com.libgdx.fallingblocks.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

import static com.libgdx.fallingblocks.Logger.Tags.SCORE_SETTER;

/**
 * Handles the score of the game.
 * Observable class that notifies its observers when the score changes.
 */
public class GameScore implements Observable<Enemy> {
    private int score;
    private final Subject<Integer> scoreObservers= new Subject<>();
    private final ScoreCalculator scoreCalculator= new ScoreCalculator();

    public GameScore(int score){
        this.score=score;
    }

    public Subject<Integer> getScoreObservers(){
        return this.scoreObservers;
    }

    private void setScore(int score){
        this.score+=score;
        scoreObservers.notify(this.score);
    }

    /**
     * On Enemy Death, calculate the score and set it.
     * @param event
     */
    @Override
    public void onEvent(Enemy event) {
        Logger.log(SCORE_SETTER, "Setting ScoreLabel");
        this.setScore(scoreCalculator.calculateScore(event));
    }

}
