package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.dto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.map.objects.EnemySpawnArea;
import com.libgdx.fallingblocks.controllers.listeners.EnemySpawnListener;

public class SpawnController implements EnemySpawnListener {

    private final EnemyFactory enemyFactory;
    private final Array<EnemySpawnArea> enemySpawnAreas;

    private int numEnemyToSpawn=0;
    private final Array<Enemy> currentEnemies= new Array<>();

    public SpawnController(World world, Array<EnemySpawnArea> enemySpawnAreas, EnemyInfoDto enemyInfoDto){
        this.enemySpawnAreas=enemySpawnAreas;
        this.enemyFactory= new EnemyFactory(world, enemyInfoDto,enemySpawnAreas);
    }

    public void update(float delta, Vector2 playerLocation){
        for(int i=0; i<numEnemyToSpawn; i++){
            currentEnemies.add(enemyFactory.getEnemy(playerLocation));
            numEnemyToSpawn--;
        }

        for(Enemy enemy: currentEnemies){
            enemy.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: currentEnemies){
            enemy.draw(spriteBatch);
        }
    }

    @Override
    public void spawnEnemy(int numEnemyToSpawn) {
//        Gdx.app.log("SpawnController", numEnemyToSpawn+  " :Enemy Set to Spawn");
        this.numEnemyToSpawn+=numEnemyToSpawn;
    }

}
