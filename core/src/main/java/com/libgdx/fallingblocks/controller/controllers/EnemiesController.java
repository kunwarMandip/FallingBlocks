package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyDtoCreator;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyFactory;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;


public class EnemiesController {

    private final EnemyFactory enemyFactory;
    private final EnemyDtoCreator enemyDtoCreator;

    private final Array<Enemy> allEnemies = new Array<>();

    public EnemiesController(EnemyInfoDto enemyInfoDto, Map<MovementDirection, Vector2> spawnAreas){
        this.enemyFactory= new EnemyFactory();
        this.enemyDtoCreator= new EnemyDtoCreator(enemyInfoDto, spawnAreas);
    }

//    public void spawnEnemies(){
//        EnemyDto enemyDto= enemyDtoCreator.getEnemyDto();
//        allEnemies.add(enemyFactory.getEnemy(enemyDto));
//    }

    public void updateEnemies(float delta){
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
