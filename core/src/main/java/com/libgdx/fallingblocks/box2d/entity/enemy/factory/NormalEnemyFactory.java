package com.libgdx.fallingblocks.box2d.entity.enemy.factory;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

public class NormalEnemyFactory implements EnemyFactory<NormalEnemy> {

    @Override
    public NormalEnemy createEnemy(World world, EnemyDto enemyDto) {
        return null;
    }
}
