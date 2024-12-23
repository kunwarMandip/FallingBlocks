package com.libgdx.fallingblocks.box2d.entity.enemy.services;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.listeners.enemy.observers.EnemyDeathObserver;

import java.util.ArrayList;
import java.util.List;

import static com.libgdx.fallingblocks.Logger.Tags.BEGIN_CONTACT_LISTENER;

public class EnemyRemover {

    private final World world;
    private final List<Enemy> enemiesToDestroy = new ArrayList<>();
    private final List<EnemyDeathObserver> enemyDeathObservers = new ArrayList<>();

    public EnemyRemover(World world){
        this.world=world;
    }

    public boolean isDestroy(Enemy enemy){
        if(!enemy.isSetToDestroy()){
            return false;
        }

        enemy.destroyBody(world);
        notifyDeathListeners(enemy);
        Logger.log(BEGIN_CONTACT_LISTENER, "Destroying Enemy");
        return true;
    }

    public void addDeathListener(EnemyDeathObserver enemyDeathObserver){
        enemyDeathObservers.add(enemyDeathObserver);
    }

    public void removeDeathListener(EnemyDeathObserver enemyDeathObserver){
        enemyDeathObservers.remove(enemyDeathObserver);
    }

    private void notifyDeathListeners(Enemy enemy){
        for(EnemyDeathObserver enemyDeathObserver : enemyDeathObservers){
            enemyDeathObserver.onEnemyDeath(enemy);
        }
    }
}
