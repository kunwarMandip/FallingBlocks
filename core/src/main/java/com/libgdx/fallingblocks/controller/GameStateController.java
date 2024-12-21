package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.state.GameScore;
import com.libgdx.fallingblocks.game.state.GameState;
import com.libgdx.fallingblocks.observers.state.ScoreChangeObserver;

public class GameStateController {


    private final GameScore gameScore;
    private final GameState gameState;
    private final DifficultyController difficultyController;

    public GameStateController(){
        this.gameState= new GameState();
        this.gameScore = new GameScore();
        this.difficultyController= new DifficultyController();
    }



    public void addScoreObserver(ScoreChangeObserver scoreChangeObserver){
        this.gameScore.addScoreObserver(scoreChangeObserver);
    }

    public GameScore getGameScore(){
        return gameScore;
    }
    public GameState getGameState(){
        return gameState;
    }




}
