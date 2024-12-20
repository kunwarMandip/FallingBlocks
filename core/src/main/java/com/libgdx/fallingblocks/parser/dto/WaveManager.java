package com.libgdx.fallingblocks.parser.dto;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;

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
