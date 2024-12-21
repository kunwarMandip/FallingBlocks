package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.entity.player.PlayerFactory;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.input.InputListenerManager;
import com.libgdx.fallingblocks.observers.player.PlayerChangeObserver;
import com.libgdx.fallingblocks.observers.player.PlayerDeathObserver;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private final World world;
    private final InputListenerManager inputListenerManager;

    private Player player;
    private PlayerDto playerDto;
    private final PlayerFactory playerFactory;

    private final List<PlayerDeathObserver> playerDeathObservers= new ArrayList<>();
    private final List<PlayerChangeObserver> playerChangeObservers= new ArrayList<>();

    public PlayerController(World world, PlayerDto playerDto, InputListenerManager inputListenerManager){
        this.world=world;
        this.inputListenerManager= inputListenerManager;
        this.playerFactory= new PlayerFactory(world, playerDto);
        setPlayer(PlayerTypes.NORMAL);
    }

    public void setPlayer(PlayerTypes playerType){
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
        player.destroyBody(world);
        notifyDeathObservers();
        setPlayer(PlayerTypes.NORMAL);
    }

    private void notifyDeathObservers(){
        for(PlayerDeathObserver e: playerDeathObservers){
            e.onEntityDeath(player);
        }
    }

    public Player getPlayer(){
        return player;
    }


}
