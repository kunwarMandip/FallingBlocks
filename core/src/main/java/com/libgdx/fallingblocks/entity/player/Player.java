package com.libgdx.fallingblocks.entity.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.animation.Animation;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.input.BasicPlayerInput;

public class Player extends Entity {
    private final Animation animation;

    private GestureDetector gestureDetector;
    private InputListenerManager inputListenerManager;

    public Player(int health, Vector2 spawnPosition, Vector2 bodyDimension) {
        super(health, spawnPosition, bodyDimension);
        this.animation= new Animation(bodyDimension, new Texture("map/images/arrows/arrow.png"));

        inputListenerManager= new InputListenerManager();

    }

    public void setInput(){
        inputListenerManager= new InputListenerManager();
        Vector2 tempSpeed= new Vector2(10, 10);
        gestureDetector= new GestureDetector(new BasicPlayerInput(body, tempSpeed));
        inputListenerManager.addInputProcessor(gestureDetector);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        animation.draw( getBodyPosition(), spriteBatch);
    }

    @Override
    public void onDeath(Entity entity) {

    }

    @Override
    public void onHit(Entity a, Entity b) {

    }

    @Override
    public void collide(Entity entity) {

    }
}
