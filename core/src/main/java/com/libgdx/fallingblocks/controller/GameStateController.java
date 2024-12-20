package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.state.ScoreObserver;
import com.libgdx.fallingblocks.state.ScoreUpdateAble;

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
