package com.libgdx.fallingblocks.entity.enemy.compact;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawn.EnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.spawn.IEnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.spawn.SpawnRateManager;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;

public class EnemySpawnManager {

    private int enemyToSpawn;
    private IEnemyFactory enemyFactory;
    private EnemyDtoBuilder enemyDtoBuilder;
    private SpawnRateManager spawnRateManager;

    public EnemySpawnManager(EnemiesDto enemiesDto, Vector2 playerPosition) {
        this.enemyFactory= new EnemyFactory();
        this.enemyDtoBuilder= new EnemyDtoBuilder(enemiesDto, playerPosition);
        this.spawnRateManager = new SpawnRateManager();
    }

    public Array<Enemy> spawnEnemies(){
        Array<Enemy> enemies= new Array<Enemy>();
        for(int i=0; i<enemyToSpawn; i++){
            EnemyDto enemyDto= enemyDtoBuilder.getEnemyDto();
            enemies.add(enemyFactory.createEnemy(enemyDto));
        }

        enemyToSpawn=0;
        return enemies;
    }


}
