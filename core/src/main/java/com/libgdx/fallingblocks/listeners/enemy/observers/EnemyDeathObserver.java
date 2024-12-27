package com.libgdx.fallingblocks.listeners.enemy.observers;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

public interface EnemyDeathObserver {
    void onEnemyDeath(Enemy enemy);
}
