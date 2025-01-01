package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.GameScore;
import com.libgdx.fallingblocks.game.GameStateManager;
import com.libgdx.fallingblocks.game.GameStatistics;

public class GameController {

    private final GameScore gameScore;
    private final GameStatistics gameStatistics;
    private final GameStateManager gameStateManager;

    public GameController(){
        this.gameScore = new GameScore();
        this.gameStatistics = new GameStatistics();
        this.gameStateManager= new GameStateManager();
    }

    public GameStateManager getGameStateManager(){
        return this.gameStateManager;
    }

    public GameScore getGameScore(){
        return gameScore;
    }

    public GameStatistics getGameStatistics(){
        return gameStatistics;
    }

}
