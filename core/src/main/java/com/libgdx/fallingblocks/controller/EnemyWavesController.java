package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

import java.util.ArrayList;

public class EnemyWavesController {

    private final LevelManager levelManager;
    private final EnemyWaveDto enemyWaveDto;
    private final ArrayList<Enemy> activeEnemies = new ArrayList<>();
    private float waveDurationCounter, waveStartDelayCounter, enemySpawnIntervalCounter;

    public EnemyWavesController(LevelManager levelManager, EnemyWaveDto enemyWaveDto){
        this.levelManager=levelManager;
        this.enemyWaveDto=enemyWaveDto;
        this.waveDurationCounter=0f;
        this.waveStartDelayCounter=0f;
        this.enemySpawnIntervalCounter=0f;
    }


    public void update(float delta){

        if(!isWaveStartDelayCompleted(delta)){
            return;
        }

        if(isWaveDurationReached(delta)){
            return;
        }

//        if(isEnemySpawnAble(delta)){
//        }

        for(Enemy enemy: activeEnemies){
            enemy.update(delta);
        }
    }


    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: activeEnemies){
            enemy.draw(spriteBatch);
        }
    }


    /**
     * Checks if the initial delay before starting a new wave is completed.
     * If not completed, increments the waveStartDelayCounter
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
     * Checks if the current wave's duration has been reached.
     * If not completed, increments the waveDurationCounter
     *
     * @param delta Time elapsed since the last frame.
     * @return true if the wave duration has been reached, false otherwise.
     */
    private boolean isWaveDurationReached(float delta){
        if(waveDurationCounter >= enemyWaveDto.getWaveDuration()){
            levelManager.setWaveDurationComplete();
            return true;
        }

        waveDurationCounter+=delta;
        return false;
    }

    /**
     * Checks if the next enemy is ready to be spawned based on the spawn interval.
     * If ready, adds the next Enemy to the ArrayList
     *
     * @param delta Time elapsed since the last frame.
     * @return true if the spawn interval has been reached, false otherwise.
     */
    private boolean isEnemySpawnAble(float delta){
        if(enemySpawnIntervalCounter >= enemyWaveDto.getEnemySpawnInterval()){
            spawnEnemy();
            enemySpawnIntervalCounter= 0f;
            return true;
        }

        enemySpawnIntervalCounter +=delta;
        return false;
    }

    private void spawnEnemy(){
        EnemyDto enemyDto= enemyWaveDto.getEnemy();

    }


}
