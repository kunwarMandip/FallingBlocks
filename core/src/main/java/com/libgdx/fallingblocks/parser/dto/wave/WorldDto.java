package com.libgdx.fallingblocks.parser.dto.wave;

import com.badlogic.gdx.math.Vector2;

public class WorldDto {

    private final int waveNumber;
    private final boolean doSleep;
    private final Vector2 gravity;

    public WorldDto(int waveNumber, boolean doSleep, Vector2 gravity){
        this.waveNumber = waveNumber;
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
