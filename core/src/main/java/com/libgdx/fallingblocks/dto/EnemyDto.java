package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.math.Vector2;

public class EnemyDto {

    private final Vector2 speed;
    private final float spawnTime;
    private final String type, behavior, effect;

    public int health;
    public Vector2 bodyDimension;
    public EnemyDto(EnemyDtoBuilder enemyDtoBuilder){
        this.type = enemyDtoBuilder.type;
        this.speed = enemyDtoBuilder.speed;
        this.spawnTime = enemyDtoBuilder.spawnTime;
        this.behavior = enemyDtoBuilder.behavior;
        this.effect = enemyDtoBuilder.effect;
        this.bodyDimension= new Vector2(5, 5);
    }

    public String getType() {
        return type;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public float getSpawnTime() {
        return spawnTime;
    }

    public String getBehavior() {
        return behavior;
    }

    public String getEffect() {
        return effect;
    }

    public static class EnemyDtoBuilder{
        private String type;
        private Vector2 speed;
        private float spawnTime;
        private String behavior, effect;

        public EnemyDtoBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public EnemyDtoBuilder setSpeed(Vector2 speed) {
            this.speed = speed;
            return this;
        }

        public EnemyDtoBuilder setSpawnTime(float spawnTime) {
            this.spawnTime = spawnTime;
            return this;
        }

        public EnemyDtoBuilder setBehavior(String behavior) {
            this.behavior = behavior;
            return this;
        }

        public EnemyDtoBuilder setEffect(String effect) {
            this.effect = effect;
            return this;
        }

        public EnemyDto build(){
            return new EnemyDto(this);
        }
    }
}
