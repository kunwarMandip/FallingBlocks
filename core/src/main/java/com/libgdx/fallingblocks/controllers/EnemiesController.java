package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.EnemyFactory;

public class EnemiesController {

    private final EnemyFactory enemyFactory;
    private final Array<Enemy> allEnemies = new Array<>();

    public EnemiesController(World world, EnemyInfoDto enemyInfoDto){
        this.enemyFactory= new EnemyFactory(world, enemyInfoDto);
    }

    public void update(float delta){
        for (Enemy enemy: allEnemies){
            enemy.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: allEnemies){
            enemy.draw(spriteBatch);
        }
    }
}
