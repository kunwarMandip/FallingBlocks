package com.libgdx.fallingblocks.box2d.entity.enemy.factory;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

public interface EnemyFactory <T extends Enemy> {
    T createEnemy(World world, EnemyDto enemyDto);
}
