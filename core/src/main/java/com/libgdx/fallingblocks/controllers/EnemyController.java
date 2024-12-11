package com.libgdx.fallingblocks.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

public class EnemyController {

    private final Array<Enemy> allEnemies = new Array<>();

    public void update(float delta){
        for (Enemy enemy: allEnemies){
            enemy.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: allEnemies){
            enemy.draw(spriteBatch);
        }
    }
}
