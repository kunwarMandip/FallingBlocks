package com.libgdx.fallingblocks.parser.dto.wave;

import java.util.Map;

public class EnemiesSpawnInfoDto {
    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemiesSpawnInfoDto(Map<String, Integer> spawnDirections, Map<String, Integer> enemyDistributions) {
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
