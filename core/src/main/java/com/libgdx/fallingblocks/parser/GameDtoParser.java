package com.libgdx.fallingblocks.parser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;
import com.libgdx.fallingblocks.parser.parsers.EnemyInfoParser;
import com.libgdx.fallingblocks.parser.parsers.TiledMapParser;
import com.libgdx.fallingblocks.parser.parsers.WaveSettingsParser;
import com.libgdx.fallingblocks.parser.parsers.Box2DWorldParser;

public class GameDtoParser {


    public GameDto getGameDto(int level){
        String worldDtoParserPath           = "jsons/wave/world/" + level +".json";
        String tiledMapDtoParserPath        = "jsons/wave/tiledMap/" + level +".json";
        String enemyInfoParserPath          = "jsons/wave/enemyInfo/" + level +".json";
        String timeParserPath               = "jsons/wave/waveSettings/" + level +".json";


        validateFilesExist(tiledMapDtoParserPath, enemyInfoParserPath, timeParserPath, worldDtoParserPath);

        Array<WaveSettingDto> waveSettingDtoArray= new WaveSettingsParser().getWaveSettingDtoArray(timeParserPath);
        Array<EnemiesSpawnInfoDto> enemyInfoDtoArray= new EnemyInfoParser().getEnemyInfoDto(enemyInfoParserPath);
        Array<TiledMapDto> tiledMapDtoArray= new TiledMapParser().getTiledMapDto(tiledMapDtoParserPath);
        Array<WorldDto> worldDtoArray= new Box2DWorldParser().getWorldDto(worldDtoParserPath);

        GameDto.GameDtoBuilder gameDtoBuilder= new GameDto.GameDtoBuilder()
            .setWaveSettingsDto(waveSettingDtoArray)
            .setEnemyInfoDto(enemyInfoDtoArray)
            .setTiledMapDto(tiledMapDtoArray)
            .setWorldDto(worldDtoArray);


        return gameDtoBuilder.build();
    }

    /**
     * Validates if all required files exist.
     *
     * @param filePaths Paths of required files
     * @throws IllegalArgumentException if any file is missing
     */
    private void validateFilesExist(String... filePaths) {
        for (String filePath : filePaths) {
            if (!Gdx.files.internal(filePath).exists()) {
                throw new IllegalArgumentException("Missing required file: " + filePath);
            }
        }
    }





}
