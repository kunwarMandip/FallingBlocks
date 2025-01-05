package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public abstract class WindowHud{

    protected final Skin skin;
    protected final Stage stage;
    protected final Viewport viewport;

    private final SpriteBatch spriteBatch;
    private final OrthographicCamera orthographicCamera;

    public WindowHud(Skin skin, SpriteBatch spriteBatch) {
        this.skin= skin;
        this.spriteBatch=spriteBatch;

        this.orthographicCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2f, orthographicCamera);
        this.stage= new Stage(viewport, spriteBatch);
    }

    public abstract void show();


    public void render(float delta){
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.act(delta);
        stage.draw();
    }


    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    //todo Need to remove Input listener
    public void dispose() {
        stage.clear();
        stage.dispose();
    }


    //todo this needs to be removed sooner or later
    public Stage getStage() {
        return stage;
    }
}
