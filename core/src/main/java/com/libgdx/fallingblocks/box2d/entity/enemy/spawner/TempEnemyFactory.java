package com.libgdx.fallingblocks.box2d.entity.enemy.spawner;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.box2d.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.box2d.entity.enemy.types.QuickEnemy;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.box2d.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.box2d.entity.enemy.types.NormalEnemy;


public class TempEnemyFactory implements ClassProvider<Enemy>{

    private final World world;

    public TempEnemyFactory(World world){
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
                throw new IllegalStateException("EnemyBuilder: Unknown EnemyType");
        }

        return enemy;
    }

    @Override
    public Enemy getInstance() {
        return null;
    }
}
