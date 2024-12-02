package com.libgdx.fallingblocks.jsonExtractor;

import com.badlogic.gdx.utils.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class WaveExtractor {

    public void isWaveNodeExists(JsonValue wavesNode){
        if (wavesNode == null) {
            throw new RuntimeException("Json. Wave Node not Found");
        }
    }

    public void parseWaveSetting(JsonValue wave){
        int waveNumber = wave.getInt("waveNumber", -1);
        int totalEnemies= wave.getInt("totalEnemies", -1);
        float startTime = wave.getFloat("startTime", 0.0f);
        float duration = wave.getFloat("duration", 0.0f);

        System.out.print("Wave Number: " + waveNumber);
        System.out.print(" | Total Enemies: " + totalEnemies);
        System.out.print(" | Start Time: " + startTime);
        System.out.print(" | Duration: " + duration);
        System.out.println();
    }

    public void isSpawnSettingsExists(JsonValue wave){
        JsonValue spawnSettings = wave.get("spawnSettings");
        if (spawnSettings == null) {
            throw new RuntimeException("Json. Wave Settings not Found");
        }
    }

    public void parseWaveSpawnSettings(JsonValue spawnSettings){
        JsonValue spawnRateNode = spawnSettings.get("spawnRate");
        float spawnRateStart = spawnRateNode.getFloat("start", 0.0f);
        float spawnRateIncrement = spawnRateNode.getFloat("increment", 0.0f);
        float spawnRateInterval = spawnRateNode.getFloat("interval", 0.0f);

        System.out.print("Spawn Rate Start: " + spawnRateStart);
        System.out.print(" | Increment: " + spawnRateIncrement);
        System.out.print(" | Interval: " + spawnRateInterval);
        System.out.println();
    }


    public void parseWaveDirections(JsonValue spawnSettings) {
        JsonValue directionsNode = spawnSettings.get("directions");
        if (directionsNode == null) {
            throw new RuntimeException("Wave Direction not found");
        }

        Map<String, Float> directionsMap = new HashMap<>();
        for (JsonValue direction : directionsNode) {
            String directionName = direction.name();
            float weight = direction.asFloat();
            directionsMap.put(directionName, weight);
        }
        System.out.println(directionsMap);
    }

    public void parseEnemyDistribution(JsonValue spawnSettings){
        JsonValue enemyDistributionNode = spawnSettings.get("enemyDistribution");
        if (enemyDistributionNode == null) {
            throw new RuntimeException("Enemy Distribution not found");
        }

        Map<String, Integer> enemiesMap= new HashMap<>();
        for(JsonValue enemy: enemyDistributionNode){
            String enemyName= enemy.name;
            int percentage= enemy.asInt();
            enemiesMap.put(enemyName, percentage);
        }
        System.out.println(enemiesMap);
    }


}

