package com.libgdx.fallingblocks.parser.dto.wave;

import com.badlogic.gdx.utils.Array;

import java.util.Map;

public class EnemiesSpawnInfoDto {

    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;
    private final Array<EnemySpawnConditionDto> enemySpawnConditionDtoArray;

    private EnemiesSpawnInfoDto(EnemiesSpawnInfoDtoBuilder builder) {
        enemyDistributions = builder.enemyDistributions;
        spawnDirections = builder.spawnDirections;
        enemySpawnConditionDtoArray = builder.enemySpawnConditionDtoArray;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public Map<String, Integer> getSpawnDirections() {
        return spawnDirections;
    }

    public Array<EnemySpawnConditionDto> getEnemySpawnConditionDtoArray() {
        return enemySpawnConditionDtoArray;
    }

    public static final class EnemiesSpawnInfoDtoBuilder {
        private Map<String, Integer> enemyDistributions;
        private Map<String, Integer> spawnDirections;
        private Array<EnemySpawnConditionDto> enemySpawnConditionDtoArray;

        public EnemiesSpawnInfoDtoBuilder() {
        }

        public EnemiesSpawnInfoDtoBuilder setEnemyDistributions(Map<String, Integer> enemyDistributions) {
            this.enemyDistributions = enemyDistributions;
            return this;
        }

        public EnemiesSpawnInfoDtoBuilder setSpawnDirections(Map<String, Integer> spawnDirections) {
            this.spawnDirections = spawnDirections;
            return this;
        }

        public EnemiesSpawnInfoDtoBuilder setEnemySpawnConditionDtoArray(Array<EnemySpawnConditionDto> enemySpawnConditionDtoArray) {
            this.enemySpawnConditionDtoArray = enemySpawnConditionDtoArray;
            return this;
        }

        public EnemiesSpawnInfoDto build() {
            return new EnemiesSpawnInfoDto(this);
        }
    }
}
