package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.input.BasicPlayerInput;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;

public class PlayerController {

    private final World world;
    private final PlayerFactory playerFactory;
    private final InputListenerManager inputListenerManager;

    private Player player;
    private PlayerDto playerDto;
    private GestureDetector gestureDetector;

    public PlayerController(World world, PlayerDto playerDto){
        this.world=world;
        this.playerFactory= new PlayerFactory(world, playerDto);
        this.inputListenerManager= new InputListenerManager();
        setPlayer(PlayerTypes.NORMAL);
    }

    public void update(float delta){
        player.update(delta);
    }

    public void draw(SpriteBatch spriteBatch){
        player.draw(spriteBatch);
    }


    public void setPlayer(PlayerTypes playerType){
        inputListenerManager.removeInputProcessor(gestureDetector);

        player= playerFactory.getPlayer(playerType);
        player.spawnBody(world);
        player.setInput();

        //SetInput
        Vector2 tempSpeed= new Vector2(10, 10);
        gestureDetector= new GestureDetector(new BasicPlayerInput(player.getBody(), tempSpeed));
        inputListenerManager.addInputProcessor(gestureDetector);
    }

    private void removeInputListener(){
        inputListenerManager.removeInputProcessor(gestureDetector);
    }


    public Player getPlayer(){
        return player;
    }


}
