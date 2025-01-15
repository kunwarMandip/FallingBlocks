package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.observers.Observer;

import java.util.Iterator;

public class EnemyRemover implements Observer<Enemy> {

    private final Array<Enemy> currentEnemies;
    private final Array<Enemy> destroyAble= new Array<>();


    public EnemyRemover(Array<Enemy> currentEnemies){
        this.currentEnemies = currentEnemies;
    }

    public void update(){

        Iterator<Enemy> iterator= destroyAble.iterator();
        while (iterator.hasNext()){
           Enemy enemy= iterator.next();
           currentEnemies.removeValue(enemy, true);
           iterator.remove();
        }
    }

    @Override
    public void notify(Enemy event) {
        destroyAble.add(event);
    }
}
