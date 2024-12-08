package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.utils.Array;

public class GameLevelDto {

    private Array<EnemyWaveDto> enemyWaveDtoArray;

    public Array<EnemyWaveDto> getWaveDtoArray() {
        return enemyWaveDtoArray;
    }

    public void setEnemyWaveDtoArray(Array<EnemyWaveDto> enemyWaveDtoArray) {
        this.enemyWaveDtoArray = enemyWaveDtoArray;
    }
}
