package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public class GameOverLayHud {

    private final Stage stage;
    private final Viewport viewport;
    private final SpriteBatch spriteBatch;
    private final OrthographicCamera orthographicCamera;
    private final TableLayoutManager tableLayoutManager;

    public GameOverLayHud(SpriteBatch spriteBatch){
        this.spriteBatch=spriteBatch;
        this.orthographicCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2f, orthographicCamera);
        this.stage= new Stage(viewport, spriteBatch);
        this.tableLayoutManager = new TableLayoutManager(stage);
    }

    public TableLayoutManager getTableLayoutManager(){
        return tableLayoutManager;
    }

    public void render(float delta){
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public void dispose(){
        stage.clear();
        stage.dispose();
    }
}
