package com.libgdx.fallingblocks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.screen.GameScreen;

public class Main extends Game {

    @Override
    public void create() {

//        Logger.disableTag(Logger.Tags.CONTACT_LISTENER);
//        Logger.disableTag(Logger.Tags.WAVE_PARSER);
//        Logger.disableTag(Logger.Tags.WAVE_TIMER_CONTROLLER);

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
