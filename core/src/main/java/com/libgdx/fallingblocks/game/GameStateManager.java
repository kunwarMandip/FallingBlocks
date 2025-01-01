package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.entity.common.observers.Observers;
import com.libgdx.fallingblocks.entity.player.PlayerState;

public class GameStateManager implements Observers<PlayerState> {

    private GameState gameState;

    public GameStateManager() {
        this.gameState = GameState.RUNNING;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    @Override
    public void notify(PlayerState event) {

        switch (event) {
            case ALIVE:
                setGameState(GameState.RUNNING);
                break;
            case DEAD:
                setGameState(GameState.GAME_OVER);
                break;
        }
    }
}
