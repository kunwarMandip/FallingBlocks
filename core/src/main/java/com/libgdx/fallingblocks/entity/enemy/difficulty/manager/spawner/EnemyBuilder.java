package com.libgdx.fallingblocks.entity.enemy.difficulty.manager.spawner;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyDtoBuilder;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemyFactory;
import com.libgdx.fallingblocks.entity.enemy.spawner.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.map.objects.spawnArea.MovementDirection;

import java.util.Map;

public class EnemyBuilder {

    private final World world;

    private final EnemyFactory enemyFactory;
    private final EnemyDtoBuilder enemyDtoBuilder;
    private final EnemySpawnManager enemySpawnManager;

    private Array<EnemyDto> enemiesToSpawn= new Array<>();

    public EnemyBuilder(World world, EnemiesDto enemiesDto, Map<MovementDirection, Vector2> spawnAreas){
        this.world= world;

        this.enemyFactory= new EnemyFactory(world);
        this.enemyDtoBuilder= new EnemyDtoBuilder(enemiesDto, spawnAreas);
        this.enemySpawnManager= new EnemySpawnManager();

    }


    public Enemy getEnemy(){
        return null;
    }

}
