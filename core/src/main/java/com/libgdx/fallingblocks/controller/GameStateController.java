package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.state.listeners.ScoreObserver;

public class GameStateController {

    private final GameScoreController gameScoreController;
    private final DifficultyController difficultyController;

    public GameStateController(){
        this.gameScoreController = new GameScoreController();
        this.difficultyController= new DifficultyController();
    }

    public void addScoreObserver(ScoreObserver scoreObserver){
        this.gameScoreController.addScoreObserver(scoreObserver);
    }

    public GameScoreController getGameScoreController(){
        return gameScoreController;
    }



}
