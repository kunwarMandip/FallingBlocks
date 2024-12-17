package com.libgdx.fallingblocks;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonValue;

public class GlobalVariables {
    public static final float PPM                   = 16;
    public static final float VIRTUAL_WIDTH         = 720;
    public static final float VIRTUAL_HEIGHT        = 1440;

    //CONTACT MANAGER --- SET WHICH EACH CAN COLLIDE WITH
    public static final short CATEGORY_PLAYER           = 0x0001;
    public static final short CATEGORY_ENEMY            = 0x0002;
    public static final short CATEGORY_WALL             = 0x0004;
    public static final short CATEGORY_ENEMY_SPAWN_AREA = 0x0008;
    public static final short CATEGORY_OUTER_BOUND      = 0x00016;


    public static int getRandomValue(int maxValue){
        return (int) (Math.random() * maxValue) + 1;
    }

    public static void isFileExist(FileHandle fileHandle){
        if(!fileHandle.exists()){
            throw new IllegalStateException(fileHandle.path() + " not Found");
        }
    }

    public static <T> void validateArrayContents(Array<T> objects){
        if (objects == null || objects.size == 0) {
            throw new IllegalStateException("Empty Array Objects: " + String.valueOf(objects));
        }

        for (T obj : objects) {
            if (obj == null) {
                throw new IllegalStateException("Null Objects: " + String.valueOf(objects));
            }
        }
    }

    public static void isNodeExists(JsonValue node){
        if(node== null){
            throw new RuntimeException("Json Parser: Node not found");
        }
    }

}
