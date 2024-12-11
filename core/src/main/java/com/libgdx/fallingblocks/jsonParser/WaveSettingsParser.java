package com.libgdx.fallingblocks.jsonParser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.gameDto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.Logger;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;


public class WaveSettingsParser {

    public Array<WaveSettingDto> getEnemyWavesDto(String filepath) {
        Array<WaveSettingDto> enemyWaveDtoArray = new Array<>();
        FileHandle fileHandle = Gdx.files.internal(filepath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);

        JsonValue wavesNode = root.get("waves");
        isWaveNodeExists(root);
        for (JsonValue wave : wavesNode) {
            WaveSettingDto waveSettingDto = new WaveSettingDto();
            isSpawnSettingsExists(wave);
            JsonValue spawnSettings = wave.get("spawnSettings");

            parseWaveSetting(wave, waveSettingDto);
            parseWaveSpawnSettings(spawnSettings, waveSettingDto);
            enemyWaveDtoArray.add(waveSettingDto);
        }
        return enemyWaveDtoArray;
    }


    public void isWaveNodeExists(JsonValue wavesNode){
        if (wavesNode == null) {
            throw new RuntimeException("Json. Wave Node not Found");
        }
    }

    public void parseWaveSetting(JsonValue wave, WaveSettingDto waveSettingDto){
        int totalEnemies= wave.getInt("totalEnemies", -1);
        float startDelay = wave.getFloat("startDelay", 0.0f);
        float duration = wave.getFloat("duration", 0.0f);

        waveSettingDto.setTotalEnemies(totalEnemies);
        waveSettingDto.setWaveStartDelay(startDelay);
        waveSettingDto.setDuration(duration);

        Logger.log(Logger.Tags.WAVE_PARSER, "Total Enemies: " + (waveSettingDto.getTotalEnemies()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Start Delay: " + (waveSettingDto.getWaveStartDelay()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Duration: " + (waveSettingDto.getDuration()));
    }

    public void isSpawnSettingsExists(JsonValue wave){
        JsonValue spawnSettings = wave.get("spawnSettings");
        if (spawnSettings == null) {
            throw new RuntimeException("Json. Wave Settings not Found");
        }
    }

    public void parseWaveSpawnSettings(JsonValue spawnSettings, WaveSettingDto waveSettingDto){
        JsonValue spawnRateNode = spawnSettings.get("spawnRate");
        float spawnRateStart = spawnRateNode.getFloat("start", 0.0f);
        float spawnRateIncrement = spawnRateNode.getFloat("increment", 0.0f);
        float spawnRateInterval = spawnRateNode.getFloat("interval", 0.0f);

        waveSettingDto.setSpawnRateStart(spawnRateStart);
        waveSettingDto.setSpawnRateIncrement(spawnRateIncrement);
        waveSettingDto.setSpawnRateIncreaseInterval(spawnRateInterval);

        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Start: " + (waveSettingDto.getSpawnRateStart()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Increment: " + (waveSettingDto.getSpawnRateIncrement()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Increment Interval: " + (waveSettingDto.getSpawnRateIncreaseInterval()));
    }




}

