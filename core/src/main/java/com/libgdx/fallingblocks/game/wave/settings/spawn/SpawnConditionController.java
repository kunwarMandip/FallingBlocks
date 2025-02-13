package com.libgdx.fallingblocks.game.wave.settings.spawn;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.controller.WaveSettings;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.TimeBasedSpawnCondition;
import com.libgdx.fallingblocks.observers.TimeAble;

public class SpawnConditionController {

    private final SpawnConditionFactory spawnConditionFactory;
    private final Array<Spawn> spawnConditionArray= new Array<>();
    private final Array<TimeAble> timedSpawnCondition= new Array<>();
    private final SpawnConditionListener spawnConditionListener= new SpawnConditionListener();

    public SpawnConditionController(WaveSettings waveSettings){
        this.spawnConditionFactory= new SpawnConditionFactory(waveSettings);

        Array<Integer> times= new Array<>();
        times.add(5);
        setSpawnCondition(SpawnConditionType.TIME_BASED, times);
        setSpawnCondition(SpawnConditionType.SCORE_BASED, times);
    }

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
    }

    public SpawnConditionListener getSpawnConditionListener(){
        return spawnConditionListener;
    }
}
