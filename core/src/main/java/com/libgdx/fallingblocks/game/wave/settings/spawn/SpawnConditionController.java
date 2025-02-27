package com.libgdx.fallingblocks.game.wave.settings.spawn;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.controller.WaveSettings;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.TimeBasedSpawnCondition;
import com.libgdx.fallingblocks.observers.TimeAble;
import com.libgdx.fallingblocks.parser.dto.wave.EnemySpawnConditionDto;

public class SpawnConditionController {

    private final SpawnConditionFactory spawnConditionFactory;
    private final Array<Spawn> spawnConditionArray= new Array<>();
    private final Array<TimeAble> timedSpawnCondition= new Array<>();
    private final SpawnConditionListener spawnConditionListener= new SpawnConditionListener();

    public SpawnConditionController(WaveSettings waveSettings,  Array<EnemySpawnConditionDto> enemySpawnConditionDto){
        this.spawnConditionFactory= new SpawnConditionFactory(waveSettings);
        parseInitial(enemySpawnConditionDto);
    }

    private void parseInitial(Array<EnemySpawnConditionDto> enemySpawnConditionDto){
        for(EnemySpawnConditionDto spawnConditionDto: enemySpawnConditionDto){
            SpawnConditionType spawnConditionType= SpawnConditionType.valueOf(spawnConditionDto.spawnCondition);
            setSpawnCondition(spawnConditionType, spawnConditionDto.spawnArguments);
        }
    }

    /**
     * Update all timed spawn conditions.
     * @param delta time elapsed since the last call in seconds.
     */
    public void update(float delta){
        for(TimeAble timeAble: timedSpawnCondition){
            timeAble.update(delta);
        }
    }

    public void setSpawnCondition(SpawnConditionType spawnConditionType, Array<?> args){
        if(spawnConditionType == SpawnConditionType.TIME_BASED){
            TimeBasedSpawnCondition timeAble= (TimeBasedSpawnCondition) spawnConditionFactory.spawnCondition(spawnConditionType, args);
            timedSpawnCondition.add(timeAble);
            spawnConditionListener.addSpawnCondition(timeAble);
            return;
        }
        Spawn spawnCondition= spawnConditionFactory.spawnCondition(spawnConditionType, args);
        spawnConditionArray.add(spawnCondition);
        spawnConditionListener.addSpawnCondition(spawnCondition);


        Logger.log(Logger.Tags.SPAWN_CONDITION, "Spawn Condition Set");
    }

    public SpawnConditionListener getSpawnConditionListener(){
        return spawnConditionListener;
    }
}
