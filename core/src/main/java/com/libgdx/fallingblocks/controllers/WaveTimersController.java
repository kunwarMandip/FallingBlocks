package com.libgdx.fallingblocks.controllers;

import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.controllers.listeners.EnemySpawnListener;

import static com.libgdx.fallingblocks.Logger.Tags.WAVE_TIMER_CONTROLLER;

/**
 * Manage all Timers and counters needed to control wave
 */
public class WaveTimersController {

    private final EnemyWaveDto enemyWaveDto;
    private final EnemySpawnListener enemySpawnListener;

    private float waveDurationCounter, waveStartDelayCounter;

    private int totalEnemiesSpawned;
    private float spawnRate, spawnRateCounter;

    public WaveTimersController(EnemyWaveDto enemyWaveDto, EnemySpawnListener enemySpawnListener){
        this.enemyWaveDto=enemyWaveDto;
        this.enemySpawnListener=enemySpawnListener;
        resetWaveTimers();

    }

    private void resetWaveTimers(){
        waveDurationCounter= 0f;
        waveStartDelayCounter= 0f;

        totalEnemiesSpawned=0;
        spawnRate=enemyWaveDto.getSpawnRateStart();
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

        enemySpawnListener.setNumEnemyToSpawn(1);
        totalEnemiesSpawned++;
    }



    /**
     * Check if waveStartDelayCounter has reached the time needed to wait before wave starts
     *
     * @param delta Time elapsed since last frame
     * @return true if delay has been completed, else false
     */
    private boolean isWaveStartDelayCompleted(float delta){
        if(waveStartDelayCounter >= enemyWaveDto.getWaveStartDelay()){
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
        if(waveDurationCounter >= enemyWaveDto.getDuration()){
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
        return totalEnemiesSpawned >= enemyWaveDto.getTotalEnemies();
    }

}
