package com.libgdx.fallingblocks.entity.enemy.builder;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.Entity;
import com.libgdx.fallingblocks.entity.common.dto.EnemyDto;

public interface EnemyBuilder<T extends Entity> {
    T createEntity(World world, EnemyDto enemyDto);
}
