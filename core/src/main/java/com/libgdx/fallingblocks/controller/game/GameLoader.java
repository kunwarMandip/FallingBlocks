package com.libgdx.fallingblocks.controller.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.wave.WaveLoader;
import com.libgdx.fallingblocks.parser.GameDtoParser;
import com.libgdx.fallingblocks.parser.dto.GameDto;
import com.libgdx.fallingblocks.parser.dto.WaveDto;

public class GameLoader {

    private WaveLoader waveLoader;
    private final GameDto gameDto;

    private final GameStats gameStats;

    public GameLoader(int getLastWaveNumber, SpriteBatch spriteBatch){
        this.gameDto= new GameDtoParser().getGameDto(getLastWaveNumber);

        WaveDto waveDto= gameDto.getNextWave();
        this.gameStats= new GameStats(0, waveDto.getWaveNumber());

        waveLoader = new WaveLoader(waveDto, spriteBatch);
    }

    public void update(float delta){
        waveLoader.update(delta);
    }

    public void render(float delta){
        waveLoader.draw(delta);
    }

    public void resize(int width, int height){
        waveLoader.resize(width, height);
    }

}
