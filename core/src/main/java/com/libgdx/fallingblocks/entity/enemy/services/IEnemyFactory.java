package com.libgdx.fallingblocks.entity.enemy.services;

import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

public interface IEnemyFactory{
    Enemy createEnemy(EnemyDto enemyDto);
}
