package com.libgdx.fallingblocks.box2d.entity.enemy.observer;

import com.libgdx.fallingblocks.box2d.entity.common.Entity;

public interface EntityDeathObserver <T extends Entity> {
    void entityDied(T entity);
}
