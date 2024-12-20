package com.libgdx.fallingblocks.listeners.common;

import com.libgdx.fallingblocks.entity.common.Entity;

public interface EntityDeathObserver<T extends Entity> {

    void handleEntityDeath(T entityDeath);
}
