package com.libgdx.fallingblocks.entity.enemy.difficulty.spawnrate.conditions;

public interface SpawnCondition {


    //The use of interface such as DeathSpawnCondition, ScoreSpawnCondition instead of this single interface might seem excessive.
    //However, this allows me to expand my code easily into the future
    boolean shouldSpawn();
}
