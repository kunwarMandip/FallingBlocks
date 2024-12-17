package com.libgdx.fallingblocks.controller.controllers;

import com.libgdx.fallingblocks.jsonParser.dto.levelDto.WaveSettingDto;

public class WaveController {

    private WaveSettingDto waveSettingDto;

    private float waveStartDelay;
    private boolean isWaveTimer, waveTimer;
    private float spawnRateStartCounter, spawnRateIncrementCounter, spawnRateIncreaseIntervalCounter;

    public WaveController(WaveSettingDto waveSettingDto){
        this.waveSettingDto= waveSettingDto;
    }

    public void update(float delta){

    }

    public void setWaveSettingDto(WaveSettingDto waveSettingDto){
        this.waveSettingDto=waveSettingDto;
    }

}
