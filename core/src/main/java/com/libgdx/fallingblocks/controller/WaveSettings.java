package com.libgdx.fallingblocks.controller;

import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.SpawnConditionController;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.TimeBasedSpawnCondition;
import com.libgdx.fallingblocks.game.score.GameScore;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;

public class WaveSettings {

    private final GameScore gameScore= new GameScore();
    private final SpawnConditionController spawnConditionController= new SpawnConditionController();

    public WaveSettings(WaveSettingDto waveSettingDto){
        setSpawnCondition();
    }

    private void setSpawnCondition(){
        spawnConditionController.addSpawnCondition(new TimeBasedSpawnCondition(10));
    }

    public SpawnConditionController getSpawnConditionController(){
        return spawnConditionController;
    }


    public GameScore getGameScore(){
        return gameScore;
    }


}
