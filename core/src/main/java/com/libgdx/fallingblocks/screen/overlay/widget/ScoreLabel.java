package com.libgdx.fallingblocks.screen.overlay.widget;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.libgdx.fallingblocks.observers.Observable;

import java.util.Locale;

public class ScoreLabel implements Observable<Integer> {

   public Label scoreLabel;

   public ScoreLabel(Skin skin){
       scoreLabel = new Label(String.format(Locale.US, "%d", 0), skin);
       scoreLabel.setFontScale(5.0f);
   }

   public Label getScoreLabel(){
       return this.scoreLabel;
   }

    @Override
    public void onEvent(Integer event) {
        scoreLabel.setText(event);
    }

}
