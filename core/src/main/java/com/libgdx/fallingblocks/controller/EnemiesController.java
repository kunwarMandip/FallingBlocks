package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyNotifier;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemySpawnManager;
import com.libgdx.fallingblocks.listeners.enemy.observers.EnemyDeathObserver;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyRemover;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemySpawner;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawner.TempEnemyFactory;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;

import java.util.Iterator;
import java.util.Map;


public class EnemiesController {

    private World world;
    private Array<Enemy> enemies;
    private EnemyRemover enemyRemover;
    private TempEnemyFactory tempEnemyFactory;
    private EnemyDtoBuilder enemyDtoFactory;
    private EnemySpawner enemySpawner;

    public EnemiesController(World world, EnemiesDto enemiesDto,
                             Map<MovementDirection, Vector2> spawnAreas){
        this.world=world;
        this.enemies= new Array<>();
        this.tempEnemyFactory = new TempEnemyFactory(world);
        this.enemySpawner = new EnemySpawner();
        this.enemyDtoFactory = new EnemyDtoBuilder(enemiesDto, spawnAreas);
        this.enemyRemover= new EnemyRemover(world);
    }


    private EnemyNotifier enemyNotifier;
    private EnemySpawnManager enemySpawnManager;
    private EnemyDeathManager enemyDeathManager;
    public EnemiesController(EnemiesDto enemiesDto, Vector2 playerPosition){
        this.enemySpawnManager= new EnemySpawnManager(enemiesDto, playerPosition);
        this.enemyDeathManager= new EnemyDeathManager();
    }

    public void update(float delta){
        enemySpawnManager.spawnEnemies();
        enemyDeathManager.update(delta);
    }


    public void addDeathListener(EnemyDeathObserver enemyDeathObserver) {
        enemyRemover.addDeathListener(enemyDeathObserver);
    }

    public void update(float delta, Vector2 playerPosition){
        updateEnemies(delta);
        isEnemySpawnAble(playerPosition);
        enemySpawner.update(delta);
    }


    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: enemies){
            enemy.draw(spriteBatch);
        }
    }

    private void updateEnemies(float delta){
        Iterator<Enemy> iterator= enemies.iterator();
        while(iterator.hasNext()){
            Enemy enemy= iterator.next();
            if(enemyRemover.isDestroy(enemy)){
                iterator.remove();
            }
            enemy.update(delta);
        }
    }

    public void emptyList(){
        Iterator<Enemy> iterator= enemies.iterator();
        while(iterator.hasNext()){
            Enemy enemy= iterator.next();
            enemy.destroy(world);
            iterator.remove();
        }
    }

    private void isEnemySpawnAble(Vector2 playerPosition){
        int numEnemyToSpawn= enemySpawner.getNumEnemyToSpawn();

        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Enemy set to spawn");

        for(int i =0; i< numEnemyToSpawn; i++){
            EnemyDto enemyDto= enemyDtoFactory.getEnemyDto(playerPosition);
            enemies.add(tempEnemyFactory.getEnemy(enemyDto));
        }

        enemySpawner.resetNumEnemyToSpawn();

    }


}
