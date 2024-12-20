package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.game.state.listeners.ScoreObserver;

import java.util.Locale;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public class GameRunningHud implements Disposable, ScoreObserver {

    private final SpriteBatch spriteBatch;

    private final Viewport viewport;
    private final OrthographicCamera orthographicCamera;

    private final Stage stage;
    private Skin skin;
    private Table topTable;

    private Label scoreLabel;

    public GameRunningHud(SpriteBatch spriteBatch){
        this.spriteBatch= spriteBatch;
        this.orthographicCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2F, orthographicCamera);
        this.stage= new Stage(viewport, spriteBatch);

        set();
    }

    private void set(){
        this.skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("flat-earth/skin/flat-earth-ui.atlas")));
        skin.load(Gdx.files.internal("flat-earth/skin/flat-earth-ui.json"));

        topTable = new Table();
        topTable.top();
        topTable.setFillParent(true);
        topTable.setDebug(true);
        stage.addActor(topTable);

        scoreLabel = new Label(String.format(Locale.US, "%d", 0), skin);
        scoreLabel.setFontScale(5.0f);
        topTable.add(scoreLabel).expandX();
    }

    public void update(){
    }

    public void render(float delta){
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }


    @Override
    public void onScoreUpdated(int score) {
        scoreLabel.setText(score);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
