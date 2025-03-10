package com.libgdx.fallingblocks.parser.parsers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;

public class TiledMapParser {

    public Array<TiledMapDto> getTiledMapDto(String filePath){
        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        JsonReader jsonReader = new JsonReader();
        JsonValue root = jsonReader.parse(fileHandle);
        JsonValue wavesNode = root.get("waves");

        Array<TiledMapDto> tiledMapDtoArray= new Array<>();
        for(JsonValue wave: wavesNode){
            int waveNumber= wave.getInt("waveNumber", 0);
            String tiledMapPath= wave.getString("mapPath");
            tiledMapDtoArray.add(new TiledMapDto(waveNumber, tiledMapPath, null));
        }

        return tiledMapDtoArray;
    }



}
