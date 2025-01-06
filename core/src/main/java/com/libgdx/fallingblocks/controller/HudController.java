package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.observers.Observers;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.screen.hud.Hud;

public class HudController implements Observers<Hud> {

    private final Array<Hud> hudArray = new Array<>();
    private final InputListenerManager inputListenerManager;


    private final Array<Hud> activeHud = new Array<>();
    private final Array<Hud> inActiveHud= new Array<>();

    public HudController(InputListenerManager inputListenerManager){
        this.inputListenerManager= inputListenerManager;
    }

    public void addHud(Hud hud){
        inputListenerManager.addInputProcessor(hud.getStage());
        this.activeHud.add(hud);
    }


    public void removeHud(Hud hud){
        inputListenerManager.removeInputProcessor(hud.getStage());
        hud.dispose();
        this.hudArray.removeValue(hud, true);
    }

    public void disposeAll(){
        for(Hud hud: hudArray){
            removeHud(hud);
        }
    }

    public void render(float delta){
        for(Hud hud: activeHud){
            hud.render(delta);
        }
    }

    public void resize(int width, int height){
        for(Hud hud: hudArray){
            hud.resize(width, height);
        }
    }

    /**
     * Removes Hud type object from the hudController completely
     * @param event
     */
    @Override
    public void notify(Hud event) {
        removeHud(event);
    }
}
