package com.libgdx.fallingblocks.entity.enemy.spawn;

import com.libgdx.fallingblocks.controller.SpawnRateManager;


public class EnemySpawnManager {

    private IEnemyFactory enemyFactory;
    private SpawnRateManager spawnRateManager;

    public EnemySpawnManager() {
        this.enemyFactory= new EnemyFactory();
        this.spawnRateManager = new SpawnRateManager();
    }

    public void update(float delta){
        spawnRateManager.update(delta);
        int numEnemyToSpawn= spawnRateManager.getNumEnemyToSpawn();
        for(int i=0; i<numEnemyToSpawn; i++){
            spawnEnemy();
        }
    }


}
