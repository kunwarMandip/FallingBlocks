package com.libgdx.fallingblocks.game.state;

import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.observers.player.PlayerDeathObserver;

import java.util.HashMap;
import java.util.Map;

public class GameState implements PlayerDeathObserver {

    private int totalEnemyKilled;
    private boolean isPlayerDead, isGameOver, isGamePaused= false;
    private final Map<EnemyType, Integer> enemyKillCount= new HashMap<>();


    public GameState(){
        this.totalEnemyKilled=0;
    }


    @Override
    public void onEntityDeath(Entity entity) {
        isPlayerDead=true;
    }


    public boolean isPlayerDead(){
        return isPlayerDead;
    }
}
