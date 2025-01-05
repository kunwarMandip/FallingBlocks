package com.libgdx.fallingblocks.controller.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.wave.WaveLoader;
import com.libgdx.fallingblocks.parser.GameDtoParser;
import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.WaveDto;

public class GameLoader {

    private final GameDto gameDto;
    private final SpriteBatch spriteBatch;

    private WaveDto waveDto;
    private WaveLoader waveLoader;
    public GameLoader(int levelToLoad, SpriteBatch spriteBatch){
        this.gameDto= new GameDtoParser().getGameDto(levelToLoad);
        this.spriteBatch= spriteBatch;
        this.waveDto= gameDto.getNextWave();
        setNewWave();
    }

    public void setNewWave(){
//        WaveDto waveDto= gameDto.getNextWave();
        waveLoader= new WaveLoader(waveDto, spriteBatch, this);
    }


    public WaveLoader getWaveLoader(){
        return waveLoader;
    }




}
