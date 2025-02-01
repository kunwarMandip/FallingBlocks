package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRateConditions;
import com.libgdx.fallingblocks.game.spawn.SpawnController;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyFactory;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;

public class EnemySpawnManager {

    private final Array<Enemy> currentEnemies;
    private final EnemyDtoBuilder dtoBuilder;
    private final EnemyFactory enemyFactory;


    private SpawnRateConditions spawnRateConditions;

    public EnemySpawnManager(World world, Vector2 playerPosition, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas, Array<Enemy> currentEnemies){
        this.currentEnemies=currentEnemies;
        this.enemyFactory= new EnemyFactory(world);
        this.dtoBuilder= new EnemyDtoBuilder(playerPosition, enemiesSpawnInfoDto, spawnAreas);
    }



    public void spawn(){

    }

//    public void spawnEnemies(){
//
//        if(enemySpawnCounter >= maxEnemySpawnAble){
//            Logger.log(SPAWN_ENEMY, "Max Enemy Spawned");
//            return;
//        }

    //        int numEnemyToSpawn= spawnRateConditions.getAmountToSpawn();
    //
    //        for(int i=0; i<numEnemyToSpawn; i++){
    //            Logger.log(SPAWN_ENEMY, "Spawning Enemy");
    //            EnemyDto enemyDto= dtoBuilder.getEnemyDto();
    //            currentEnemies.add(enemyFactory.createEnemy(enemyDto));
    //            enemySpawnCounter++;
    //        }
//    }



}
