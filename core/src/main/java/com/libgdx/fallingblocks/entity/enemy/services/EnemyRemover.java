package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.entity.common.listener.DeathListener;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.game.state.listeners.ScoreUpdateAble;

import java.util.ArrayList;
import java.util.List;

import static com.libgdx.fallingblocks.Logger.Tags.BEGIN_CONTACT_LISTENER;

public class EnemyRemover {

    private final World world;

    private final EnemyScoreCalculator enemyScoreCalculator;
    private final List<DeathListener> deathListeners= new ArrayList<>();

    public EnemyRemover(World world, ScoreUpdateAble scoreUpdateAble){
        this.world=world;
        this.enemyScoreCalculator= new EnemyScoreCalculator(scoreUpdateAble);
    }

    public void addDeathListener(DeathListener deathListener){
        deathListeners.add(deathListener);
    }



    public boolean isDestroy(Enemy enemy){
        if(!enemy.isSetToDestroy()){
            return false;
        }

        enemy.destroyBody(world);
        notifyDeathListeners(enemy);
        enemyScoreCalculator.calculateScore(enemy);
        Logger.log(BEGIN_CONTACT_LISTENER, "Destroying Enemy");
        return true;
    }

    private void notifyDeathListeners(Enemy enemy){
        for(DeathListener deathListener: deathListeners){
            deathListener.onDeath(enemy);
        }
    }
}
