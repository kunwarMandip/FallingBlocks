package com.libgdx.fallingblocks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.game.wave.WaveRunner;
import com.libgdx.fallingblocks.parser.GameDtoParser;
import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.WaveDto;

public class GameLoader{

    private final GameDto gameDto;
    private final SpriteBatch spriteBatch;

    private WaveDto waveDto;
    private WaveRunner waveRunner;
    public GameLoader(int levelToLoad, SpriteBatch spriteBatch){
        this.gameDto= new GameDtoParser().getGameDto(levelToLoad);
        this.spriteBatch= spriteBatch;
        this.waveDto= gameDto.getNextWave();
        setNewWave();
    }

    public void setNewWave(){
//        WaveDto waveDto= gameDto.getNextWave();
        waveRunner = new WaveRunner(waveDto, this, spriteBatch);
    }


    public WaveRunner getWaveLoader(){
        return waveRunner;
    }




}
