package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawn.EnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.spawn.IEnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.spawn.SpawnRateManager;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;

import java.util.Map;

public class EnemySpawnManager {

    private int enemyToSpawn= 1;
    private final Array<Enemy> currentEnemies;

    private final EnemyDtoBuilder dtoBuilder;
    private final IEnemyFactory enemyFactory;
    private final SpawnRateManager spawnRateManager;

    public EnemySpawnManager(World world, EnemiesDto enemiesDto, Vector2 playerPosition, Array<Enemy> currentEnemies, Map<MovementDirection, Vector2> spawnAreas){
        this.currentEnemies=currentEnemies;
        this.enemyFactory= new EnemyFactory(world);
        this.spawnRateManager = new SpawnRateManager();
        this.dtoBuilder= new EnemyDtoBuilder(playerPosition, enemiesDto, spawnAreas);
    }

    public void spawnEnemies(){
        for(int i=0; i<enemyToSpawn; i++){
            EnemyDto enemyDto= dtoBuilder.getEnemyDto();
            currentEnemies.add(enemyFactory.createEnemy(enemyDto));
               }
        enemyToSpawn= 0;
    }

    public void setNumEnemyToSpawn(int i){
        this.enemyToSpawn=i;
    }
}
