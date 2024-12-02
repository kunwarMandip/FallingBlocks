package com.libgdx.fallingblocks.dto;

import com.libgdx.fallingblocks.entity.enemy.EnemyType;


public class EnemyDto {

    //Type creates outline of basic enemy
    //HEALTH & attackPoints is custom
    //Wave will have the
    private final EnemyType enemyType;
    public int health, attackPoints;

    public EnemyDto(EnemyDtoBuilder enemyDtoBuilder){
        this.enemyType=enemyDtoBuilder.enemyType;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }



    public static class EnemyDtoBuilder{
        private EnemyType enemyType;
        public int health, attackPoints;

        public EnemyDtoBuilder setType(EnemyType enemyType) {
            this.enemyType=enemyType;
            return this;
        }


        public EnemyDto build(){
            return new EnemyDto(this);
        }
    }
}
