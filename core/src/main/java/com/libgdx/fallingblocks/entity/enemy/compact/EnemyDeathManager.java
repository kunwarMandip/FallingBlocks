package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.observers.EntityDeathNotifier;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

public class EnemyDeathManager {

    private EntityDeathNotifier<Enemy> enemyDeathNotifier;
    private Array<Enemy> enemiesToDestroy= new Array<>();

    public EnemyDeathManager(){
        this.enemyDeathNotifier = new EntityDeathNotifier<>();
    }

    public void update(float delta){
    }




}
