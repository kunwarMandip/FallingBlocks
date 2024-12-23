package com.libgdx.fallingblocks.box2d.entity.enemy.service;

import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

public interface EnemySpawnAble {

    Enemy getEnemy(EnemyDto enemyDto);
}
