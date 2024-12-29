package com.libgdx.fallingblocks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.screen.main.GameScreen;


public class Main extends Game {

    private InputListenerManager inputListenerManager;

    @Override
    public void create() {

        this.inputListenerManager= new InputListenerManager();

        SpriteBatch spriteBatch = new SpriteBatch();
        setScreen(new GameScreen(1, spriteBatch, inputListenerManager));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
