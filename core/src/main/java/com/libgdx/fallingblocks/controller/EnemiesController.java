package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;

/**
 * I want this to control everything about the enemies:
 *  Spawn Enemies, Remove Enemies, Update Enemies
 *
 *
 *
 *
 */
public class EnemiesController {

    private final Array<Enemy> currentEnemies= new Array<>();
    private EnemyDeathManager enemyDeathManager;
    private EnemySpawnManager enemySpawnManager;

    public EnemiesController(World world, Vector2 playerPosition, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas){
        this.enemyDeathManager= new EnemyDeathManager(world, currentEnemies);
        this.enemySpawnManager= new EnemySpawnManager(world, playerPosition, enemiesSpawnInfoDto, spawnAreas, currentEnemies);
    }


    /**
     * Things to do:
     *      Remove Enemies
     *      Spawn Enemies
     *          - Spawn Enemies in the correct areas
     *          - Spawn Enemies based on the wave
     *                 - Spawn Enemies based on the wave's spawn rate
     *                 - Spawn Enemies based on the wave's spawn amount
     *
     *      Update Enemies
     *
     *
     *
     * @param builder
     */
    public EnemiesController(Builder builder){
//        this.enemyDeathManager= new EnemyDeathManager(builder.world, currentEnemies);
//        this.enemySpawnManager= new EnemySpawnManager(builder.world, builder.playerPosition,
//            builder.enemiesSpawnInfoDto, builder.spawnAreas, currentEnemies);
    }

    public void update(float delta) {
        enemyDeathManager.update();

        for(Enemy enemy: currentEnemies){
            enemy.update(delta);
        }

        enemySpawnManager.spawn();
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


    public static class Builder{
        private World world;
        private Vector2 playerPosition;
        private EnemiesSpawnInfoDto enemiesSpawnInfoDto;
        private Map<MovementDirection, Vector2> spawnAreas;

        public Builder setWorld(World world){
            this.world= world;
            return this;
        }

        public Builder setPlayerPosition(Vector2 playerPosition){
            this.playerPosition= playerPosition;
            return this;
        }

        public Builder setEnemiesSpawnInfoDto(EnemiesSpawnInfoDto enemiesSpawnInfoDto){
            this.enemiesSpawnInfoDto= enemiesSpawnInfoDto;
            return this;
        }

        public Builder setSpawnAreas(Map<MovementDirection, Vector2> spawnAreas){
            this.spawnAreas= spawnAreas;
            return this;
        }

        public EnemiesController build(){
            return new EnemiesController(world, playerPosition, enemiesSpawnInfoDto, spawnAreas);
        }
    }

}
