package com.libgdx.fallingblocks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.screen.main.GameScreen;


public class Main extends Game {

    @Override
    public void create() {

        Logger.disableAll();
        SpriteBatch spriteBatch = new SpriteBatch();
        setScreen(new GameScreen(1, spriteBatch));
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
