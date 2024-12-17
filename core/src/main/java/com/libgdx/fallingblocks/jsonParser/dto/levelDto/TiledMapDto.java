package com.libgdx.fallingblocks.jsonParser.dto.levelDto;


import com.badlogic.gdx.utils.Array;

public class TiledMapDto {

    private final int waveNumber;
    private final String mapPath;
    private final Array<String> imagePath;

    public TiledMapDto(int waveNumber, String mapPath, Array<String> imagePath){
        this.waveNumber = waveNumber;
        this.mapPath=mapPath;
        this.imagePath=imagePath;
    }

    public int getWaveNumber() {
        return waveNumber;
    }

    public String getMapPath() {
        return mapPath;
    }

    public Array<String> getImagePath() {
        return imagePath;
    }
}
