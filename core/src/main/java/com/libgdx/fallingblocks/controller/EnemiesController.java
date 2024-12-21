package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.observers.enemy.EnemyDeathObserver;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyRemover;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyFactory;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Iterator;
import java.util.Map;


public class EnemiesController {

    private final EnemyRemover enemyRemover;
    private final EnemyFactory enemyFactory;
    private final EnemyDtoBuilder enemyDtoFactory;
    private final EnemySpawnManager enemySpawnManager;
    private final Array<Enemy> enemies= new Array<>();


    public EnemiesController(World world, EnemiesDto enemiesDto,
                             Map<MovementDirection, Vector2> spawnAreas){
        this.enemyFactory= new EnemyFactory(world);
        this.enemySpawnManager= new EnemySpawnManager();
        this.enemyDtoFactory = new EnemyDtoBuilder(enemiesDto, spawnAreas);
        this.enemyRemover= new EnemyRemover(world);
    }

    public void addDeathListener(EnemyDeathObserver enemyDeathObserver) {
        enemyRemover.addDeathListener(enemyDeathObserver);
    }

    public void update(float delta, Vector2 playerPosition){
        updateEnemies(delta);
        isEnemySpawnAble(playerPosition);
        enemySpawnManager.update(delta);
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


    private void isEnemySpawnAble(Vector2 playerPosition){
        int numEnemyToSpawn= enemySpawnManager.getNumEnemyToSpawn();

        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Enemy set to spawn");

        for(int i =0; i< numEnemyToSpawn; i++){
            EnemyDto enemyDto= enemyDtoFactory.getEnemyDto(playerPosition);
            enemies.add(enemyFactory.getEnemy(enemyDto));
        }

        enemySpawnManager.resetNumEnemyToSpawn();

    }


}
