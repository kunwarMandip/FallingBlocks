package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.score.GameScore;
import com.libgdx.fallingblocks.game.state.GameStateManager;

public class GameController {

    private final GameScore gameScore;
    private final GameStateManager gameStateManager;

    public GameController(){
        this.gameScore = new GameScore();

        this.gameStateManager= new GameStateManager();
    }

    public GameStateManager getGameStateManager(){
        return this.gameStateManager;
    }

    public GameScore getGameScore(){
        return gameScore;
    }


}
