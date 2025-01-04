package com.libgdx.fallingblocks.screen.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.game.GameLoader;
import com.libgdx.fallingblocks.input.InputListenerManager;

public class GameScreen implements Screen {

    private final int levelToLoad;
    private final SpriteBatch spriteBatch;
    private final InputListenerManager inputListenerManager;

    private GameLoader gameLoader;

    public GameScreen(int levelToLoad, SpriteBatch spriteBatch, InputListenerManager inputListenerManager){
        this.levelToLoad=levelToLoad;
        this.spriteBatch=spriteBatch;
        this.inputListenerManager= inputListenerManager;
    }

    @Override
    public void show() {
//        gameRunner = new GameRunner(levelToLoad, spriteBatch, inputListenerManager);

        this.gameLoader= new GameLoader(levelToLoad, spriteBatch);
    }


    private void clearScreen(){
        Gdx.gl.glClearColor(0,0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    @Override
    public void render(float delta) {
        gameLoader.update(delta);
        clearScreen();
        gameLoader.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        gameLoader.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {

    }
}
