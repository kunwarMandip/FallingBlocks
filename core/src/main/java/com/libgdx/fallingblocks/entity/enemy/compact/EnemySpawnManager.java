package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionListener;
import com.libgdx.fallingblocks.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyFactory;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;

public class EnemySpawnManager {

    private final EnemyDtoBuilder dtoBuilder;
    private final EnemyFactory enemyFactory;
    private final SpawnConditionListener spawnConditionListener;

    public EnemySpawnManager(World world, Vector2 playerPosition, SpawnConditionListener spawnConditionListener,  EnemiesSpawnInfoDto enemiesSpawnInfoDto, Map<MovementDirection, Vector2> spawnAreas){
        this.enemyFactory= new EnemyFactory(world);
        this.spawnConditionListener= spawnConditionListener;
        this.dtoBuilder= new EnemyDtoBuilder(playerPosition, enemiesSpawnInfoDto, spawnAreas);
    }

    public void spawnEnemies(Array<Enemy> currentEnemies){
        int numToSpawn= spawnConditionListener.getNumEnemiesToSpawn();
        if(numToSpawn<= 0){
            return;
        }

        for(int i=0; i<numToSpawn; i++){
            currentEnemies.add(enemyFactory.createEnemy(dtoBuilder.getEnemyDto()));
        }
    }

}
