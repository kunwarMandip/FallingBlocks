package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.libgdx.fallingblocks.entity.common.observers.Observers;

import java.util.Locale;

public class ScoreLabel implements Observers<Integer> {

   public Label scoreLabel;

   public ScoreLabel(Skin skin, Table table){
       scoreLabel = new Label(String.format(Locale.US, "%d", 0), skin);
       scoreLabel.setFontScale(5.0f);
       table.add(scoreLabel).expandX();
   }



    @Override
    public void notify(Integer event) {
        scoreLabel.setText(event);
    }

}
