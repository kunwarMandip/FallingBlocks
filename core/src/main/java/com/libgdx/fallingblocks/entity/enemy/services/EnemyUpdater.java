//package com.libgdx.fallingblocks.entity.enemy.services;
//
//
//import com.badlogic.gdx.physics.box2d.World;
//import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
//import com.libgdx.fallingblocks.listeners.common.EntityDeathObserver;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class EnemyUpdater implements EntityDeathObserver<Enemy> {
//
//    private final List<Enemy> enemiesToDestroy= new ArrayList<>();
//    private final List<EntityDeathObserver<Enemy>> entityDeathObservers= new ArrayList<>();
//
//    public void destroyEnemies(World world){
//        Iterator<Enemy> enemies= enemiesToDestroy.iterator();
//        while (enemies.hasNext()){
//            Enemy enemy= enemies.next();
//            enemy.destroy(world);
//            enemies.remove();
//        }
//    }
//
//
//    @Override
//    public void handleEntityDeath(Enemy entity) {
//        enemiesToDestroy.add(entity);
//    }
//}
