package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.controllers.listeners.EnemySpawnListener;
import com.libgdx.fallingblocks.entity.enemy.EnemyDtoCreator;

import java.util.Map;

public class SpawnController implements EnemySpawnListener {

    private EnemyDtoCreator enemyDtoCreator;
    private Map<String, Vector2> spawnAreas;

    public SpawnController(World world, EnemyInfoDto enemyInfoDto,  Map<String, Vector2> spawnAreas){
        this.spawnAreas=spawnAreas;
        this.enemyDtoCreator= new EnemyDtoCreator(enemyInfoDto);
    }




    public void spawnEnemy(Vector2 playerLocation)
    {
    }


    @Override
    public void setNumEnemyToSpawn(int numEnemyToSpawn) {
    }

}
