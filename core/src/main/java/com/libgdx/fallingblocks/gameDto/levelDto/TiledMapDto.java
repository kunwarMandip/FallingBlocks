package com.libgdx.fallingblocks.gameDto.levelDto;


import com.badlogic.gdx.utils.Array;

public class TiledMapDto {

    private final String mapPath;
    private final Array<String> imagePath;

    public TiledMapDto(String mapPath, Array<String> imagePath){
        this.mapPath=mapPath;
        this.imagePath=imagePath;
    }

    public String getMapPath() {
        return mapPath;
    }

    public Array<String> getImagePath() {
        return imagePath;
    }
}
