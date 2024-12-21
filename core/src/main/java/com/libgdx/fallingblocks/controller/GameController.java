package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.GameScore;
import com.libgdx.fallingblocks.game.GameState;
import com.libgdx.fallingblocks.game.GameStatistics;
import com.libgdx.fallingblocks.listeners.state.ScoreChangeObserver;

public class GameController {

    private final GameState gameState;
    private final GameScore gameScore;
    private final GameStatistics gameStatistics;

    public GameController(){
        this.gameState=GameState.RUNNING;
        this.gameScore = new GameScore();
        this.gameStatistics = new GameStatistics();
    }

    public GameState getGameState(){
        return this.gameState;
    }

    public void addScoreObserver(ScoreChangeObserver scoreChangeObserver){
        this.gameScore.addScoreObserver(scoreChangeObserver);
    }

    public GameScore getGameScore(){
        return gameScore;
    }


    public GameStatistics getGameStatistics(){
        return gameStatistics;
    }




}
