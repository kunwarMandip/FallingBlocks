package com.libgdx.fallingblocks.game.spawn;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.TimeAble;

public class EnemySpawnSettings {

    private Array<TimeAble> timeAbleSpawnConditions;

    public void addListener(TimeAble timeAble){
        if(timeAbleSpawnConditions == null){
            timeAbleSpawnConditions= new Array<>();
        }

        timeAbleSpawnConditions.add(timeAble);
    }

    public void update(float delta){
        for (TimeAble timeAble: timeAbleSpawnConditions){
            timeAble.update(delta);
        }
    }

}
