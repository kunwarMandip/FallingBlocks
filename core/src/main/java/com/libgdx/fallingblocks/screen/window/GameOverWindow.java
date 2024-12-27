package com.libgdx.fallingblocks.screen.window;

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
import com.libgdx.fallingblocks.listeners.state.ScoreChangeObserver;

import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_HEIGHT;
import static com.libgdx.fallingblocks.GlobalVariables.VIRTUAL_WIDTH;

public class GameOverWindow implements ScoreChangeObserver {

    private Skin skin;
    private Stage stage;
    private Window gameOverWindow;

    private final Viewport viewport;
    private final SpriteBatch spriteBatch;
    private final OrthographicCamera hudCamera;


    private int score;

    public GameOverWindow(SpriteBatch spriteBatch){
        this.spriteBatch=spriteBatch;
        this.hudCamera= new OrthographicCamera();
        this.viewport= new FitViewport(VIRTUAL_WIDTH/2f, VIRTUAL_HEIGHT/2f, hudCamera);
        this.stage= new Stage(viewport, spriteBatch);


        stage = new Stage();
        gameOverWindow = new Window("Game Over", skin);
        gameOverWindow.setSize(200, 200);
        gameOverWindow.setPosition(300, 300);
        stage.addActor(gameOverWindow);
    }

    private void setSkin(){
        this.skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("flat-earth/skin/flat-earth-ui.atlas")));
        skin.load(Gdx.files.internal("flat-earth/skin/flat-earth-ui.json"));
    }


    private void onDeathPopUpWindow() {
        gameOverWindow = new Window("Game Over", skin);
        gameOverWindow.setSize(200, 200);
        gameOverWindow.setPosition(
            (viewport.getWorldWidth() - gameOverWindow.getWidth()) / 2,
            (viewport.getWorldHeight() - gameOverWindow.getHeight()) / 2
        );

        // Create a label to show a message
        Label messageLabel = new Label("You Died! Try Again?", skin);
        gameOverWindow.add(messageLabel).center().pad(10);
        gameOverWindow.row();

        // Create a button to restart the game
        TextButton restartButton = new TextButton("Restart", skin);
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Restart Clicked");
                gameOverWindow.setVisible(false);
            }
        });

        gameOverWindow.add(restartButton).center().pad(10);
        gameOverWindow.setVisible(false);
        stage.addActor(gameOverWindow);
    }


    @Override
    public void onScoreChanged(int score) {
        this.score=score;
    }
}
