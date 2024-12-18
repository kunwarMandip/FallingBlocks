package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.PlayerDto;

public class PlayerController {

    private Player player;
    private final PlayerFactory playerFactory;

    public PlayerController(World world, PlayerDto playerDto){
        this.playerFactory= new PlayerFactory(world, playerDto);
        this.player= playerFactory.getPlayer(PlayerTypes.NORMAL);
        this.player.spawnBody(world);
        player.setInput();
    }

    public void update(float delta){
        player.update(delta);
    }

    public Vector2 getPlayerPosition(){
        return player.getBodyPosition();
    }
    public void draw(SpriteBatch spriteBatch){
        player.draw(spriteBatch);
    }

    public void setPlayer(PlayerTypes playerType){
        player= playerFactory.getPlayer(playerType);
    }

}
