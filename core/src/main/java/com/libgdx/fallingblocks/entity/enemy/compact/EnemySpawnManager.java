package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.services.SpawnRateController;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.services.EnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.services.IEnemyFactory;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;

import java.util.Map;

import static com.libgdx.fallingblocks.Logger.Tags.SPAWN_ENEMY;

public class EnemySpawnManager {

    private final Array<Enemy> currentEnemies;

    private final EnemyDtoBuilder dtoBuilder;
    private final IEnemyFactory enemyFactory;
    private final SpawnRateController spawnRateController;

    public EnemySpawnManager(World world, Vector2 playerPosition, EnemiesSpawnInfoDto enemiesSpawnInfoDto, Array<Enemy> currentEnemies, Map<MovementDirection, Vector2> spawnAreas){
        this.currentEnemies=currentEnemies;
        this.enemyFactory= new EnemyFactory(world);
        this.spawnRateController= new SpawnRateController();
        this.dtoBuilder= new EnemyDtoBuilder(playerPosition, enemiesSpawnInfoDto, spawnAreas);
    }

    public void spawnEnemies(){
        int numEnemyToSpawn= spawnRateController.getNumEnemyToSpawn();

        for(int i=0; i<numEnemyToSpawn; i++){
            Logger.log(SPAWN_ENEMY, "Spawning Enemy");
            EnemyDto enemyDto= dtoBuilder.getEnemyDto();
            currentEnemies.add(enemyFactory.createEnemy(enemyDto));
        }
        spawnRateController.resetNumEnemyToSpawn();
    }


    public SpawnRateController setSpawnConditions(){
        return spawnRateController;
    }

}
