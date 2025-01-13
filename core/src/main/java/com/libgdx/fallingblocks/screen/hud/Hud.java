package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.entity.common.observers.Subject;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public abstract class Hud  {

    protected final Skin skin;
    protected final Stage stage;
    protected final Viewport viewport;
    protected final OrthographicCamera orthographicCamera;

    private final SpriteBatch spriteBatch;
    protected final Subject<Hud> listeners= new Subject<>();

    //todo make this constructor prettier
    public Hud(Skin skin, SpriteBatch spriteBatch) {
        if(skin == null){
            this.skin = new Skin();
            this.skin.addRegions(new TextureAtlas(Gdx.files.internal("flat-earth/skin/flat-earth-ui.atlas")));
            this.skin.load(Gdx.files.internal("flat-earth/skin/flat-earth-ui.json"));
        }
        else{
            this.skin= skin;
        }

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

    public void dispose() {
        stage.clear();
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
