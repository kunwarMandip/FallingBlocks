package com.libgdx.fallingblocks.controllers;

import com.libgdx.fallingblocks.dto.EnemyWaveDto;
import com.libgdx.fallingblocks.dto.GameLevelDto;
import com.libgdx.fallingblocks.jsonExtractor.JsonDataExtractor;

public class LevelManager {

    private EnemyWaveDto currentEnemyWaveDto;


    private WaveTimersController waveTimersController;
    private  SpawnController spawnController;

    private EnemyDtoCreator enemyDtoCreator;

//    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
//        gameLevelDto= new JsonDataExtractor().getGameLevelDto(levelToLoad);
//        currentEnemyWaveDto= gameLevelDto.getWaveDtoArray().get(0);
//
//        tiledMapController= new TiledMapController(world, tiledMap);
//        playerController= new PlayerController(world, PlayerTypes.NORMAL);
//        spawnController = new SpawnController( world, currentEnemyWaveDto.getEnemyInfoDto(), tiledMapController.getSpawnAreas());
//        waveTimersController = new WaveTimersController(currentEnemyWaveDto, spawnController);
//
//        this.enemyController= new EnemyController();
//        this.enemyDtoCreator= new EnemyDtoCreator(currentEnemyWaveDto.getEnemyInfoDto());
//    }

    private final GameLevelDto gameLevelDto;
    private final WorldController worldController;
    private final TiledMapController tiledMapController;

    private final EnemyController enemyController;
    private final PlayerController playerController;

    public LevelManager(int level){
        this.gameLevelDto= new JsonDataExtractor().getGameLevelDto(level);
        this.worldController = new WorldController(gameLevelDto.getWorldDto());
        this.tiledMapController = new TiledMapController(worldController.getWorld(), gameLevelDto.getTiledMapDto());

        this.enemyController= new EnemyController();
        this.playerController= new PlayerController();

    }

//    public void update(float delta) {
//
//        enemyController.update(delta);
//        enemyDtoCreator.getEnemyDto();
//
//        waveTimersController.update(delta);
//        tiledMapController.update(delta);
//        spawnController.spawnEnemy(new Vector2(0, 0));
//        playerController.update(delta);
//    }
//
//    public void draw(SpriteBatch spriteBatch){
//
//        enemyController.draw(spriteBatch);
//        playerController.draw(spriteBatch);
//    }


}
