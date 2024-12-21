package com.libgdx.fallingblocks.observers.player;

import com.libgdx.fallingblocks.entity.common.Entity;

public interface PlayerDeathObserver {
    void onEntityDeath(Entity entity);
}
