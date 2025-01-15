package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * This class is meant to be like over-compassing hud that's meant to represent all things that can go in a hud.
 *
 */
public class GameOverLayHud extends Hud {

    public GameOverLayHud(SpriteBatch spriteBatch) {
        super(spriteBatch);
    }

    public void addActorToTable(Integer align, Actor actor){
        Table table= tableLayoutManager.getTable(align);
        table.add(actor);
    }

}
