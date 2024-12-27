package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.libgdx.fallingblocks.entity.common.Entity;

public interface EntitySpawnHandler <T extends Entity> {
    void handleEntitySpawn(T entity);
}
