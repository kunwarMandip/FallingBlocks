package com.libgdx.fallingblocks.box2d.entity.common.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Animation {

    private Texture texture;
    private Vector2 bodyDimension;

    public Animation(Vector2 bodyDimension, Texture texture){
        this.bodyDimension = bodyDimension;
        this.texture=texture;
    }

    public void draw(Vector2 bodyPosition, SpriteBatch spriteBatch){
        float width= bodyDimension.x * 2;
        float height= bodyDimension.y *2;
        float locationX= bodyPosition.x - width/2;
        float locationY= bodyPosition.y - height/2;
        spriteBatch.draw(texture, locationX, locationY, width, height);
    }


    public void dispose(){
        texture.dispose();
    }

    public void setTexture(Texture texture){
        this.texture=texture;
    }

    public void setBodyDimension(Vector2 bodyDimension){
        this.bodyDimension=bodyDimension;
    }
}
