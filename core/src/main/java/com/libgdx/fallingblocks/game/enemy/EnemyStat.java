package com.libgdx.fallingblocks.game.enemy;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.observers.DeathObserver;
import com.libgdx.fallingblocks.observers.SpawnObserver;

public class EnemyStat implements SpawnObserver<Enemy>, DeathObserver<Enemy> {



    @Override
    public void onEntityDeath(Array<Enemy> killedEntities) {

    }

    @Override
    public void enemySpawned(Array<Enemy> spawnedEnemy) {

    }
}
