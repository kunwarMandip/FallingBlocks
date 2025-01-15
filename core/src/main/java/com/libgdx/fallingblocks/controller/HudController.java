package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.observers.Observer;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.screen.hud.Hud;
import com.libgdx.fallingblocks.screen.hud.HudEvent;

public class HudController implements Observer<Hud>, HudEvent {

    private final Array<Hud> activeHud = new Array<>();
    private final Array<Hud> inActiveHud= new Array<>();
    private final InputListenerManager inputListenerManager;

    public HudController(InputListenerManager inputListenerManager){
        this.inputListenerManager= inputListenerManager;
    }

    public void addActiveHud(Hud hud){
        inputListenerManager.addInputProcessor(hud.getStage());
        this.activeHud.add(hud);
        hud.show();
    }

    public void removeHud(Hud hud){
        inputListenerManager.removeInputProcessor(hud.getStage());
        hud.dispose();
        this.activeHud.removeValue(hud, true);
    }

    public void disposeAll(){
        for(Hud hud: activeHud){
            removeHud(hud);
        }
    }

    public void render(float delta){
        for(Hud hud: activeHud){
            hud.render(delta);
        }
    }

    public void resize(int width, int height){
        for(Hud hud: activeHud){
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

    @Override
    public void setActive(Hud hud) {
        inActiveHud.removeValue(hud, true);
        addActiveHud(hud);
    }

    @Override
    public void setInActive(Hud hud) {
        hud.dispose();
        activeHud.removeValue(hud, true);
        inActiveHud.add(hud);
    }
}
