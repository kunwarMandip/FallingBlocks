package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.utils.Array;

import com.libgdx.fallingblocks.gameDto.GameDto;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.gameDto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.jsonParser.EnemyInfoParser;
import com.libgdx.fallingblocks.jsonParser.WaveSettingsParser;

public class DtoParserController {


    public GameDto getGameDto(int level){
        String timeParserPath= "jsons/enemyWaves/" + level +".json";
        String enemyInfoParserPath= "jsons/enemyInfo/" + level +".json";

        Array<WaveSettingDto> enemyWaveDtoArray= new WaveSettingsParser().getEnemyWavesDto(timeParserPath);
        Array<EnemyInfoDto> enemyInfoDtoArray= new EnemyInfoParser().getEnemyInfoDto(enemyInfoParserPath);

        GameDto.GameDtoBuilder gameDtoBuilder= new GameDto.GameDtoBuilder()
            .setEnemyInfoDto(enemyInfoDtoArray);


        return null;
    }





}
