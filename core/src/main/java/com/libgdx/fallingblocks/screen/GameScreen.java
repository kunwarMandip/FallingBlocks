package com.libgdx.fallingblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.LevelManager;

public class GameScreen implements Screen {

    private final int levelToLoad;
    private final SpriteBatch spriteBatch;
    private LevelManager levelManager;

    public GameScreen(int levelToLoad, SpriteBatch spriteBatch){
        this.levelToLoad=levelToLoad;
        this.spriteBatch=spriteBatch;
    }

    @Override
    public void show() {
        levelManager= new LevelManager(levelToLoad, spriteBatch);
    }


    private void clearScreen(){
        Gdx.gl.glClearColor(0,0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    @Override
    public void render(float delta) {
        levelManager.update(delta);
        clearScreen();
        levelManager.render();
    }

    @Override
    public void resize(int width, int height) {
        levelManager.resize(width, height);
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
