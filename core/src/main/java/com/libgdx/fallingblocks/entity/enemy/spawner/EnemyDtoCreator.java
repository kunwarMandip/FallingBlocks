package com.libgdx.fallingblocks.entity.enemy.spawner;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;
import com.libgdx.fallingblocks.entity.enemy.services.MovementCalculator;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.EnemiesDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.getRandomValue;

public final class EnemyDtoCreator{

    private final MovementCalculator movementCalculator;
    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyDtoCreator(EnemiesDto enemiesDto, Map<MovementDirection, Vector2> spawnAreas){
        this.spawnDirections= enemiesDto.getSpawnDirections();
        this.enemyDistributions= enemiesDto.getEnemyDistributions();

        this.movementCalculator= new MovementCalculator(spawnAreas);
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


    public EnemyDto getEnemyDto(Vector2 playerLocation) {
        EnemyType enemyType= getEnemyType();
        MovementDirection relativeDirection= getMovementDirection();
        Vector2 speed= movementCalculator.calculateSpeed(relativeDirection);
        Vector2 spawnPosition= movementCalculator.calculateSpawnPosition(relativeDirection, playerLocation);

        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Spawn Direction: "+ relativeDirection + " | " + spawnPosition);
        return new EnemyDto(enemyType, relativeDirection,  speed, spawnPosition);
    }
}
