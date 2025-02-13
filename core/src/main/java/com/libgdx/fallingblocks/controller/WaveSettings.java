package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.game.wave.settings.death.EnemyDeath;
import com.libgdx.fallingblocks.game.wave.settings.score.GameScore;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionController;
import com.libgdx.fallingblocks.game.wave.settings.spawn.SpawnConditionListener;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;

public class WaveSettings {

    private final GameScore gameScore;
    private final EnemyDeath enemyDeath;
    private final SpawnConditionController spawnConditionController;

    public WaveSettings(WaveSettingDto waveSettingDto){
        this.gameScore= new GameScore(0);
        this.enemyDeath= new EnemyDeath();
        this.spawnConditionController= new SpawnConditionController(this);
    }

    public void update(float delta){
        spawnConditionController.update(delta);
    }

    public GameScore getGameScore(){
        return gameScore;
    }

    public EnemyDeath getEnemyDeath(){
        return enemyDeath;
    }

    public SpawnConditionListener getSpawnConditions(){
        return spawnConditionController.getSpawnConditionListener();
    }

}
