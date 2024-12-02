package com.libgdx.fallingblocks.dto;

import java.util.Map;

public class EnemyWaveDto {

    private final float duration;
    private final float startDelay;
    private final int totalEnemies;
    private final float spawnRateStart;
    private final float spawnRateIncrease;
    private final float spawnRateIncreaseIncrement;
    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;

    public EnemyWaveDto(EnemyWaveDtoBuilder enemyWaveDtoBuilder){
        this.totalEnemies=enemyWaveDtoBuilder.totalEnemies;
        this.startDelay=enemyWaveDtoBuilder.startDelay;
        this.duration=enemyWaveDtoBuilder.duration;
        this.spawnRateStart= enemyWaveDtoBuilder.spawnRateStart;
        this.spawnRateIncrease= enemyWaveDtoBuilder.spawnRateIncrease;
        this.spawnRateIncreaseIncrement= enemyWaveDtoBuilder.spawnRateIncreaseIncrement;
        this.spawnDirections= enemyWaveDtoBuilder.spawnDirections;
        this.enemyDistributions=enemyWaveDtoBuilder.enemyDistributions;

    }

    public int getTotalEnemies() {
        return totalEnemies;
    }

    public float getStartDelay() {
        return startDelay;
    }

    public float getDuration() {
        return duration;
    }

    public float getSpawnRateStart() {
        return spawnRateStart;
    }

    public float getSpawnRateIncreaseIncrement() {
        return spawnRateIncreaseIncrement;
    }

    public float getSpawnRateIncrease() {
        return spawnRateIncrease;
    }

    public Map<String, Integer> getSpawnDirections() {
        return spawnDirections;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public static class EnemyWaveDtoBuilder{

        private float duration;
        private float startDelay;
        private int totalEnemies;
        private float spawnRateStart;
        private float spawnRateIncrease;
        private float spawnRateIncreaseIncrement;
        private Map<String, Integer> spawnDirections;
        private Map<String, Integer> enemyDistributions;

        public EnemyWaveDtoBuilder setTotalEnemies(int totalEnemies) {
            this.totalEnemies = totalEnemies;
            return this;
        }

        public EnemyWaveDtoBuilder setDuration(float duration) {
            this.duration = duration;
            return this;
        }

        public EnemyWaveDtoBuilder setStartDelay(float startDelay) {
            this.startDelay = startDelay;
            return this;
        }

        public EnemyWaveDtoBuilder setSpawnRateStart(float spawnRateStart) {
            this.spawnRateStart = spawnRateStart;
            return this;
        }

        public EnemyWaveDtoBuilder setSpawnRateIncrease(float spawnRateIncrease) {
            this.spawnRateIncrease = spawnRateIncrease;
            return this;
        }

        public EnemyWaveDtoBuilder setSpawnRateIncreaseIncrement(float spawnRateIncreaseIncrement) {
            this.spawnRateIncreaseIncrement = spawnRateIncreaseIncrement;
            return this;
        }

        public EnemyWaveDtoBuilder setSpawnDirections(Map<String, Integer> spawnDirections) {
            this.spawnDirections = spawnDirections;
            return this;
        }

        public EnemyWaveDtoBuilder setEnemyDistributions(Map<String, Integer> enemyDistributions) {
            this.enemyDistributions = enemyDistributions;
            return this;
        }
    }
}
