package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;


public class EnemyFactory {


    public Enemy getEnemy(EnemyDto enemyDto){
        switch (enemyDto.getEnemyType()){
            case NORMAL:
                return new NormalEnemy(enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
            case QUICK:
                return new QuickEnemy(enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
            case BOSS:
                return new BossEnemy(enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
        }

        throw new IllegalStateException("EnemyFactory: Unknown EnemyType");
    }

}
