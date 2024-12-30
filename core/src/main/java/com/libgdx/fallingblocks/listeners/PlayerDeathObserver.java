package com.libgdx.fallingblocks.listeners;

import com.libgdx.fallingblocks.entity.common.Entity;

public interface PlayerDeathObserver {
    void onEntityDeath(Entity entity);
}
