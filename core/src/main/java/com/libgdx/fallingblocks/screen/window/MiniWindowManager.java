package com.libgdx.fallingblocks.screen.window;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class MiniWindowManager {

    private Stage stage;

    private Window PauseWindow;
    private Window GameOverWindow;


    public MiniWindowManager(){

    }



    public void setVisible(MiniWindowTypes type, boolean visible){
        switch (type){
            case PAUSE_WINDOW:
                PauseWindow.setVisible(visible);
                break;
            case GAME_OVER_WINDOW:
                GameOverWindow.setVisible(visible);
                break;
        }
    }
}
