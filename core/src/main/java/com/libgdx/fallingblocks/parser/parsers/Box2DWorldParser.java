package com.libgdx.fallingblocks.parser.parsers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;

public class Box2DWorldParser {

    public Array<WorldDto> getWorldDto(String filePath){
        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");

        Array<WorldDto> worldDtoArray= new Array<>();
        for(JsonValue wave: wavesNode){

            int waveNumber= wave.getInt("waveNumber", 0);
            boolean sleep=wave.getBoolean("sleep");
            JsonValue gravityNode= wave.get("gravity");
            float gravityX= gravityNode.getFloat(0);
            float gravityY= gravityNode.getFloat(1);
            Vector2 gravity= new Vector2(gravityX, gravityY);

            worldDtoArray.add(new WorldDto(waveNumber, sleep, gravity));
        }

        return worldDtoArray;
    }
}
