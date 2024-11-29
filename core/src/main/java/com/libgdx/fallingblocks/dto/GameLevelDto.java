package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.utils.Array;

import java.util.Stack;

public class GameLevelDto {

    private final Array<EnemyWaveDto> enemyWaveDtoArray;

    public GameLevelDto(GameLevelDtoBuilder gameLevelDtoBuilder){
        this.enemyWaveDtoArray=gameLevelDtoBuilder.enemyWaveDtoArray;
    }

    public Array<EnemyWaveDto> getWaveDtoArray() {
        return enemyWaveDtoArray;
    }

    public static class GameLevelDtoBuilder{
        private Array<EnemyWaveDto> enemyWaveDtoArray;

        public GameLevelDtoBuilder setEnemyWaveDtoArray(Array<EnemyWaveDto> enemyWaveDtoArray) {
            this.enemyWaveDtoArray = enemyWaveDtoArray;
            return this;
        }

        public GameLevelDto build(){
            return new GameLevelDto(this);
        }
    }

}
