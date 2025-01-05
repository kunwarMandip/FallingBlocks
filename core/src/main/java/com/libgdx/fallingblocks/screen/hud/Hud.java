package com.libgdx.fallingblocks.screen.hud;

import com.badlogic.gdx.scenes.scene2d.Stage;

public interface Hud {

    void setHud();

    void render(float delta);

    void setVisibility(boolean visibility);

    void resize(int width, int height);

    void dispose();

    Stage getStage();
}
