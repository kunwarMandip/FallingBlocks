package com.libgdx.fallingblocks.jsonExtractor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.entity.enemy.EnemyType;

import java.io.FileNotFoundException;

public class JsonDataExtractor {

    private WaveExtractor waveExtractor;

    public GameLevelDto getGameLevelDto(int level){
        waveExtractor= new WaveExtractor();
        String waveFilePath= "jsons/enemyWaves/" + level +".json";
        System.out.println(waveFilePath);
        getEnemyWavesDto(waveFilePath);

        throw new RuntimeException("Ends");
//        return new GameLevelDto.GameLevelDtoBuilder()
//            .setEnemyWaveDtoArray(getEnemyWaveDto(level, enemyWavesFilePath))
//            .build();

    }

    private void checkFile(String filepath) throws FileNotFoundException {
        FileHandle fileHandle= Gdx.files.internal(filepath);
        if(!fileHandle.exists()){
           return;
        }
        throw new FileNotFoundException( "File not Found: " + filepath);
    }

    private Array<EnemyWaveDto> getEnemyWavesDto(int level, String filepath) {
        FileHandle fileHandle = Gdx.files.internal(filepath);

        //Check if file doesn't exist
        if (!fileHandle.exists()) {
            System.out.println("File Not found");
            return null;
        }

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue levelNode = root.get(Integer.toString(level));

        //Check if the top level for level exists
        if (levelNode == null) {
            System.out.println("Level not found");
            return null;
        }

        JsonValue wavesNode = levelNode.get("waves");
        if (wavesNode == null) {
            System.out.println("Waves Not found");
            return null;
        }


        //Each wave must have enemies inside
        Array<EnemyWaveDto> enemyWaveDtoArray= new Array<>();
        for (JsonValue wave : wavesNode) {
            int waveNumber = wave.getInt("waveNumber", -1);
            float startDelay = wave.getFloat("startDelay", 0.0f);
            float duration = wave.getFloat("duration", 0.0f);
            String spawnPattern = wave.getString("spawnPattern", "Unknown");

            System.out.print("Wave: " + waveNumber);
            System.out.print(" | ");
            System.out.print("Start Delay: " + startDelay);
            System.out.print(" | ");
            System.out.print("Duration: " + duration);
            System.out.print(" | ");
            System.out.print("Spawn Pattern: " + spawnPattern);
            System.out.println();

            JsonValue enemiesNode = wave.get("enemies");
            if (enemiesNode == null) {
                System.out.println("Level not found");
                return null;
            }

            Array<EnemyDto> enemyDtoArray = new Array<>();
            for (JsonValue enemy : enemiesNode) {
                int amount = enemy.getInt("amount", 0);
                int health = enemy.getInt("health", 0);
                int attackPower = enemy.getInt("attackPower", 0);
                int rewardPoints = enemy.getInt("rewardPoints", 0);
                float speed = enemy.getFloat("speed", 0.0f);
                float spawnInterval = enemy.getFloat("spawnInterval", 0.0f);
                String behavior = enemy.getString("behavior", "Unknown");
                String enemyType = enemy.getString("enemyType", "Unknown");

                System.out.print("Enemy Type: " + enemyType + " | ");
                System.out.print("Amount: " + amount + " | ");
                System.out.print("Spawn Interval: " + spawnInterval + " | ");
                System.out.print("Behavior: " + behavior + " | ");
                System.out.print("Health: " + health + " | ");
                System.out.print("Speed: " + speed + " | ");
                System.out.print("Attack Power: " + attackPower + " | ");
                System.out.print("Reward Points: " + rewardPoints + " | ");
                System.out.println();

                enemyDtoArray.add(new EnemyDto.EnemyDtoBuilder()
                    .setType(EnemyType.valueOf(enemyType))
//                    .setSpawnTime(spawnInterval)
//                    .setSpeed(new Vector2(0, speed))
                    .build());

                System.out.println("Adding new Enemy");
            }
            System.out.println("New WAVE");
            enemyWaveDtoArray.add(new EnemyWaveDto.EnemyWaveDtoBuilder()
                .setWaveTimed(false)
                .setWaveStartDelay(startDelay)
                .setWaveDuration(duration)
                .setEnemyWave(enemyDtoArray)
                .build()
            );

        }
        return enemyWaveDtoArray;
    }

    private void isFileExist(FileHandle fileHandle){
        if(!fileHandle.exists()){
           throw new RuntimeException(fileHandle.path() + " not Found");
        }
    }

    private Array<EnemyWaveDto> getEnemyWavesDto(String filepath) {
        FileHandle fileHandle = Gdx.files.internal(filepath);

        // Check if file doesn't exist
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");
        waveExtractor.isWaveNodeExists(root);

        Array<EnemyWaveDto> enemyWaveDtoArray = new Array<>();
        for (JsonValue wave : wavesNode) {
            waveExtractor.parseWaveSetting(wave);
            waveExtractor.isSpawnSettingsExists(wave);
            JsonValue spawnSettings = wave.get("spawnSettings");
            waveExtractor.parseWaveSpawnSettings(spawnSettings);
            waveExtractor.parseWaveDirections(spawnSettings);
            waveExtractor.parseEnemyDistribution(spawnSettings);

            // Create and add EnemyWaveDto to the array
            EnemyWaveDto waveDto = new EnemyWaveDto.EnemyWaveDtoBuilder()
//                .setWaveNumber(waveNumber)
//                .setStartTime(startTime)
//                .setDuration(duration)
                // Set other properties as needed
                .build();

            enemyWaveDtoArray.add(waveDto);
        }
        return enemyWaveDtoArray;
    }


}
