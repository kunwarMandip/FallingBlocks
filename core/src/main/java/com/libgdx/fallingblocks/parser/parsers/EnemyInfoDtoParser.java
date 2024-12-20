package com.libgdx.fallingblocks.parser.parsers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;

import java.util.HashMap;
import java.util.Map;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;
import static com.libgdx.fallingblocks.GlobalVariables.isNodeExists;

public class EnemyInfoDtoParser {

    public Array<EnemiesDto> getEnemyInfoDto(String filePath){
        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");

        Array<EnemiesDto> enemyInfoDtoArray= new Array<>();
        for (JsonValue wave : wavesNode) {
            Map<String, Integer> spawnDirection= parseNodeToMap(wave.get("directions"));
            Map<String, Integer> enemiesDistribution= parseNodeToMap(wave.get("enemyDistribution"));
            enemyInfoDtoArray.add(new EnemiesDto(spawnDirection, enemiesDistribution));
        }
        return enemyInfoDtoArray;
    }

    private Map<String, Integer> parseNodeToMap(JsonValue targetNode) {
        isNodeExists(targetNode);

        Map<String, Integer> result = new HashMap<>();
        for (JsonValue item : targetNode) {
            String key = item.name();
            int value = item.asInt();
            result.put(key, value);
        }

        Logger.log(Logger.Tags.ENEMY_INFO_PARSER, result.toString());
        return result;
    }

}
