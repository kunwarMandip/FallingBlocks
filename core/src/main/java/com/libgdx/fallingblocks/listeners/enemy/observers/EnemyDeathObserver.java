package com.libgdx.fallingblocks.listeners.enemy.observers;

import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;

public interface EnemyDeathObserver {

    void onEnemyDeath(Enemy enemy);
}
