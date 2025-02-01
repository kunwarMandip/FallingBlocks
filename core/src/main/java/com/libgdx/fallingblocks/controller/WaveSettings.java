package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnRateConditions;
import com.libgdx.fallingblocks.game.score.GameScore;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;

public class WaveSettings {

    private final GameScore gameScore;
    private final SpawnRateConditions spawnRateConditions;

    public WaveSettings(WaveSettingDto waveSettingDto){
        this.gameScore              = new GameScore();
//        this.spawnRateConditions    = new SpawnRateConditions(waveSettingDto.spawnCondition);
        this.spawnRateConditions    = new SpawnRateConditions();
    }

    public GameScore getGameScore(){
        return gameScore;
    }

    public SpawnRateConditions getSpawnRateConditions(){
        return spawnRateConditions;
    }

}
