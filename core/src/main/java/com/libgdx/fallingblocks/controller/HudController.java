package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.screen.hud.Hud;

public class HudController {

    private final Array<Hud> hudArray = new Array<>();
    private final InputListenerManager inputListenerManager;

    public HudController(InputListenerManager inputListenerManager){
        this.inputListenerManager= inputListenerManager;
    }

    public void addHud(Hud hud){
        hudArray.add(hud);
        inputListenerManager.addInputProcessor(hud.getStage());
    }

    public void render(float delta){
        for(Hud hud: hudArray){
            hud.render(delta);
        }
    }

    public void removeHud(Hud hud){
        hud.dispose();
        inputListenerManager.removeInputProcessor(hud.getStage());
        hudArray.removeValue(hud, true);
    }

    public void disposeAll(){
        for(Hud hud: hudArray){
            hud.dispose();
        }

        hudArray.clear();
    }

    public void resize(int width, int height){
        for(Hud hud: hudArray){
            hud.resize(width, height);
        }
    }
}
