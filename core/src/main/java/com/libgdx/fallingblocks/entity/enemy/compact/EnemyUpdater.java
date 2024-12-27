package com.libgdx.fallingblocks.entity.enemy.compact;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;

import java.util.Iterator;

public class EnemyUpdater {

    private final World world;
    private final Array<Enemy> enemyArray= new Array<>();

    public EnemyUpdater(World world){
        this.world=world;
    }

    public void update(float delta){
        destroyEnemies();
        updateEnemies(delta);
        spawnEnemies();
    }

    private void destroyEnemies(){
        Iterator<Enemy> enemyIterator= enemyArray.iterator();
        while (enemyIterator.hasNext()){
            Enemy enemy= enemyIterator.next();
            if(enemy.isSetToDestroy()){
                enemy.destroy(world);
                enemyIterator.remove();
            }
        }
    }

    private void updateEnemies(float delta){
        for (Enemy enemy : enemyArray) {
            enemy.update(delta);
        }
    }

    private void spawnEnemies(){

    }

    public void draw(SpriteBatch spriteBatch){
        for (Enemy enemy : enemyArray) {
            enemy.draw(spriteBatch);
        }
    }
}
