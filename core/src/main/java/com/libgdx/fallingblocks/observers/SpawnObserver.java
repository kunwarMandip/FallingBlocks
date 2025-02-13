package com.libgdx.fallingblocks.observers;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.Entity;

public interface SpawnObserver<T extends Entity> {

    void enemySpawned(Array<T> spawnedEnemy);
}
