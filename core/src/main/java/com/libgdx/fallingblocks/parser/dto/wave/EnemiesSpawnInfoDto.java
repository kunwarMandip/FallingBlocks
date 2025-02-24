package com.libgdx.fallingblocks.parser.dto.wave;

import java.util.Map;

public class EnemiesSpawnInfoDto {

    private final Map<String, Integer> spawnDirections;
    private final Map<String, Integer> enemyDistributions;
    private final EnemySpawnConditionDto enemySpawnConditionDto;

    private EnemiesSpawnInfoDto(EnemiesSpawnInfoDtoBuilder builder) {
        enemyDistributions = builder.enemyDistributions;
        spawnDirections = builder.spawnDirections;
        enemySpawnConditionDto = builder.enemySpawnConditionDto;
    }

    public Map<String, Integer> getEnemyDistributions() {
        return enemyDistributions;
    }

    public Map<String, Integer> getSpawnDirections() {
        return spawnDirections;
    }

    public EnemySpawnConditionDto getEnemySpawnConditionDto() {
        return enemySpawnConditionDto;
    }


    public static final class EnemiesSpawnInfoDtoBuilder {
        private Map<String, Integer> enemyDistributions;
        private Map<String, Integer> spawnDirections;
        private EnemySpawnConditionDto enemySpawnConditionDto;

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

        public EnemiesSpawnInfoDtoBuilder setEnemySpawnConditionDto(EnemySpawnConditionDto enemySpawnConditionDto) {
            this.enemySpawnConditionDto = enemySpawnConditionDto;
            return this;
        }

        public EnemiesSpawnInfoDto build() {
            return new EnemiesSpawnInfoDto(this);
        }
    }
}


