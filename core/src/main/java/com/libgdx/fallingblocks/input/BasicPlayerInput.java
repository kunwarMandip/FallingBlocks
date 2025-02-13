package com.libgdx.fallingblocks.input;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.libgdx.fallingblocks.Logger;

public class BasicPlayerInput implements GestureDetector.GestureListener {

    private final Body body;
    private float verticalSpeed;
    private float horizontalSpeed;

    public BasicPlayerInput(Body body, Vector2 playerSpeed){
        this.body= body;
        this.verticalSpeed= playerSpeed.x;
        this.horizontalSpeed= playerSpeed.y;
    }

    public void setSpeed(Vector2 speed){
        this.verticalSpeed=speed.x;
        this.horizontalSpeed=speed.y;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            if (velocityX > 0) {
                body.setLinearVelocity(new Vector2(verticalSpeed, 0));
            } else {
                body.setLinearVelocity(new Vector2(-verticalSpeed,0));
            }

        } else {
            if (velocityY > 0) {
                body.setLinearVelocity(new Vector2(0f, -horizontalSpeed));
            }
            else {
                body.setLinearVelocity(new Vector2(0f, horizontalSpeed));
            }
        }

        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
