package com.libgdx.fallingblocks.entity.enemy.spawner;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;


public class EnemyFactory {

    private final World world;

    public EnemyFactory(World world){
        this.world= world;
    }


    public Enemy getEnemy(EnemyDto enemyDto){

        Vector2 speed= enemyDto.getSpeed();
        Vector2 spawnPosition= enemyDto.getSpawnPosition();

        Enemy enemy;
        switch (enemyDto.getEnemyType()){
            case NORMAL :
                enemy= new NormalEnemy(world, spawnPosition, new Vector2(5, 5), speed);
                break;
            case QUICK :
                enemy= new QuickEnemy(world, spawnPosition, new Vector2(5, 5),speed);
                break;
            case BOSS :
                enemy= new BossEnemy(world, spawnPosition, new Vector2(5, 5),speed);
                break;
            default :
                throw new IllegalStateException("EnemyFactory: Unknown EnemyType");
        }

        return enemy;
    }

}
