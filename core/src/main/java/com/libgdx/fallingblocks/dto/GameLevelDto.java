package com.libgdx.fallingblocks.dto;

import com.badlogic.gdx.utils.Array;

public class GameLevelDto {

    private WorldDto worldDto;
    private TiledMapDto tiledMapDto;
    private Array<EnemyWaveDto> enemyWaveDtoArray;

    public Array<EnemyWaveDto> getWaveDtoArray() {
        return enemyWaveDtoArray;
    }

    public void setEnemyWaveDtoArray(Array<EnemyWaveDto> enemyWaveDtoArray) {
        this.enemyWaveDtoArray = enemyWaveDtoArray;
    }

    public WorldDto getWorldDto() {
        return worldDto;
    }

    public void setWorldDto(WorldDto worldDto) {
        this.worldDto = worldDto;
    }

    public TiledMapDto getTiledMapDto() {
        return tiledMapDto;
    }

    public void setTiledMapDto(TiledMapDto tiledMapDto) {
        this.tiledMapDto = tiledMapDto;
    }
}
