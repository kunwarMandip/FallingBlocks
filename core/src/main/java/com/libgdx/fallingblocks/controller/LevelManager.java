package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.fallingblocks.controller.controllers.*;
import com.libgdx.fallingblocks.gameDto.GameDto;
import com.libgdx.fallingblocks.gameDto.WaveDto;
import com.libgdx.fallingblocks.jsonParser.GameDtoParser;

public class LevelManager {

    private WaveDto waveDto;
    private final GameDto gameDto;

    private final WorldController worldController;
    private final TiledMapController tiledMapController;

    private final PlayerController playerController;
    private final EnemiesController enemiesController;

    public LevelManager(int level){
        this.gameDto= new GameDtoParser().getGameDto(level);
        this.waveDto = gameDto.getNextWave();

        this.worldController = new WorldController(waveDto.getWorldDto());
        this.tiledMapController = new TiledMapController(worldController.getWorld(), waveDto.getTiledMapDto());

        this.playerController= new PlayerController(worldController.getWorld(), waveDto.getPlayerDto());
        this.enemiesController = new EnemiesController(waveDto.getEnemyInfoDto(), tiledMapController.getSpawnAreas());
    }


    public void update(float delta){
        enemiesController.updateEnemies(delta);
    }

    public void draw(SpriteBatch spriteBatch){
        playerController.draw(spriteBatch);
        enemiesController.draw(spriteBatch);
    }

}
