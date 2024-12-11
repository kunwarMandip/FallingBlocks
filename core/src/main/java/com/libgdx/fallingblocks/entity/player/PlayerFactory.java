package com.libgdx.fallingblocks.entity.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.PlayerDto;

public class PlayerFactory {

    private final World world;
    private final PlayerDto playerDto;

    public PlayerFactory(World world, PlayerDto playerDto){
        this.world=world;
        this.playerDto= playerDto;
    }

    public Player getPlayer(PlayerTypes playerTypes){
        switch (playerTypes){
            case NORMAL:
                return new Player(world, 50, new Vector2(50, 50 ), new Vector2(5, 5));
            case BOSS:
                return new Player(world, 100, new Vector2(50, 50), new Vector2(5, 5));
        }
        throw new IllegalStateException("PlayerController: Player Not Found");
    }
}
