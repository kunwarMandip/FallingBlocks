package com.libgdx.fallingblocks.entity.enemy.spawn;

import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

public interface IEnemyFactory{
    Enemy createEnemy(EnemyDto enemyDto);
}
