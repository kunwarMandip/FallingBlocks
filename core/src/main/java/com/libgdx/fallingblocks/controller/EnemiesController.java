package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;


public class EnemiesController {

    private final Array<Enemy> currentEnemies;
    private final EnemyDeathManager enemyDeathManager;
    private final EnemySpawnManager enemySpawnManager;

    public EnemiesController(World world, Vector2 playerPosition, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas){
        this.currentEnemies = new Array<>();
        this.enemyDeathManager= new EnemyDeathManager(world, currentEnemies);
        this.enemySpawnManager= new EnemySpawnManager(world, playerPosition, enemiesSpawnInfoDto, currentEnemies, spawnAreas);
    }

    public void update(float delta) {
        enemyDeathManager.update(delta);

        for(Enemy enemy: currentEnemies){
            enemy.update(delta);
        }

        enemySpawnManager.spawnEnemies();
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: currentEnemies){
            enemy.draw(spriteBatch);
        }
    }

    public EnemySpawnManager getEnemySpawnManager(){
        return enemySpawnManager;
    }

    public EnemyDeathManager getEnemyDeathManager(){
        return enemyDeathManager;
    }


}
