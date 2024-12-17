package com.libgdx.fallingblocks.jsonParser.dto;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.*;

public class WaveManager {

    public WorldDto getWorldDto(Array<WorldDto> worldDtoArray){
        return worldDtoArray.pop();
    }

    public TiledMapDto getTiledMapDto(Array<TiledMapDto> tiledMapDtoArray){

        return tiledMapDtoArray.pop();
//        return null;
    }

    public WaveSettingDto getWaveSettingDto(Array<WaveSettingDto> waveSettingDtoArray){
        return null;
    }

    public PlayerDto getPlayerDto(Array<PlayerDto> playerDtoArray){
        return null;
    }

    public EnemiesDto getEnemyInfoDto(Array<EnemiesDto> enemyInfoDtoArray){
        return enemyInfoDtoArray.pop();
    }

}
