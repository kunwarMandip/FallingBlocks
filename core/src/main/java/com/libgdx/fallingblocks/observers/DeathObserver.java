package com.libgdx.fallingblocks.observers;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.Entity;

public interface DeathObserver <T extends Entity> {
    void onEntityDeath(Array<T> killedEntities);
}
