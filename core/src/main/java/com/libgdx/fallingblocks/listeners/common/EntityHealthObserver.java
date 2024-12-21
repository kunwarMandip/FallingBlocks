package com.libgdx.fallingblocks.listeners.common;

import com.libgdx.fallingblocks.entity.common.Entity;

public interface EntityHealthObserver<T extends Entity> {

    void handleEntityHealthChange(T entityHp);
}
