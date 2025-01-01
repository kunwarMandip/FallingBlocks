package com.libgdx.fallingblocks.entity.player.services;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;

public class PlayerFactory {

    private final World world;
    private final PlayerDto playerDto;
    private final Vector2 middlePosition= new Vector2(23, 45);

    public PlayerFactory(World world, PlayerDto playerDto){
        this.world=world;
        this.playerDto= playerDto;
    }

    public Player getPlayer(PlayerTypes playerTypes){
        switch (playerTypes){
            case NORMAL:
                return new Player(50, middlePosition, new Vector2(2, 2));
            case BOSS:
                return new Player(100, middlePosition, new Vector2(5, 5));
            default:
                throw new IllegalStateException("PlayerController: Player Not Found");
        }
    }
}
