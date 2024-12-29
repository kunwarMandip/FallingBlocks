package com.libgdx.fallingblocks.entity.enemy.compact;


import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.observers.Subject;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

import java.util.Iterator;

public class EnemyDeathManager {

    private final World world;
    private final Array<Enemy> currentEnemies;
    private final Subject<Enemy> enemyDeathNotifier= new Subject<>();

    public EnemyDeathManager(World world, Array<Enemy> currentEnemies){
        this.world=world;
        this.currentEnemies=currentEnemies;
    }

    public void update(float delta){

        Iterator<Enemy> iterator= currentEnemies.iterator();
        while(iterator.hasNext()){
            Enemy enemy= iterator.next();
            if(enemy.isSetToDestroy()){
                enemy.destroy(world);
            }
            enemyDeathNotifier.notify(enemy);
            iterator.remove();
        }
    }


    public Subject<Enemy> getEnemyDeathNotifier(){
        return this.enemyDeathNotifier;
    }


}
