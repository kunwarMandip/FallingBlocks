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

    }

    private EnemyType getEnemyType(){
        String enemy= getString(enemyDistributions);
//        Logger.log(Logger.Tags.ENEMY_SPAWNER, enemyDistributions.toString());
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
        switch(movementDirection){
            case TOP:
            case BOTTOM:
                return new Vector2(playerLocation.x, spawnArea.y);
            case RIGHT:
            case LEFT:
                return new Vector2(spawnArea.x, playerLocation.y);
        }
        throw new IllegalStateException("EnemyDtoCreator: Unknown Cardinal Spawn Direction");
    }


    public EnemyDto getEnemyDto(Vector2 playerLocation) {
        EnemyType enemyType= getEnemyType();
        MovementDirection spawnCardinalDirection= getMovementDirection();
        Vector2 spawnPosition= getSpawnPosition(spawnCardinalDirection, playerLocation);

        return new EnemyDto(enemyType, spawnCardinalDirection, spawnPosition);
    }
}
