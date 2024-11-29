package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.utils.Array;

import java.util.Stack;

public class EnemyWaveDto {
    private final boolean isWaveTimed;
    private final double waveDuration, waveStartDelay;
    private final String spawnPattern;
    private final Array<EnemyDto> enemies;
    private final float enemySpawnInterval;

    private EnemyWaveDto(EnemyWaveDtoBuilder builder) {
        this.enemies = builder.enemies;
        this.isWaveTimed = builder.isWaveTimed;
        this.waveDuration = builder.waveDuration;
        this.spawnPattern = builder.spawnPattern;
        this.waveStartDelay = builder.waveStartDelay;
        this.enemySpawnInterval = 0;
    }


    public boolean isWaveTimed() {
        return isWaveTimed;
    }

    public double getWaveDuration() {
        return waveDuration;
    }

    public double getWaveStartDelay() {
        return waveStartDelay;
    }

    public String getSpawnPattern() {
        return spawnPattern;
    }

    public Array<EnemyDto> getEnemies() {
        return enemies;
    }

    /**
     * Get top enemy and remove it from the stack
     * @return Info about the enemy
     */
    public EnemyDto getEnemy(){
        return enemies.pop();
    }

    public float getEnemySpawnInterval(){
        return enemySpawnInterval;
    }

    // Builder Class
    public static class EnemyWaveDtoBuilder {
        private boolean isWaveTimed;
        private double waveDuration;
        private double waveStartDelay;
        private String spawnPattern;
        private Array<EnemyDto> enemies;

        public EnemyWaveDtoBuilder setEnemyWave(Array<EnemyDto> enemies) {
            this.enemies = enemies;
            return this;
        }

        public EnemyWaveDtoBuilder setWaveTimed(boolean isWaveTimed) {
            this.isWaveTimed = isWaveTimed;
            return this;
        }

        public EnemyWaveDtoBuilder setWaveDuration(double waveDuration) {
            this.waveDuration = waveDuration;
            return this;
        }

        public EnemyWaveDtoBuilder setWaveStartDelay(double waveStartDelay) {
            this.waveStartDelay = waveStartDelay;
            return this;
        }

        public EnemyWaveDtoBuilder setSpawnPattern(String spawnPattern) {
            this.spawnPattern = spawnPattern;
            return this;
        }

        public EnemyWaveDto build() {
            return new EnemyWaveDto(this);
        }
    }
}

