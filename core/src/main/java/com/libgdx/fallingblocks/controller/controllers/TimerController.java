package com.libgdx.fallingblocks.controller.controllers;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.WaveSettingDto;

import static com.libgdx.fallingblocks.Logger.Tags.WAVE_TIMER_CONTROLLER;

/**
 * Manage all Timers and counters needed to control wave
 */
public class TimerController {

    private final WaveSettingDto waveSettingDto;


    private float waveDurationCounter, waveStartDelayCounter;

    private int totalEnemiesSpawned;
    private float spawnRate, spawnRateCounter;

    public TimerController(WaveSettingDto waveSettingDto){
        this.waveSettingDto = waveSettingDto;
        resetWaveTimers();
    }

    private void resetWaveTimers(){
        waveDurationCounter= 0f;
        waveStartDelayCounter= 0f;

        totalEnemiesSpawned=0;
        spawnRate= waveSettingDto.getSpawnRateStart();
        spawnRateCounter=0f;
    }

    public void update(float delta){

        if(!isWaveStartDelayCompleted(delta)){
            return;
        }

        if(isWaveDurationReached(delta)){
            return;
        }


        if(isMaxEnemySpawned()){
            Logger.log(WAVE_TIMER_CONTROLLER, "Max Enemy Spawned");
            return;
        }

        if(!isEnemySpawnRateReached(delta)){
            return;
        }

    }



    /**
     * Check if waveStartDelayCounter has reached the time needed to wait before wave starts
     *
     * @param delta Time elapsed since last frame
     * @return true if delay has been completed, else false
     */
    private boolean isWaveStartDelayCompleted(float delta){
        if(waveStartDelayCounter >= waveSettingDto.getWaveStartDelay()){
            return true;
        }

        waveStartDelayCounter+=delta;
        return false;
    }


    /**
     * Checks if the current wave's duration has been reached
     *
     * @param delta Time elapsed since the last frame.
     * @return true if the wave duration has been reached
     */
    private boolean isWaveDurationReached(float delta){
        if(waveDurationCounter >= waveSettingDto.getDuration()){
            Logger.log(WAVE_TIMER_CONTROLLER, "Duration Reached: " + waveDurationCounter);
            return true;
        }

        waveDurationCounter+=delta;
        return false;
    }


    private boolean isEnemySpawnRateReached(float delta){
        if(spawnRateCounter >= spawnRate){
            Logger.log(WAVE_TIMER_CONTROLLER, "spawn rate: " + spawnRateCounter + " :  "+ delta);
            spawnRateCounter=0f;
            return true;
        }

        spawnRateCounter+=delta;
        return false;
    }

    private boolean isMaxEnemySpawned(){
        return totalEnemiesSpawned >= waveSettingDto.getTotalEnemies();
    }

}
