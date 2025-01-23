package com.libgdx.fallingblocks.parser.parsers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.Logger;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;
import static com.libgdx.fallingblocks.GlobalVariables.isNodeExists;


public class WaveSettingsDtoParser {

    public Array<WaveSettingDto> getWaveSettingDtoArray(String filePath){
        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");
        isNodeExists(wavesNode);

        Array<WaveSettingDto> waveSettingDtoArray= new Array<>();
        for (JsonValue wave : wavesNode) {
            WaveSettingDto waveSettingDto = new WaveSettingDto();
            parseWaveSetting(wave, waveSettingDto);
            waveSettingDtoArray.add(waveSettingDto);
        }
        return waveSettingDtoArray;
    }



    private void parseWaveSetting(JsonValue wave, WaveSettingDto waveSettingDto){
        int totalEnemies= wave.getInt("totalEnemies", -1);
        float startDelay = wave.getFloat("startDelay", 0.0f);
        float duration = wave.getFloat("duration", 0.0f);
        String spawnCondition = wave.getString("spawnCondition", "none");

        waveSettingDto.setTotalEnemies(totalEnemies);
        waveSettingDto.setWaveStartDelay(startDelay);
        waveSettingDto.setDuration(duration);

        Logger.log(Logger.Tags.WAVE_PARSER, "Total Enemies: " + (waveSettingDto.getTotalEnemies()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Start Delay: " + (waveSettingDto.getWaveStartDelay()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Duration: " + (waveSettingDto.getDuration()));
    }
}


