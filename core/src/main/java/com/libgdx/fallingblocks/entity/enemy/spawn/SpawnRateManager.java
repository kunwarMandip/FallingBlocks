package com.libgdx.fallingblocks.entity.enemy.spawn;

public class SpawnRateManager {

    private final EnemySpawnRateController enemySpawnRateController;
//    private final List<Timed> timeBasedSpawnRate= new ArrayList<>();

    public SpawnRateManager(){
        this.enemySpawnRateController= new EnemySpawnRateController();
    }

//    public void addListeners(SpawnRate spawnRateController){
//        if(spawnRateController instanceof TimeBasedSpawnCondition){
//            timeBasedSpawnRate.add(((TimeBasedSpawnCondition) spawnRateController));
//        }
//        enemySpawnRateController.addListeners(spawnRateController);
//    }
//
//    public void update(float delta){
//        for(Timed timed: timeBasedSpawnRate){
//            timed.update(delta);
//        }
//    }
}
