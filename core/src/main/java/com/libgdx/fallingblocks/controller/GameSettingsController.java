package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnAbleConditions;
import com.libgdx.fallingblocks.game.score.GameScore;
import com.libgdx.fallingblocks.game.state.GameStateManager;

public class GameSettingsController {

    private final GameScore gameScore;
    private final GameStateManager gameStateManager;

    private final SpawnAbleConditions spawnAbleConditions;

    public GameSettingsController(){
        this.gameScore = new GameScore();
        this.spawnAbleConditions = new SpawnAbleConditions();

        this.gameStateManager= new GameStateManager();
    }

    public GameStateManager getGameStateManager(){
        return this.gameStateManager;
    }

    public GameScore getGameScore(){
        return gameScore;
    }


}
