package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public abstract class Hud {

    protected final Skin skin;
    protected final Stage stage;
    protected final Viewport viewport;
    protected final SpriteBatch spriteBatch;
    protected final TableLayoutManager tableLayoutManager;
    protected final OrthographicCamera orthographicCamera;

    public Hud(SpriteBatch spriteBatch) {
        this.skin = new Skin();
        this.skin.addRegions(new TextureAtlas(Gdx.files.internal("flat-earth/skin/flat-earth-ui.atlas")));
        this.skin.load(Gdx.files.internal("flat-earth/skin/flat-earth-ui.json"));

        this.spriteBatch=spriteBatch;
        this.orthographicCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2f, orthographicCamera);
        this.stage= new Stage(viewport, spriteBatch);
        this.tableLayoutManager= new TableLayoutManager();
    }

    public void render(float delta){
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public void dispose() {
        stage.clear();
        stage.dispose();
    }

}
