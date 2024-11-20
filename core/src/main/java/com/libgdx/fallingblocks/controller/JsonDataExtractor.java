package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;

import java.util.Stack;


public class JsonDataExtractor {

    public GameLevelDto getGameLevelDto(int level){
        String enemyWaveFilePath="S";

        return new GameLevelDto.GameLevelDtoBuilder()
            .setEnemyWaveDtoArray(getEnemyWaveDto(level, enemyWaveFilePath))
            .build();
    }


    private Array<EnemyWaveDto> getEnemyWaveDto(int level, String filepath) {
        FileHandle fileHandle = Gdx.files.internal(filepath);

        //Check if file doesn't exist
        if (!fileHandle.exists()) {
            return null;
        }

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue levelNode = root.get(level);

        //Check if the top level for level exists
        if (levelNode == null) {
            return null;
        }

        JsonValue wavesNode = levelNode.get("waves");
        if (wavesNode == null) {
            return null;
        }


        //Each wave must have enemies inside
        Array<EnemyWaveDto> enemyWaveDtoArray= new Array<>();
        for (JsonValue wave : wavesNode) {
            int waveNumber = wave.getInt("waveNumber", -1);
            float startDelay = wave.getFloat("startDelay", 0.0f);
            float duration = wave.getFloat("duration", 0.0f);
            String spawnPattern = wave.getString("spawnPattern", "Unknown");

            JsonValue enemiesNode = wave.get("enemies");

            if (enemiesNode == null) {
                return null;
            }

            Stack<EnemyDto> enemyDtoStack = new Stack<>();
            for (JsonValue enemy : enemiesNode) {
                String enemyType = enemy.getString("enemyType", "Unknown");
                int amount = enemy.getInt("amount", 0);
                float spawnInterval = enemy.getFloat("spawnInterval", 0.0f);
                String behavior = enemy.getString("behavior", "Unknown");
                int health = enemy.getInt("health", 0);
                float speed = enemy.getFloat("speed", 0.0f);
                int attackPower = enemy.getInt("attackPower", 0);
                int rewardPoints = enemy.getInt("rewardPoints", 0);

                enemyDtoStack.add(new EnemyDto.EnemyDtoBuilder()
                    .setType(enemyType)
                    .setBehavior(behavior)
                    .setSpawnTime(spawnInterval)
                    .setSpeed(new Vector2(0, speed))
                    .build());
            }

            enemyWaveDtoArray.add(new EnemyWaveDto.EnemyWaveDtoBuilder()
                .setWaveTimed(false)
                .setWaveStartDelay(startDelay)
                .setWaveDuration(duration)
                .setEnemyWave(enemyDtoStack)
                .build(

                ));

        }
        return enemyWaveDtoArray;

    }



}
