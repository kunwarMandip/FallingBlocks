package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.gameDto.levelDto.PlayerDto;

public class PlayerController {

    private Player player;
    private final PlayerFactory playerFactory;

    public PlayerController(World world, PlayerDto playerDto){
        this.playerFactory= new PlayerFactory(world, playerDto);
        this.player= playerFactory.getPlayer(playerDto);
    }

    public void draw(SpriteBatch spriteBatch){
        player.draw(spriteBatch);
    }

    public void setPlayer(PlayerTypes playerType){
        player= playerFactory.getPlayer(playerType);
    }

}
