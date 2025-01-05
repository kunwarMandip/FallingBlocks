package com.libgdx.fallingblocks.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class InputListenerManager {

    private final InputMultiplexer inputMultiplexer= new InputMultiplexer();

    public InputListenerManager(){
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void addInputProcessor(InputProcessor inputProcessor){
        inputMultiplexer.addProcessor(inputProcessor);
    }

    public void addStageInputProcessor(Stage stage){
        inputMultiplexer.addProcessor(stage);
    }

    public void removeInputProcessor(InputProcessor inputProcessor){
        if(inputMultiplexer.getProcessors().contains(inputProcessor, true)){
            inputMultiplexer.removeProcessor(inputProcessor);
        }
    }

    public void dispose(){
        inputMultiplexer.clear();
    }
}
