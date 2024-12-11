package com.libgdx.fallingblocks.controllers;

import com.libgdx.fallingblocks.controllers.listeners.EnemyDtoGenerator;
import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.dto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;

import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.getRandomValue;

public class EnemyDtoCreator implements EnemyDtoGenerator {

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

    private String getSpawnPosition(){
        return getString(spawnDirections);
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

    @Override
    public EnemyDto getEnemyDto() {
        return new EnemyDto(getEnemyType(), getSpawnPosition());
    }
}
