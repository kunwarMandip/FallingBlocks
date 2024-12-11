package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;

import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.getRandomValue;

public final class EnemyDtoCreator{

    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyDtoCreator(EnemyInfoDto enemyInfoDto){
        this.spawnDirections=enemyInfoDto.getSpawnDirections();
        this.enemyDistributions=enemyInfoDto.getEnemyDistributions();
    }

    private EnemyType getEnemyType(){
        String enemy= getString(enemyDistributions);
        return EnemyType.valueOf(enemy.toUpperCase());
    }

    private String getSpawnDirection(){
        return getString(spawnDirections);
    }

    private Vector2 getSpawnPosition(String spawnDirection){
        return null;
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
        String spawnDirection= getSpawnDirection();
        Vector2 spawnPosition= getSpawnPosition(spawnDirection);
        return new EnemyDto(enemyType, spawnDirection, spawnPosition);
    }
}
