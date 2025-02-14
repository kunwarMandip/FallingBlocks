package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionListener;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;

public class EnemiesController {

    private final EnemyDeathManager enemyDeathManager;
    private final EnemySpawnManager enemySpawnManager;
    private final Array<Enemy> currentEnemies= new Array<>();

    public EnemiesController(World world, Vector2 playerPosition, SpawnConditionListener spawnConditions, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas) {
        this.enemyDeathManager= new EnemyDeathManager(world, currentEnemies);
        this.enemySpawnManager= new EnemySpawnManager(world, playerPosition, spawnConditions, enemiesSpawnInfoDto, spawnAreas, currentEnemies);
    }

    public void update(float delta) {
        enemyDeathManager.update();

        for(Enemy enemy: currentEnemies){
            enemy.update(delta);
        }

        enemySpawnManager.spawn(delta);
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
