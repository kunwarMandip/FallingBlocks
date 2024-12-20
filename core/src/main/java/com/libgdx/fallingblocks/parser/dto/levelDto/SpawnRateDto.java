package com.libgdx.fallingblocks.parser.dto.levelDto;

public class SpawnRateDto {

    private final float initialSpawnRate;

    public SpawnRateDto(float initialSpawnRate) {
        this.initialSpawnRate = initialSpawnRate;
    }

    public float getInitialSpawnRate() {
        return initialSpawnRate;
    }
}
