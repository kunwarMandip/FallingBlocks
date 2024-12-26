package com.libgdx.fallingblocks.entity.common.observers;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.common.Entity;

import java.util.ArrayList;
import java.util.List;


public class EntityDeathNotifier <T extends Entity>{

    private final List<EntityDeathObserver<T>> enemyDeathObservers= new ArrayList<>();

    public void addDeathListener(EntityDeathObserver<T> observer){
        enemyDeathObservers.add(observer);
    }

    public void removeDeathListener(EntityDeathObserver<T> observer){
        enemyDeathObservers.remove(observer);
    }

    public void notify(Array<T> entity){
        for(EntityDeathObserver<T> entityDeathObserver : enemyDeathObservers){
            Logger.log(Logger.Tags.ENTITY_DEATH, "Notifying death observer");
            entityDeathObserver.notifyEntityDeath(entity);
        }
    }
}
