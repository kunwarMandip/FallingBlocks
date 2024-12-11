package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.math.Vector2;

public class WorldDto {

    private final boolean doSleep;
    private final Vector2 gravity;

    public WorldDto(boolean doSleep, Vector2 gravity){
        this.doSleep = doSleep;
        this.gravity=gravity;
    }

    public boolean isDoSleep() {
        return doSleep;
    }

    public Vector2 getGravity() {
        return gravity;
    }
}
