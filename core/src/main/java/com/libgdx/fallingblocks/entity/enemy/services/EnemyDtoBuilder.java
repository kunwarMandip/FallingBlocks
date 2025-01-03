package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.entity.enemy.types.EnemyType;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;

import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.getRandomValue;

public final class EnemyDtoBuilder {

    private final Vector2 playerPosition;
    private final MovementCalculator movementCalculator;
    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyDtoBuilder(Vector2 playerPosition, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas){
        this.playerPosition = playerPosition;
        this.spawnDirections= enemiesSpawnInfoDto.getSpawnDirections();
        this.enemyDistributions= enemiesSpawnInfoDto.getEnemyDistributions();
        this.movementCalculator= new MovementCalculator(spawnAreas);
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


    public EnemyDto getEnemyDto() {
        EnemyType enemyType= getEnemyType();
        MovementDirection relativeDirection= getMovementDirection();
        Vector2 speed= movementCalculator.calculateSpeed(relativeDirection);
        Vector2 spawnPosition= movementCalculator.calculateSpawnPosition(relativeDirection, playerPosition);

        return new EnemyDto(enemyType, relativeDirection,  speed, spawnPosition);
    }
}
