package com.libgdx.fallingblocks.game.state;

import com.libgdx.fallingblocks.observers.Observer;
import com.libgdx.fallingblocks.entity.player.PlayerState;

public class GameStateManager implements Observer<PlayerState>, GameStateSetter {

    private GameState gameState;

    public GameStateManager() {
        this.gameState = GameState.RUNNING;
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
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
