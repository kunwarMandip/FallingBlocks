package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.entity.player.PlayerTypes;
import com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor;

public class LevelManager {

    private final GameLevelDto gameLevelDto;
    private EnemyWaveDto currentEnemyWaveDto;

    private final MapController mapController;
    private final WaveController waveController;
    private final PlayerController playerController;
    private final SpawnController spawnController;

    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
        gameLevelDto= new JsonDataExtractor().getGameLevelDto(levelToLoad);
        currentEnemyWaveDto= gameLevelDto.getWaveDtoArray().get(0);

        mapController= new MapController(world, tiledMap);
        playerController= new PlayerController(world, PlayerTypes.NORMAL);
        spawnController = new SpawnController( world, mapController.getEnemySpawnAreas(), currentEnemyWaveDto.getEnemyInfoDto());
        waveController= new WaveController(currentEnemyWaveDto, spawnController);
    }

    private void update(){
        currentEnemyWaveDto=gameLevelDto.getWaveDtoArray().pop();
    }

    public void update(float delta) {
        waveController.update(delta);
        mapController.update(delta);
        spawnController.update(delta, new Vector2(0, 0));
        playerController.update(delta);
    }

    public void draw(SpriteBatch spriteBatch){
        playerController.draw(spriteBatch);
        spawnController.draw(spriteBatch);
    }


}
