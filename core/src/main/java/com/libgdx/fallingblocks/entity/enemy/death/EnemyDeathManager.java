package com.libgdx.fallingblocks.entity.enemy.death;

import com.libgdx.fallingblocks.entity.common.observers.EntityDeathNotifier;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

public class EnemyDeathManager {

    private EntityDeathNotifier<Enemy> enemyDeathNotifier;

    public EnemyDeathManager(){
        this.enemyDeathNotifier = new EntityDeathNotifier<>();
    }

    public void update(float delta){

    }
}
