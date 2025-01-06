package com.libgdx.fallingblocks.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface Input {

    void addInputProcessor(InputProcessor inputProcessor);

    void addStageInputProcessor(Stage stage);

    void removeInputProcessor(InputProcessor inputProcessor);

}
