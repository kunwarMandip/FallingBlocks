package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.services.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.listeners.PlayerChangeObserver;
import com.libgdx.fallingblocks.listeners.PlayerDeathObserver;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private final World world;
    private final PlayerFactory playerFactory;
    private final InputListenerManager inputListenerManager;
    private final List<PlayerDeathObserver> playerDeathObservers= new ArrayList<>();
    private final List<PlayerChangeObserver> playerChangeObservers= new ArrayList<>();

    private Player player;

    public PlayerController(World world, PlayerDto playerDto, InputListenerManager inputListenerManager){
        this.world=world;
        this.inputListenerManager= inputListenerManager;
        this.playerFactory= new PlayerFactory(world, playerDto);
        setNewPlayer(PlayerTypes.NORMAL);
    }

    public void setNewPlayer(PlayerTypes playerType){
        player= playerFactory.getPlayer(playerType);
        player.spawnBody(world);
        inputListenerManager.addInputProcessor(player.getGestureDetector());
    }

    public void addDeathObserver(PlayerDeathObserver e){
        this.playerDeathObservers.add(e);
    }

    public void addPlayerChangeObserver(PlayerChangeObserver e){
        this.playerChangeObservers.add(e);
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
        notifyDeathObservers();
        setNewPlayer(PlayerTypes.NORMAL);
    }

    private void notifyDeathObservers(){
        for(PlayerDeathObserver e: playerDeathObservers){
            e.onEntityDeath(player);
        }
    }

    private void notifyPlayerChangeObservers(){
        for(PlayerChangeObserver e: playerChangeObservers){
            e.newPlayer(player);
        }
    }

    public Player getPlayer(){
        return player;
    }


}
