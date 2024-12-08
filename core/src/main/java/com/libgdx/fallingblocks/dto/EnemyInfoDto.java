package com.libgdx.fallingblocks.dto;

import java.util.Map;

public class EnemyInfoDto {
    private Map<String, Float> spawnDirections;
    private Map<String, Integer> enemyDistributions;

    public Map<String, Float> getSpawnDirections() {
        return spawnDirections;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public void setSpawnDirections(Map<String, Float> spawnDirections) {
        this.spawnDirections = spawnDirections;
    }

    public void setEnemyDistributions(Map<String, Integer> enemyDistributions) {
        this.enemyDistributions = enemyDistributions;
    }
}
