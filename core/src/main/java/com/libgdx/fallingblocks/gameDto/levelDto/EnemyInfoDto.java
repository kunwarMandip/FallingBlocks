package com.libgdx.fallingblocks.gameDto.levelDto;

import java.util.Map;

public class EnemyInfoDto {
    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyInfoDto(Map<String, Integer> spawnDirections, Map<String, Integer> enemyDistributions) {
        this.spawnDirections = spawnDirections;
        this.enemyDistributions = enemyDistributions;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public Map<String, Integer> getSpawnDirections() {
        return spawnDirections;
    }
}
