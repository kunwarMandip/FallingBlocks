package com.libgdx.fallingblocks.listeners.player.observers;

import com.libgdx.fallingblocks.box2d.entity.common.Entity;

public interface PlayerDeathObserver {
    void onEntityDeath(Entity entity);
}
