package com.libgdx.fallingblocks.box2d.entity.common.interfaces;

import com.libgdx.fallingblocks.box2d.entity.enemy.Enemy;

public interface IEnemyRemovable<T extends Enemy> {

    void removeInstance(T enemy);


}
