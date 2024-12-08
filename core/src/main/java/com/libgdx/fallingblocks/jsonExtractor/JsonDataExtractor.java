package com.libgdx.fallingblocks.jsonExtractor;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;

public class JsonDataExtractor {

    public GameLevelDto getGameLevelDto(int level){
        GameLevelDto gameLevelDto= new GameLevelDto();

        //EnemyWaveDto
        String waveFilePath= "jsons/enemyWaves/" + level +".json";
        Array<EnemyWaveDto> enemyWaveDtoArray= new WaveExtractor().getEnemyWavesDto(waveFilePath);
        gameLevelDto.setEnemyWaveDtoArray(enemyWaveDtoArray);
        return gameLevelDto;
    }


    public static void isFileExist(FileHandle fileHandle){
        if(!fileHandle.exists()){
           throw new RuntimeException(fileHandle.path() + " not Found");
        }
    }



}
