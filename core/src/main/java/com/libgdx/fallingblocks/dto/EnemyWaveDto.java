package com.libgdx.fallingblocks.dto;

public class EnemyWaveDto {

    private int totalEnemies;
    private float duration, waveStartDelay, spawnRateStart, spawnRateIncrement,spawnRateIncreaseInterval;
    private EnemyInfoDto enemyInfoDto= new EnemyInfoDto();

    public int getTotalEnemies() {
        return totalEnemies;
    }

    public void setTotalEnemies(int totalEnemies) {
        this.totalEnemies = totalEnemies;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getWaveStartDelay() {
        return waveStartDelay;
    }

    public void setWaveStartDelay(float waveStartDelay) {
        this.waveStartDelay = waveStartDelay;
    }

    public float getSpawnRateIncrement() {
        return spawnRateIncrement;
    }

    public void setSpawnRateIncrement(float spawnRateIncrement) {
        this.spawnRateIncrement = spawnRateIncrement;
    }

    public float getSpawnRateStart() {
        return spawnRateStart;
    }

    public void setSpawnRateStart(float spawnRateStart) {
        this.spawnRateStart = spawnRateStart;
    }

    public float getSpawnRateIncreaseInterval() {
        return spawnRateIncreaseInterval;
    }

    public void setSpawnRateIncreaseInterval(float spawnRateIncreaseInterval) {
        this.spawnRateIncreaseInterval = spawnRateIncreaseInterval;
    }

    public EnemyInfoDto getEnemyInfoDto() {
        return enemyInfoDto;
    }

    public void setEnemyInfoDto(EnemyInfoDto enemyInfoDto) {
        this.enemyInfoDto = enemyInfoDto;
    }
}
