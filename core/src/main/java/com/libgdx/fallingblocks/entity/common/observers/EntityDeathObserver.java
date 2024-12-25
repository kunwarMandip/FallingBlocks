package com.libgdx.fallingblocks.entity.common.observers;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.common.Entity;

public interface EntityDeathObserver <T extends Entity>{
    void notifyEntityDeath(Array<T> entity);
}

