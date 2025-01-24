package com.libgdx.fallingblocks.game.spawn;

public class SpawnController {

    private final EnemySpawn enemySpawn;
    private final EnemySpawnSettings enemySpawnSettings;

    public SpawnController(){
        this.enemySpawn = new EnemySpawn();
        this.enemySpawnSettings= new EnemySpawnSettings();
    }
}
