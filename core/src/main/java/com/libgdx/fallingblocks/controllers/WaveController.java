package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.Gdx;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.controllers.listeners.EnemySpawnListener;


public class WaveController {

    private final EnemyWaveDto enemyWaveDto;
    private final EnemySpawnListener enemySpawnListener;

    private int totalEnemiesSpawned;
    private float waveDurationCounter, waveStartDelayCounter, enemySpawnRateCounter;

    public WaveController(EnemyWaveDto enemyWaveDto, EnemySpawnListener enemySpawnListener){
        this.enemyWaveDto=enemyWaveDto;
        this.enemySpawnListener=enemySpawnListener;

        resetWaveTimers();
    }

    public void update(float delta){

        if(!isWaveStartDelayCompleted(delta)){
            return;
        }

        if(isWaveDurationReached(delta)){
            return;
        }

        if(isEnemySpawnAble(delta)){
            enemySpawnListener.spawnEnemy(1);
        }

    }



    private void resetWaveTimers(){
        waveDurationCounter= 0f;
        waveStartDelayCounter= 0f;
        enemySpawnRateCounter = 0f;
    }


    /**
     * Check if waveStartDelayCounter has reached the time needed to wait before wave starts
     *
     * @param delta Time elapsed since last frame
     * @return true if delay has been completed, else false
     */
    private boolean isWaveStartDelayCompleted(float delta){
        if(waveStartDelayCounter >= enemyWaveDto.getWaveStartDelay()){
//            Gdx.app.log("Wave Controller", " WaveStartDelayCounter: Finished");
            return true;
        }

//        Gdx.app.log("Wave Controller", " WaveStartDelayCounter: " + (waveStartDelayCounter));
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
//            Gdx.app.log("Wave Controller", " WaveDurationCounter: Finished");
            return true;
        }

//        Gdx.app.log("Wave Controller", " WaveDurationCounter: Finished" + + (waveDurationCounter));
        waveDurationCounter+=delta;
        return false;
    }


    /**
     * Checks if it's time to spawnNext Enemy, and then checks if there is a next Enemy
     *
     * @param delta Time elapsed since the last frame.
     */
    private boolean isEnemySpawnAble(float delta){
        if(enemySpawnRateCounter < enemyWaveDto.getSpawnRateStart()){
            enemySpawnRateCounter +=delta;
            return false;
        }

        if(totalEnemiesSpawned >= enemyWaveDto.getTotalEnemies()){
            return false;
        }

        enemySpawnRateCounter = 0f;
        return true;
    }

}
