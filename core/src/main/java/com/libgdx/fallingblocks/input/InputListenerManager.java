package com.libgdx.fallingblocks.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.fallingblocks.Logger;


public class InputListenerManager {

    private final InputMultiplexer inputMultiplexer;

    public InputListenerManager(){
        this.inputMultiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    public void addInputProcessor(InputProcessor inputProcessor){
        inputMultiplexer.addProcessor(inputProcessor);
    }

    public void addInputListener(Stage stage){
        System.out.println("Adding Stage Listener");
        inputMultiplexer.addProcessor(stage);
    }

    public void removeInputProcessor(InputProcessor inputProcessor){
        if(inputMultiplexer.getProcessors().contains(inputProcessor, true)){
            inputMultiplexer.removeProcessor(inputProcessor);
        }
    }

    public InputMultiplexer getInputMultiplexer(){
        return inputMultiplexer;
    }
}
