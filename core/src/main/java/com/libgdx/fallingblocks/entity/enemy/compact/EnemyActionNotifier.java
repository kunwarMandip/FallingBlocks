package com.libgdx.fallingblocks.entity.enemy.compact;

import com.libgdx.fallingblocks.entity.common.observers.EntityDeathNotifier;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

public class EnemyActionNotifier {

    private final EntityDeathNotifier<Enemy> entityDeathNotifier= new EntityDeathNotifier<>();

    public EntityDeathNotifier<Enemy> getEntityDeathNotifier() {
        return entityDeathNotifier;
    }
}
