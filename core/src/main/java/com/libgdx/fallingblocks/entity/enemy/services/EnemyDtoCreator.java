package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemiesDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.getRandomValue;

public final class EnemyDtoCreator{

    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;
    private final Map<MovementDirection, Vector2> spawnAreas;

    public EnemyDtoCreator(EnemiesDto enemiesDto, Map<MovementDirection, Vector2> spawnAreas){
        this.spawnAreas= spawnAreas;
        this.spawnDirections= enemiesDto.getSpawnDirections();
        this.enemyDistributions= enemiesDto.getEnemyDistributions();


        Logger.log(Logger.Tags.ENEMY_SPAWNER, spawnAreas.toString());
    }

    private EnemyType getEnemyType(){
        String enemy= getString(enemyDistributions);
        return EnemyType.valueOf(enemy.toUpperCase());
    }

    private MovementDirection getMovementDirection(){
        return MovementDirection.valueOf(getString(spawnDirections).toUpperCase());
    }

    private String getString(Map<String, Integer> map) {
        int randomValue = getRandomValue(100);

        int cumulativeSum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            cumulativeSum += entry.getValue();
            if (cumulativeSum >= randomValue) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("EnemyDtoGenerator: Error on getString(): \n"+ map);
    }

    private Vector2 getSpawnPosition(MovementDirection movementDirection, Vector2 playerLocation){
        Vector2 spawnArea= spawnAreas.get(movementDirection);
        Vector2 spawnPosition;
        switch(movementDirection){
            case TOP :
            case BOTTOM:
                spawnPosition= new Vector2(playerLocation.x,spawnArea.y);
                break;
            case RIGHT:
                spawnPosition= new Vector2(spawnArea.y, playerLocation.y);
                break;
            case LEFT:
                spawnPosition= new Vector2(spawnArea.x, playerLocation.y );
                break;
            default:
                throw new IllegalStateException("EnemyDtoCreator: Unknown Cardinal Spawn Direction");
        }
        Logger.log(Logger.Tags.ENEMY_SPAWNER,
            "SpawnDirection" + movementDirection + " | SpawnPosition"+ playerLocation
                + " | PlayerPosition" + spawnPosition + " | SpawnAreaPosition" + spawnArea);
        return spawnPosition;
    }

    private Vector2 getSpeed(MovementDirection movementDirection){
        float constantSpeed=5f;
        Vector2 speed;
        switch(movementDirection){
            case TOP:
                speed= new Vector2(0, -(constantSpeed));
                break;
            case BOTTOM:
                speed= new Vector2(0, constantSpeed);
                break;
            case RIGHT:
                speed= new Vector2(-constantSpeed, 0);
                break;
            case LEFT:
                speed=  new Vector2(constantSpeed, 0);
                break;
            default:
                throw new IllegalStateException("EnemyDtoCreator: Unknown Cardinal Spawn Direction");
        }

        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Speed" + speed);
        return speed;
    }


    public EnemyDto getEnemyDto(Vector2 playerLocation) {
        EnemyType enemyType= getEnemyType();
        MovementDirection spawnCardinalDirection= getMovementDirection();

        Vector2 speed= getSpeed(spawnCardinalDirection);
        Vector2 spawnPosition= getSpawnPosition(spawnCardinalDirection, playerLocation);


        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Spawn Direction: "+ spawnCardinalDirection + " | " + spawnPosition);
        return new EnemyDto(enemyType, spawnCardinalDirection,  speed, spawnPosition);
    }
}
