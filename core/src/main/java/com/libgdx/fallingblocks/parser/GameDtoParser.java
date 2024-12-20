package com.libgdx.fallingblocks.parser;

import com.badlogic.gdx.utils.Array;

import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;
import com.libgdx.fallingblocks.parser.parsers.EnemyInfoDtoParser;
import com.libgdx.fallingblocks.parser.parsers.TiledMapParser;
import com.libgdx.fallingblocks.parser.parsers.WaveSettingsDtoParser;
import com.libgdx.fallingblocks.parser.parsers.WorldDtoParser;

public class GameDtoParser {


    public GameDto getGameDto(int level){
        String tiledMapDtoParserPath= "jsons/wave/tiledMap/" + level +".json";
        String enemyInfoParserPath= "jsons/wave/enemyInfo/" + level +".json";
        String timeParserPath= "jsons/wave/waveSettings/" + level +".json";
        String worldDtoParserPath= "jsons/wave/world/" + level +".json";

        Array<WaveSettingDto> waveSettingDtoArray= new WaveSettingsDtoParser().getWaveSettingDtoArray(timeParserPath);
        Array<EnemiesDto> enemyInfoDtoArray= new EnemyInfoDtoParser().getEnemyInfoDto(enemyInfoParserPath);
        Array<TiledMapDto> tiledMapDtoArray= new TiledMapParser().getTiledMapDto(tiledMapDtoParserPath);
        Array<WorldDto> worldDtoArray= new WorldDtoParser().getWorldDto(worldDtoParserPath);

        GameDto.GameDtoBuilder gameDtoBuilder= new GameDto.GameDtoBuilder()
            .setWaveSettingsDto(waveSettingDtoArray)
            .setEnemyInfoDto(enemyInfoDtoArray)
            .setTiledMapDto(tiledMapDtoArray)
            .setWorldDto(worldDtoArray);


        return gameDtoBuilder.build();
    }




}
