package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.observers.Subject;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerState;
import com.libgdx.fallingblocks.entity.player.services.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;

public class PlayerController {

    private Player player;
    private final World world;
    private final PlayerFactory playerFactory;
    private final InputListenerManager inputListenerManager;

    private PlayerState playerState;
    private final Subject<PlayerState> playerStateSubject= new Subject<>();

    public PlayerController(World world, PlayerDto playerDto, InputListenerManager inputListenerManager){
        this.world=world;
        this.inputListenerManager= inputListenerManager;
        this.playerFactory= new PlayerFactory(world, playerDto);
        setNewPlayer(PlayerTypes.NORMAL);
        this.playerState= PlayerState.ALIVE;
    }

    public void setNewPlayer(PlayerTypes playerType){
        player= playerFactory.getPlayer(playerType);
        player.spawnBody(world);
        inputListenerManager.addInputProcessor(player.getGestureDetector());
    }

    public void update(float delta){
        player.update(delta);
        isDestroyEnemy();
    }

    private void isDestroyEnemy(){
        if(!player.isSetToDestroy()){
            return;
        }

        inputListenerManager.removeInputProcessor(player.getGestureDetector());
        player.destroy(world);
        setPlayerState(PlayerState.DEAD);
        setNewPlayer(PlayerTypes.NORMAL);
    }


    public void reset(){
        player.setToDestroy();
        isDestroyEnemy();
    }

    public void setPlayerState(PlayerState playerState){
        playerStateSubject.notify(playerState);
    }

    public Subject<PlayerState> getPlayerStateSubject(){
        return playerStateSubject;
    }

    public Player getPlayer(){
        return player;
    }

}
