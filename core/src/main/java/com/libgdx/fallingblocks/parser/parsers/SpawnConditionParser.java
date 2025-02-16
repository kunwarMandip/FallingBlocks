package com.libgdx.fallingblocks.parser.parsers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.libgdx.fallingblocks.parser.dto.wave.EnemySpawnConditionDto;

import static com.libgdx.fallingblocks.GlobalVariables.isFileExist;

public class SpawnConditionParser {


    public EnemySpawnConditionDto parse(String spawnCondition){

        FileHandle fileHandle = Gdx.files.internal(filePath);
        isFileExist(fileHandle);

        return null;
    }
}
