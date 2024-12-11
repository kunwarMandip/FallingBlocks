package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.entity.enemy.EnemyDtoCreator;
import com.libgdx.fallingblocks.gameDto.GameDto;
import com.libgdx.fallingblocks.gameDto.WaveDto;
import com.libgdx.fallingblocks.gameDto.levelDto.WaveSettingDto;

public class LevelManager {

    private WaveSettingDto currentWaveSettingDto;


    private TimerController timerController;
    private  SpawnController spawnController;

    private EnemyDtoCreator enemyDtoCreator;

//    public LevelManager(int levelToLoad, World world, TiledMap tiledMap) {
//        gameDto= new DtoParserController().getGameLevelDto(levelToLoad);
//        currentWaveSettingDto= gameDto.getWaveDtoArray().get(0);
//
//        tiledMapController= new TiledMapController(world, tiledMap);
//        playerController= new PlayerController(world, PlayerTypes.NORMAL);
//        spawnController = new SpawnController( world, currentWaveSettingDto.getEnemyInfoDto(), tiledMapController.getSpawnAreas());
//        timerController = new TimerController(currentWaveSettingDto, spawnController);
//
//        this.enemiesController= new EnemiesController();
//        this.enemyDtoCreator= new EnemyDtoCreator(currentWaveSettingDto.getEnemyInfoDto());
//    }

    private final GameDto gameDto;
    private WaveDto waveDto;

    private final WorldController worldController;
    private final TiledMapController tiledMapController;

    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    public LevelManager(int level){
        this.gameDto= new DtoParserController().getGameDto(level);
        this.waveDto = gameDto.getWave();

        this.worldController = new WorldController(waveDto.getWorldDto());
        this.tiledMapController = new TiledMapController(worldController.getWorld(), waveDto.getTiledMapDto());

        this.playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto());
        this.enemiesController = new EnemiesController(worldController.getWorld(), waveDto.getEnemyInfoDto());

    }


    public void update(float delta){
        timerController.update(delta);
    }

    public void draw(SpriteBatch spriteBatch){
        playerController.draw(spriteBatch);
        enemiesController.draw(spriteBatch);
    }


    public void changeWave(){
        waveDto= gameDto.getWave();
    }

}
