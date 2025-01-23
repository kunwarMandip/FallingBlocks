package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate;

import com.badlogic.gdx.utils.Array;

public class EnemySpawnSettings {

    private Array<TimeAble> timeAbleSpawnConditions;
    private Array<Spawn> spawnConditions;

    public void addListener(Spawn spawn){

        if(spawnConditions == null){
            spawnConditions= new Array<>();
        }

        spawnConditions.add(spawn);
    }

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
