package com.libgdx.fallingblocks.entity.enemy.spawner;

import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;

public interface CreateEnemy {

    Enemy getEnemy(EnemyDto enemyDto);
}
