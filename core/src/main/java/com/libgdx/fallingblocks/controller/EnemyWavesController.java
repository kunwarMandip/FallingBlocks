package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.dto.EnemyDto;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.entity.behaviour.strategies.DashMovement;
import com.libgdx.fallingblocks.entity.behaviour.strategies.MeleeAttack;
import com.libgdx.fallingblocks.entity.behaviour.strategies.RangeAttack;
import com.libgdx.fallingblocks.entity.behaviour.strategies.SlowMovement;
import com.libgdx.fallingblocks.entity.enemy.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.NormalEnemy;



public class EnemyWavesController {

    private final World world;
    private final EnemyWaveDto enemyWaveDto;
    private final Array<EnemyWaveDto> enemyWaveDtoArray;
    private final Array<Enemy> activeEnemies= new Array<>();
    private float waveDurationCounter, waveStartDelayCounter, enemySpawnIntervalCounter;


    public EnemyWavesController(World world, Array<EnemyWaveDto> enemyWaveDtoArray){
        this.world=world;
        this.enemyWaveDtoArray=enemyWaveDtoArray;
        this.enemyWaveDto=enemyWaveDtoArray.pop();
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

        isEnemySpawnAble(delta);

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
            changeWave();
            return true;
        }

        waveDurationCounter+=delta;
        return false;
    }

    private void changeWave(){

    }

    /**
     * Checks if the next enemy is ready to be spawned based on the spawn interval.
     * If ready, adds the next Enemy to the ArrayList
     *
     * @param delta Time elapsed since the last frame.
     */
    private void isEnemySpawnAble(float delta){
        if(enemySpawnIntervalCounter >= enemyWaveDto.getEnemySpawnInterval()){
            spawnEnemy();
            enemySpawnIntervalCounter= 0f;
        }

        enemySpawnIntervalCounter +=delta;
    }



    private void spawnEnemy() {
        EnemyDto enemyDto = enemyWaveDto.getEnemy();
        Vector2 spawnPosition = new Vector2(0, 0);
        Vector2 speed = new Vector2(0, 0);
        String type = enemyDto.getType();

        switch (type) {
            case "Normal":
                new NormalEnemy(world,
                    enemyDto.health,
                    spawnPosition,
                    speed,
                    enemyDto.bodyDimension,
                    new MeleeAttack(),
                    new DashMovement());
                break;

            case "BossEnemy":
                new BossEnemy(world,
                    enemyDto.health,
                    spawnPosition,
                    speed,
                    enemyDto.bodyDimension,
                    new RangeAttack(),
                    new DashMovement());
                break;

            case "QuickEnemy":
                new NormalEnemy(world,
                    enemyDto.health,
                    spawnPosition,
                    speed,
                    enemyDto.bodyDimension,
                    new RangeAttack(),
                    new SlowMovement());
                break;

            default:
                throw new RuntimeException("Unidentified Enemy Type on EnemyWavesController.build");
        }

    }
}
