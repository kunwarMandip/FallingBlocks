package com.libgdx.fallingblocks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.screen.main.GameScreen;

import static com.libgdx.fallingblocks.Logger.Tags.SPAWN_CONDITION;


public class Main extends Game {

    @Override
    public void create() {
//        Logger.enableSingle(Logger.Tags.SPAWN_CONDITION);
        Logger.enableSingle(SPAWN_CONDITION);
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
