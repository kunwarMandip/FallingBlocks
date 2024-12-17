package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyDtoCreator;
import com.libgdx.fallingblocks.entity.enemy.services.EnemySpawnManager;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemiesDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyFactory;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;


public class EnemiesController {

    private final EnemyFactory enemyFactory;
    private final EnemyDtoCreator enemyDtoCreator;
    private final EnemySpawnManager enemySpawnManager;

    private final Array<Enemy> allEnemies = new Array<>();

    public EnemiesController(EnemiesDto enemiesDto, Map<MovementDirection, Vector2> spawnAreas){
        this.enemyFactory= new EnemyFactory();
        this.enemySpawnManager= new EnemySpawnManager();
        this.enemyDtoCreator= new EnemyDtoCreator(enemiesDto, spawnAreas);
    }


    public void updateEnemies(float delta){

        enemySpawnManager.update(delta);;

        for (Enemy enemy: allEnemies){
            enemy.update(delta);
        }

    }

    public void isEnemySpawnAble(Vector2 playerPosition){
        int numEnemyToSpawn= enemySpawnManager.getNumEnemyToSpawn();

        if(numEnemyToSpawn==0){
            return;
        }

        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Enemy set to spawn");

        for(int i =0; i< numEnemyToSpawn; i++){
            Logger.log(Logger.Tags.ENEMY_SPAWNER, "Spawning");
            EnemyDto enemyDto= enemyDtoCreator.getEnemyDto(playerPosition);
            allEnemies.add(enemyFactory.getEnemy(enemyDto));
        }

        enemySpawnManager.resetNumEnemyToSpawn();

    }


    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: allEnemies){
            enemy.draw(spriteBatch);
        }
    }

}
