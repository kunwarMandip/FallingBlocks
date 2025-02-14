package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.wave.settings.death.EnemyDeathManager;
import com.libgdx.fallingblocks.game.wave.settings.score.GameScoreManager;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionController;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionListener;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;

public class WaveSettings {

    private final GameScoreManager gameScoreManager;
    private final EnemyDeathManager enemyDeathManager;
    private final SpawnConditionController spawnConditionController;

    public WaveSettings(WaveSettingDto waveSettingDto){
        this.gameScoreManager = new GameScoreManager(0);
        this.enemyDeathManager = new EnemyDeathManager();
        this.spawnConditionController= new SpawnConditionController(this);
    }

    public void update(float delta){
        spawnConditionController.update(delta);
    }

    public GameScoreManager getGameScore(){
        return gameScoreManager;
    }

    public EnemyDeathManager getEnemyDeath(){
        return enemyDeathManager;
    }

    public SpawnConditionListener getSpawnConditions(){
        return spawnConditionController.getSpawnConditionListener();
    }

}
