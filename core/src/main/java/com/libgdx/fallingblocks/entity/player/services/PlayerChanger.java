package com.libgdx.fallingblocks.entity.player.services;

import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.listeners.player.observers.PlayerChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class PlayerChanger {

    private final PlayerFactory playerFactory;
    private final List<PlayerChangeObserver> playerChangeObservers= new ArrayList<>();

    public PlayerChanger(PlayerFactory playerFactory){
        this.playerFactory = playerFactory;
    }

    public void addPlayerChangeObserver(PlayerChangeObserver e){
        this.playerChangeObservers.add(e);
    }

    public void notifyPlayerChangeObservers(Player player){
        for(PlayerChangeObserver observer: playerChangeObservers){
            observer.newPlayer(player);
        }
    }
}
