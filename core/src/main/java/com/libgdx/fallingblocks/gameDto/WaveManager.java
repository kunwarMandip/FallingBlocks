package com.libgdx.fallingblocks.gameDto;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.gameDto.levelDto.*;

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

    public EnemyInfoDto getEnemyInfoDto( Array<EnemyInfoDto> enemyInfoDtoArray){
        return enemyInfoDtoArray.pop();
    }

}
