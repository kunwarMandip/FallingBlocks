package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;


public class EnemyFactory {


    public Enemy getEnemy(EnemyDto enemyDto, World world){

        Vector2 speed= new Vector2(1, 1);
        switch (enemyDto.getEnemyType()){
            case NORMAL:
                return new NormalEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),speed);
            case QUICK:
                return new QuickEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),speed);
            case BOSS:
                return new BossEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),speed);
        }

        throw new IllegalStateException("EnemyFactory: Unknown EnemyType");
    }

}
