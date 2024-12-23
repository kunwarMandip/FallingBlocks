package com.libgdx.fallingblocks.listeners.common;

import com.libgdx.fallingblocks.box2d.entity.common.Entity;

public interface EntityHealthObserver<T extends Entity> {

    void handleEntityHealthChange(T entityHp);
}
