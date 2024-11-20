package com.libgdx.fallingblocks.dto;

import com.libgdx.fallingblocks.entity.enemy.Enemy;

import java.util.Stack;

public class EnemyWaveDto {
    private final boolean isWaveTimed;
    private final double waveDuration, waveStartDelay;
    private final String spawnPattern;
    private final Stack<EnemyDto> enemies;
    private float deltaTime = 0f;

    private EnemyWaveDto(EnemyWaveDtoBuilder builder) {
        this.enemies = builder.enemies;
        this.isWaveTimed = builder.isWaveTimed;
        this.waveDuration = builder.waveDuration;
        this.spawnPattern = builder.spawnPattern;
        this.waveStartDelay = builder.waveStartDelay;
        this.deltaTime = builder.deltaTime;
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

    public Stack<EnemyDto> getEnemies() {
        return enemies;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    // Builder Class
    public static class EnemyWaveDtoBuilder {
        private boolean isWaveTimed;
        private double waveDuration;
        private double waveStartDelay;
        private String spawnPattern;
        private Stack<EnemyDto> enemies;
        private float deltaTime = 0f;

        public EnemyWaveDtoBuilder setEnemyWave(Stack<EnemyDto> enemies) {
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

        public EnemyWaveDtoBuilder setDeltaTime(float deltaTime) {
            this.deltaTime = deltaTime;
            return this;
        }

        public EnemyWaveDto build() {
            return new EnemyWaveDto(this);
        }
    }
}

