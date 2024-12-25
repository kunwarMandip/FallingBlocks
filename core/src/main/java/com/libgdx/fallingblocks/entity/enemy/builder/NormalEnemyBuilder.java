package com.libgdx.fallingblocks.entity.enemy.builder;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.common.dto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;

public class NormalEnemyBuilder implements EnemyBuilder<NormalEnemy> {

    @Override
    public NormalEnemy createEntity(World world, EnemyDto enemyDto) {
        return null;
    }
}
