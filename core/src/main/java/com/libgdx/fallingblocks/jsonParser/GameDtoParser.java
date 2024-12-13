package com.libgdx.fallingblocks.jsonParser;

import com.badlogic.gdx.utils.Array;

import com.libgdx.fallingblocks.gameDto.GameDto;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.gameDto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.jsonParser.parsers.EnemyInfoParser;
import com.libgdx.fallingblocks.jsonParser.parsers.WaveSettingsParser;

public class GameDtoParser {


    public GameDto getGameDto(int level){
        String timeParserPath= "jsons/wave/waveSettings/" + level +".json";
        String enemyInfoParserPath= "jsons/wave/enemyInfo/" + level +".json";

        Array<WaveSettingDto> waveSettingDtoArray= new WaveSettingsParser().getWaveSettingDtoArray(timeParserPath);
        Array<EnemyInfoDto> enemyInfoDtoArray= new EnemyInfoParser().getEnemyInfoDto(enemyInfoParserPath);

        GameDto.GameDtoBuilder gameDtoBuilder= new GameDto.GameDtoBuilder()
            .setWaveSettingsDto(waveSettingDtoArray)
            .setEnemyInfoDto(enemyInfoDtoArray);

        return gameDtoBuilder.build();
    }




}
