package com.libgdx.fallingblocks.jsonExtractor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.Logger;

import java.util.HashMap;
import java.util.Map;

import static com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor.isFileExist;

public class WaveExtractor {


    public Array<EnemyWaveDto> getEnemyWavesDto(String filepath) {
        Array<EnemyWaveDto> enemyWaveDtoArray = new Array<>();
        FileHandle fileHandle = Gdx.files.internal(filepath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);

        JsonValue wavesNode = root.get("waves");
        isWaveNodeExists(root);
        for (JsonValue wave : wavesNode) {
            EnemyWaveDto enemyWaveDto= new EnemyWaveDto();
            isSpawnSettingsExists(wave);
            JsonValue spawnSettings = wave.get("spawnSettings");

            parseWaveSetting(wave, enemyWaveDto);
            parseWaveSpawnSettings(spawnSettings, enemyWaveDto);
            parseWaveDirections(spawnSettings, enemyWaveDto);
            parseEnemyDistribution(spawnSettings, enemyWaveDto);
            enemyWaveDtoArray.add(enemyWaveDto);
        }
        return enemyWaveDtoArray;
    }


    public void isWaveNodeExists(JsonValue wavesNode){
        if (wavesNode == null) {
            throw new RuntimeException("Json. Wave Node not Found");
        }
    }

    public void parseWaveSetting(JsonValue wave, EnemyWaveDto enemyWaveDto){
        int totalEnemies= wave.getInt("totalEnemies", -1);
        float startDelay = wave.getFloat("startDelay", 0.0f);
        float duration = wave.getFloat("duration", 0.0f);

        enemyWaveDto.setTotalEnemies(totalEnemies);
        enemyWaveDto.setWaveStartDelay(startDelay);
        enemyWaveDto.setDuration(duration);

        Logger.log(Logger.Tags.WAVE_PARSER, "Total Enemies: " + (enemyWaveDto.getTotalEnemies()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Start Delay: " + (enemyWaveDto.getWaveStartDelay()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Duration: " + (enemyWaveDto.getDuration()));
    }

    public void isSpawnSettingsExists(JsonValue wave){
        JsonValue spawnSettings = wave.get("spawnSettings");
        if (spawnSettings == null) {
            throw new RuntimeException("Json. Wave Settings not Found");
        }
    }

    public void parseWaveSpawnSettings(JsonValue spawnSettings, EnemyWaveDto enemyWaveDto){
        JsonValue spawnRateNode = spawnSettings.get("spawnRate");
        float spawnRateStart = spawnRateNode.getFloat("start", 0.0f);
        float spawnRateIncrement = spawnRateNode.getFloat("increment", 0.0f);
        float spawnRateInterval = spawnRateNode.getFloat("interval", 0.0f);

        enemyWaveDto.setSpawnRateStart(spawnRateStart);
        enemyWaveDto.setSpawnRateIncrement(spawnRateIncrement);
        enemyWaveDto.setSpawnRateIncreaseInterval(spawnRateInterval);

        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Start: " + (enemyWaveDto.getSpawnRateStart()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Increment: " + (enemyWaveDto.getSpawnRateIncrement()));
        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Rate Increment Interval: " + (enemyWaveDto.getSpawnRateIncreaseInterval()));
    }


    public void parseWaveDirections(JsonValue spawnSettings, EnemyWaveDto enemyWaveDto) {
        JsonValue directionsNode = spawnSettings.get("directions");
        if (directionsNode == null) {
            throw new RuntimeException("Wave Direction not found");
        }

        Map<String, Integer> enemySpawnDirections = new HashMap<>();
        for (JsonValue direction : directionsNode) {
            String directionName = direction.name();
            int weight = direction.asInt();
            enemySpawnDirections.put(directionName, weight);
        }

        enemyWaveDto.getEnemyInfoDto().setSpawnDirections(enemySpawnDirections);
        Logger.log(Logger.Tags.WAVE_PARSER, "Spawn Directions : " + (enemyWaveDto.getEnemyInfoDto().getSpawnDirections()));
    }

    public void parseEnemyDistribution(JsonValue spawnSettings, EnemyWaveDto enemyWaveDto){
        JsonValue enemyDistributionNode = spawnSettings.get("enemyDistribution");
        if (enemyDistributionNode == null) {
            throw new RuntimeException("Enemy Distribution not found");
        }

        Map<String, Integer> enemiesDistribution= new HashMap<>();
        for(JsonValue enemy: enemyDistributionNode){
            String enemyName= enemy.name;
            int percentage= enemy.asInt();
            enemiesDistribution.put(enemyName, percentage);
        }
        enemyWaveDto.getEnemyInfoDto().setEnemyDistributions(enemiesDistribution);
        Logger.log(Logger.Tags.WAVE_PARSER, "Enemy Distribution : " + (enemyWaveDto.getEnemyInfoDto().getEnemyDistributions()));
    }


}

