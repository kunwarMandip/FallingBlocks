package com.libgdx.fallingblocks.screen.hud.listeners;

import com.badlogic.gdx.scenes.scene2d.ui.Window;

public interface Visible<T extends Window> {

    void setVisible(T window, boolean visible);

    boolean isVisible(T window);
}
