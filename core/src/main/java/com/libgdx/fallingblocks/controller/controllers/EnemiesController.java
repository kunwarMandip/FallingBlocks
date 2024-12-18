package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoCreator;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemySpawnManager;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemiesDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyFactory;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;


public class EnemiesController {

    private final EnemyFactory enemyFactory;
    private final EnemyDtoCreator enemyDtoCreator;
    private final EnemySpawnManager enemySpawnManager;

    private final Array<Enemy> allEnemies = new Array<>();

    public EnemiesController(World world ,EnemiesDto enemiesDto, Map<MovementDirection, Vector2> spawnAreas){
        this.enemyFactory= new EnemyFactory(world);
        this.enemySpawnManager= new EnemySpawnManager();
        this.enemyDtoCreator= new EnemyDtoCreator(enemiesDto, spawnAreas);
    }


    public void updateEnemies(float delta, Vector2 playerPosition){

        enemySpawnManager.update(delta);;

        isEnemySpawnAble(playerPosition);

        for (Enemy enemy: allEnemies){
            enemy.update(delta);
        }
    }


    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: allEnemies){
            enemy.draw(spriteBatch);
        }
    }


    private void isEnemySpawnAble(Vector2 playerPosition){
        int numEnemyToSpawn= enemySpawnManager.getNumEnemyToSpawn();


        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Enemy set to spawn");

        for(int i =0; i< numEnemyToSpawn; i++){
            EnemyDto enemyDto= enemyDtoCreator.getEnemyDto(playerPosition);
            allEnemies.add(enemyFactory.getEnemy(enemyDto));
        }

        enemySpawnManager.resetNumEnemyToSpawn();

    }


}
