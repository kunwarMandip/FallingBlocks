package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;


public class EnemyFactory {

    private final World world;

    public EnemyFactory(World world){
        this.world=world;
    }

    public Enemy getEnemy(EnemyDto enemyDto){
        switch (enemyDto.getEnemyType()){
            case NORMAL:
                return new NormalEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5), new Vector2(5, 5));
            case QUICK:
                return new QuickEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5), new Vector2(5, 5));
            case BOSS:
                return new BossEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5), new Vector2(5, 5));
        }

        throw new IllegalStateException("EnemyFactory: Unknown EnemyType");
    }

}
