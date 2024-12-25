package com.libgdx.fallingblocks.entity.enemy.builder;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.dto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;

public class BossEnemyBuilder implements EnemyBuilder<BossEnemy> {

    @Override
    public BossEnemy createEntity(World world, EnemyDto enemyDto) {
        return null;
    }
}
