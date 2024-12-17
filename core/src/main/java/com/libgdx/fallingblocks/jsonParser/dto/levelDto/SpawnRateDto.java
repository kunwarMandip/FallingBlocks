package com.libgdx.fallingblocks.jsonParser.dto.levelDto;

public class SpawnRateDto {

    private float initialSpawnRate;

    public SpawnRateDto(float initialSpawnRate) {
        this.initialSpawnRate = initialSpawnRate;
    }

    public float getInitialSpawnRate() {
        return initialSpawnRate;
    }
}
