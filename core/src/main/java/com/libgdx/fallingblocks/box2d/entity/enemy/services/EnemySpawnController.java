package com.libgdx.fallingblocks.box2d.entity.enemy.services;


import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;
import com.libgdx.fallingblocks.box2d.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.box2d.entity.enemy.spawner.EnemySpawner;

public class EnemySpawnController {

    private EnemySpawner enemySpawner;
    private EnemyDtoBuilder enemyDtoFactory;
    private final Array<Enemy> enemies= new Array<>();

//    public EnemySpawnController(World world){
//        this.enemySpawner= new EnemySpawner();
//        this.enemyDtoFactory= new EnemyDtoBuilder();
//    }


//    public void spawnEnemies(Vector2 playerPosition){
//        int numEnemyToSpawn = enemySpawner.getNumEnemyToSpawn();
//        for (int i = 0; i < numEnemyToSpawn; i++) {
//            EnemyDto enemyDto = enemyDtoFactory.getEnemyDto(playerPosition);
//            enemies.add(tempEnemyFactory.getEnemy(enemyDto));
//        }
//        enemySpawner.resetNumEnemyToSpawn();
//    }

    public void update(float delta){

//        numEnemiesToSpawn+=enemySpawnRateController.getNumEnemyToSpawn();
//        if(numEnemiesToSpawn>0){
//            tempEnemyFactory.createEnemy();
//        }
    }



}
