package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;

import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_ENEMY;
import static com.libgdx.fallingblocks.GlobalVariables.CATEGORY_WALL;


public class EnemyFactory {

    private final World world;
    public EnemyFactory(World world){
        this.world=world;
    }


    private Enemy createNormalEnemy(EnemyDto enemyDto){
        Enemy enemy= new NormalEnemy(enemyDto.spawnPosition, new Vector2(2, 2),enemyDto.speed);
        enemy.spawnBody(world);
        enemy.setMaskBit(CATEGORY_ENEMY, (short) ~(CATEGORY_WALL | CATEGORY_ENEMY));
        return enemy;
    }

    private Enemy createQuickEnemy(EnemyDto enemyDto){
        return new BossEnemy(enemyDto.spawnPosition, enemyDto.bodyDimension ,enemyDto.speed);
    }

    private Enemy createBossEnemy(EnemyDto enemyDto){
        return new QuickEnemy(enemyDto.spawnPosition, enemyDto.bodyDimension ,enemyDto.speed);
    }


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
