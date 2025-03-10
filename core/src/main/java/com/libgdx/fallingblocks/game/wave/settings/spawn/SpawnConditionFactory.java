package com.libgdx.fallingblocks.game.wave.settings.spawn;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.controller.WaveSettings;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.DeathBasedCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.ScoreBasedSpawnCondition;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions.TimeBasedSpawnCondition;

public class SpawnConditionFactory {

    private final WaveSettings waveSettings;

    public SpawnConditionFactory(WaveSettings waveSettings){
        this.waveSettings= waveSettings;
    }

    public ScoreBasedSpawnCondition scoreBasedSpawnCondition(Array<?> args){
        int score = ((Float) args.get(0)).intValue();
        ScoreBasedSpawnCondition scoreBasedSpawnCondition= new ScoreBasedSpawnCondition(score);
        waveSettings.getGameScore().getScoreObservers().addObserver(scoreBasedSpawnCondition);
        return scoreBasedSpawnCondition;
    }

    //TODO: Fix this method
    public DeathBasedCondition deathBasedSpawnCondition(Array<?> args){
//        DeathBasedCondition deathBasedSpawnCondition= new DeathBasedCondition((int) args.get(0));
//        waveSettings.getGameScore().getScoreObservers().addObserver(deathBasedSpawnCondition);
//        return deathBasedSpawnCondition;
        return null;
    }


    public TimeBasedSpawnCondition timeBasedSpawnCondition(Array<?> args){
        return new TimeBasedSpawnCondition((float) args.get(0));
    }

    public Spawn spawnCondition(SpawnConditionType spawnConditionType, Array<?> args){
        switch (spawnConditionType){
            case SCORE_BASED:
                return scoreBasedSpawnCondition(args);
            case DEATH_BASED:
                return deathBasedSpawnCondition(args);
            case TIME_BASED:
                return timeBasedSpawnCondition(args);
            default:
                throw new IllegalStateException("Unknown Spawn Condition Type");
        }
    }
}
