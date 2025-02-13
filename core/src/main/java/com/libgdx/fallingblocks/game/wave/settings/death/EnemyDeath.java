package com.libgdx.fallingblocks.game.wave.settings.death;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.observers.Subject;

public class EnemyDeath {

    private final Subject<Enemy> deathObserver= new Subject<>();

    public Subject<Enemy> getScoreObservers(){
        return deathObserver;
    }

}
