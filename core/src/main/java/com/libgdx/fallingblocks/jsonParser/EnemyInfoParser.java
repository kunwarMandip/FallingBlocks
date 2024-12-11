package com.libgdx.fallingblocks.jsonParser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;

import java.util.HashMap;
import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;

public class EnemyInfoParser {

    public Array<EnemyInfoDto> getEnemyInfoDto(String filePath){
        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");

        Array<EnemyInfoDto> enemyInfoDtoArray= new Array<>();
        for (JsonValue wave : wavesNode) {
            Map<String, Integer> spawnDirection= parseWaveDistribution(wave);
            Map<String, Integer> enemiesDistribution= parseEnemyDistribution(wave);
            enemyInfoDtoArray.add(new EnemyInfoDto(spawnDirection, enemiesDistribution));
        }
        return enemyInfoDtoArray;
    }


    private Map<String, Integer> parseEnemyDistribution(JsonValue wave){
        JsonValue enemyDistributionNode = wave.get("enemyDistribution");
        if (enemyDistributionNode == null) {
            throw new RuntimeException("Enemy Distribution not found");
        }

        Map<String, Integer> enemiesDistribution= new HashMap<>();
        for(JsonValue enemy: enemyDistributionNode){
            String enemyName= enemy.name;
            int percentage= enemy.asInt();
            enemiesDistribution.put(enemyName, percentage);
        }
        Logger.log(Logger.Tags.ENEMY_INFO_PARSER, "EnemyDistributions: " + enemiesDistribution);
        return enemiesDistribution;

    }

    private Map<String, Integer> parseWaveDistribution(JsonValue wave) {
        JsonValue directionsNode = wave.get("directions");
        if (directionsNode == null) {
            throw new RuntimeException("Wave Direction not found");
        }

        Map<String, Integer> enemySpawnDirections = new HashMap<>();
        for (JsonValue direction : directionsNode) {
            String directionName = direction.name();
            int weight = direction.asInt();
            enemySpawnDirections.put(directionName, weight);
        }
        Logger.log(Logger.Tags.ENEMY_INFO_PARSER, "WaveDistributions: " + enemySpawnDirections);
        return enemySpawnDirections;
    }

}
