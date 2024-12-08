package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;

public class PlayerController {

    private final World world;
    private Player currentPlayer;

    public PlayerController(World world, PlayerTypes playerTypes){
        this.world=world;
        changeCurrentPlayer(playerTypes);
    }

    public void changeCurrentPlayer(PlayerTypes playerTypes){
        switch (playerTypes){
            case NORMAL:
                currentPlayer= new Player(world, 50, new Vector2(50, 50 ), new Vector2(5, 5));
                break;
            case BOSS:
                currentPlayer= new Player(world, 100, new Vector2(50, 50), new Vector2(5, 5));
                break;
        }
    }

    public void update(float delta){
        currentPlayer.update(delta);
    }

    public void draw(SpriteBatch spriteBatch) {
        currentPlayer.draw(spriteBatch);
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }


}
