package com.libgdx.fallingblocks.dto;

import java.util.Map;

public class EnemyInfoDto {
    private Map<String, Integer> spawnDirections;
    private Map<String, Integer> enemyDistributions;

    public Map<String, Integer> getSpawnDirections() {
        return spawnDirections;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public void setSpawnDirections(Map<String, Integer> spawnDirections) {
        this.spawnDirections = spawnDirections;
    }

    public void setEnemyDistributions(Map<String, Integer> enemyDistributions) {
        this.enemyDistributions = enemyDistributions;
    }
}
