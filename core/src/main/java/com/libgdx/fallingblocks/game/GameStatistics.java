package com.libgdx.fallingblocks.game;

import com.libgdx.fallingblocks.box2d.entity.common.Entity;
import com.libgdx.fallingblocks.box2d.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.listeners.player.observers.PlayerDeathObserver;

import java.util.HashMap;
import java.util.Map;

public class GameStatistics implements PlayerDeathObserver{

    private int totalEnemyKilled;
    private boolean isPlayerDead= false;
    private final Map<EnemyType, Integer> enemyKillCount= new HashMap<>();


    public GameStatistics(){
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
