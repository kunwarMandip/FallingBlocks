package com.libgdx.fallingblocks.screen.window;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.List;

public class OverLayHud {

    private Skin skin;
    private final List<UIComponent> components = new ArrayList<>();

    public OverLayHud(SpriteBatch spriteBatch, Skin skin) {
    }

    public void render(float delta) {
        for (UIComponent component : components) {
            component.update();
        }
    }

}
