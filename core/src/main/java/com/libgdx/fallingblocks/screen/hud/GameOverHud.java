package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.GameRunner;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public class GameOverHud {

    private Skin skin;
    private Window window;

    private final Stage stage;
    private final Viewport viewport;
    private final SpriteBatch spriteBatch;
    private final OrthographicCamera orthographicCamera;

    private GameRunner gameRunner;
    public GameOverHud(SpriteBatch spriteBatch, GameRunner gameRunner){
        this.spriteBatch=spriteBatch;
        this.gameRunner=gameRunner;
        this.orthographicCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2f, orthographicCamera);
        this.stage= new Stage(viewport, spriteBatch);
        setSkin();
        setHud();
    }

    private void setSkin(){
        this.skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("flat-earth/skin/flat-earth-ui.atlas")));
        skin.load(Gdx.files.internal("flat-earth/skin/flat-earth-ui.json"));
    }

    private void setHud() {
        window = new Window("Game Over", skin);
        window.setSize(200, 200);
        window.setPosition(
            (viewport.getWorldWidth() - window.getWidth()) / 2,
            (viewport.getWorldHeight() - window.getHeight()) / 2
        );

        // Create a label to show a message
        Label messageLabel = new Label("You Died! Try Again?", skin);
        window.add(messageLabel).center().pad(10);
        window.row();

        // Create a button to restart the game
        TextButton restartButton = new TextButton("Restart", skin);
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Restart Clicked");
                gameRunner.reset();
                window.setVisible(false);
            }
        });

        window.add(restartButton).center().pad(10);
        window.setVisible(false);
        stage.addActor(window);
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }


    public Stage getStage(){
        return stage;
    }
    public void render(float delta){
        window.setVisible(true);
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        stage.act(delta);
        stage.draw();
    }

}
