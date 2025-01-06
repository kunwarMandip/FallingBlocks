package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameOver extends Hud {

    public GameOver(Skin skin, SpriteBatch spriteBatch) {
        super(skin, spriteBatch);
    }

    @Override
    public void show() {
        Window window= new Window("Game Over", skin);
        window.setSize(200, 200);
        window.setPosition(
            (viewport.getWorldWidth() - window.getWidth()) / 2,
            (viewport.getWorldHeight() - window.getHeight()) / 2
        );

        Label messageLabel = new Label("You Died! Try Again?", skin);
        window.add(messageLabel).center().pad(10);
        window.row();

        TextButton restartButton = new TextButton("Restart", skin);
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                listeners.notify(GameOver.this);
                System.out.println("Restart Clicked");
            }
        });

        stage.addActor(window);
    }

}
