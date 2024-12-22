package com.libgdx.fallingblocks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.screen.main.GameScreen;

import static com.libgdx.fallingblocks.Logger.Tags.SPAWN_RATE_INCREASE;


public class Main extends Game {

    private InputListenerManager inputListenerManager;

    @Override
    public void create() {

        this.inputListenerManager= new InputListenerManager();

//        Logger.disableAll();
        Logger.enableSingle(SPAWN_RATE_INCREASE);
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
