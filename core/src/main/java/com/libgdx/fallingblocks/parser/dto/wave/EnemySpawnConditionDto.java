package com.libgdx.fallingblocks.parser.dto.wave;

import com.badlogic.gdx.utils.Array;

public class EnemySpawnConditionDto {

    private final String spawnCondition;
    private final Array<?> spawnArguments;

    public EnemySpawnConditionDto(String spawnCondition, Array<?> spawnArguments) {
        this.spawnCondition = spawnCondition;
        this.spawnArguments = spawnArguments;
    }

    public String getSpawnCondition() {
        return spawnCondition;
    }

    public Array<?> getSpawnArguments() {
        return spawnArguments;
    }
}
