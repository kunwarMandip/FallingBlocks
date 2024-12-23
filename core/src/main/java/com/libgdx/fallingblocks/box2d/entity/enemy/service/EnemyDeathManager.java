package com.libgdx.fallingblocks.box2d.entity.enemy.service;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.box2d.entity.enemy.observer.EntityDeathObserver;

import java.util.Iterator;

public class EnemyDeathManager implements EntityDeathObserver<Enemy> {

    private final Array<Enemy> enemiesToKill= new Array<>();

    public void destroyEnemies(World world, Array<Enemy> enemies){
        if(enemiesToKill.isEmpty()){
            return;
        }

        Iterator<Enemy> enemyIterator= enemiesToKill.iterator();
        while(enemyIterator.hasNext()){
            Enemy enemy= enemyIterator.next();
            enemy.destroyBody(world);
            enemyIterator.remove();
            enemies.removeValue(enemy, true);
        }
    }

    @Override
    public void entityDied(Enemy entity) {
        enemiesToKill.add(entity);
    }
}
