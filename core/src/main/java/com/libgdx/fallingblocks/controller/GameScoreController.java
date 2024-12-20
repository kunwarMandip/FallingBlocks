package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.state.listeners.ScoreObserver;
import com.libgdx.fallingblocks.game.state.listeners.ScoreUpdateAble;

import java.util.ArrayList;
import java.util.List;

public class GameScoreController implements ScoreUpdateAble {

    private int score;
    private final List<ScoreObserver> scoreObservers= new ArrayList<>();

    public GameScoreController(){
        this.score=0;
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

}
