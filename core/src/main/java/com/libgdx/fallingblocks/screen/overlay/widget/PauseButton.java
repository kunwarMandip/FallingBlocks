package com.libgdx.fallingblocks.screen.overlay.widget;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.libgdx.fallingblocks.game.state.GameState;
import com.libgdx.fallingblocks.game.state.GameStateSetter;
import com.libgdx.fallingblocks.observers.Subject;

public class PauseButton {

    private final TextButton pauseButton;
    private final Subject<GameState> gameStateSubject= new Subject<>();

    public PauseButton(Skin skin, GameStateSetter gameStateSetter){
        this.pauseButton= new TextButton("Pause", skin);

        this.pauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameStateSetter.setGameState(GameState.PAUSED);
            }
        });

    }

    public TextButton getPauseButton(){
        return pauseButton;
    }

}
