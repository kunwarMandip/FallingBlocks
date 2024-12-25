package com.libgdx.fallingblocks.entity.enemy.spawn;

import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;


public class EnemyFactory implements IEnemyFactory {

    private Enemy createNormalEnemy(EnemyDto enemyDto){
        return new NormalEnemy(enemyDto.spawnPosition, enemyDto.bodyDimension ,enemyDto.speed);
    }

    private Enemy createQuickEnemy(EnemyDto enemyDto){
        return new BossEnemy(enemyDto.spawnPosition, enemyDto.bodyDimension ,enemyDto.speed);
    }

    private Enemy createBossEnemy(EnemyDto enemyDto){
        return new QuickEnemy(enemyDto.spawnPosition, enemyDto.bodyDimension ,enemyDto.speed);
    }


    @Override
    public Enemy createEnemy(EnemyDto enemyDto) {
        switch (enemyDto.getEnemyType()){
            case NORMAL:
                return createNormalEnemy(enemyDto);
            case QUICK:
                return createQuickEnemy(enemyDto);
            case BOSS:
                return createBossEnemy(enemyDto);
            default:
                throw new IllegalStateException("EnemyBuilder: Unknown EnemyType");
        }
    }
}
