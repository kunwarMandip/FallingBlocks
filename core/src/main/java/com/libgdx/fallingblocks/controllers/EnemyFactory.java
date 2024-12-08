package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector4;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.dto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.DashMovement;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.MeleeAttack;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.RangeAttack;
import com.libgdx.fallingblocks.entity.common.behaviour.strategies.SlowMovement;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.map.objects.EnemySpawnArea;

import java.util.Map;

public class EnemyFactory {
    private World world;
    private Array<EnemySpawnArea> enemySpawnAreas;
    private final Map<String, Float> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyFactory(EnemyInfoDto enemyInfoDto){
        this.spawnDirections=enemyInfoDto.getSpawnDirections();
        this.enemyDistributions=enemyInfoDto.getEnemyDistributions();
    }

    public EnemyFactory(World world, EnemyInfoDto enemyInfoDto, Array<EnemySpawnArea> enemySpawnAreas){
        this.world=world;
        this.enemySpawnAreas=enemySpawnAreas;
        this.spawnDirections=enemyInfoDto.getSpawnDirections();
        this.enemyDistributions=enemyInfoDto.getEnemyDistributions();
    }


//    public Enemy getEnemy(EnemyType enemyTypeToSpawn){
//        int health=50;
//        Vector2 speed=null;
//        Vector2 spawnPosition=getSpawnPosition(null);
//        Vector2 bodyDimension=null;
//
//        Vector4 spawnPositionSpeed= getEnemySpawnAndSpeedInfo()
//        switch (enemyTypeToSpawn) {
//            case NORMAL:
//                return new NormalEnemy(world, health, spawnPosition, bodyDimension, speed,
//                    new MeleeAttack(), new DashMovement());
//
//            case BOSS:
//                return new BossEnemy(world, health, spawnPosition, bodyDimension, speed,
//                    new RangeAttack(), new DashMovement());
//
//            case QUICK:
//                return new NormalEnemy(world, health, spawnPosition, bodyDimension, speed,
//                    new RangeAttack(), new SlowMovement());
//
//            default:
//                throw new RuntimeException("Unidentified Enemy Type on WaveController.build()");
//        }
//    }

    public Enemy getEnemy(Vector2 playerLocation){
        int health=50;
        Vector2 enemySpeed= new Vector2(5, 5);
        Vector4 spawnPositionSpeed= getEnemySpawnAndSpeedInfo(playerLocation, enemySpeed);

        Vector2 spawnPosition= new Vector2(spawnPositionSpeed.x, spawnPositionSpeed.y);
        Vector2 speed= new Vector2(spawnPositionSpeed.z, spawnPositionSpeed.w);

        return new NormalEnemy(world, health, spawnPosition, new Vector2(3, 3), speed,
                    new MeleeAttack(), new DashMovement());
    }

    private Vector4 getEnemySpawnAndSpeedInfo(Vector2 playerLocation, Vector2 enemyCurrentSpeed){

        EnemySpawnArea spawnArea= enemySpawnAreas.get(1);
        Vector2 enemyMovementSpeed, enemySpawnLocation;

        switch(spawnArea.getSpawnDirection()){
            case "bottom":
                enemySpawnLocation= new Vector2(playerLocation.x, spawnArea.getPosition().y);
                enemyMovementSpeed= new Vector2(0, enemyCurrentSpeed.y);
                break;
            case "left":
                enemySpawnLocation= new Vector2(spawnArea.getPosition().x, playerLocation.y);
                enemyMovementSpeed= new Vector2(enemyCurrentSpeed.x, 0);
                break;
            case "right":
                enemySpawnLocation= new Vector2(spawnArea.getPosition().y, playerLocation.y);
                enemyMovementSpeed= new Vector2(-enemyCurrentSpeed.x, 0);
                break;
            case "top":
            default:
                enemySpawnLocation= new Vector2(playerLocation.x, spawnArea.getPosition().y);
                enemyMovementSpeed= new Vector2(enemyCurrentSpeed.x, -enemyCurrentSpeed.y);
                break;
        }

        return new Vector4(enemyMovementSpeed.x, enemyMovementSpeed.y, enemySpawnLocation.x, enemySpawnLocation.y);
    }
}
