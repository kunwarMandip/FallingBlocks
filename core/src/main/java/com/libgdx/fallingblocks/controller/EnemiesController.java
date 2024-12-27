package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;
import com.libgdx.fallingblocks.entity.enemy.types.Enemy;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyDeathManager;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemyActionNotifier;
import com.libgdx.fallingblocks.entity.enemy.compact.EnemySpawnManager;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesDto;

import java.util.Map;


public class EnemiesController {

    private final Array<Enemy> currentEnemies;
    private final EnemyDeathManager enemyDeathManager;
    private final EnemySpawnManager enemySpawnManager;
    private final EnemyActionNotifier enemyActionNotifier;

    public EnemiesController(World world, EnemiesDto enemiesDto, Vector2 playerPosition, Map<MovementDirection, Vector2> spawnAreas){
        this.currentEnemies = new Array<>();
        this.enemyActionNotifier= new EnemyActionNotifier();
        this.enemyDeathManager= new EnemyDeathManager(currentEnemies);
        this.enemySpawnManager= new EnemySpawnManager(world, enemiesDto,  playerPosition, currentEnemies, spawnAreas);
    }

    public void update(float delta) {
        enemyDeathManager.update(delta);

        for(Enemy enemy: currentEnemies){
            enemy.update(delta);
        }

        enemySpawnManager.spawnEnemies();
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: currentEnemies){
            enemy.draw(spriteBatch);
        }
    }

    public EnemyActionNotifier getEnemyActionNotifier(){
        return this.enemyActionNotifier;
    }

//    private World world;
//    private Array<Enemy> enemies;
//    private EnemyRemover enemyRemover;
//    private IEnemyFactory enemyFactory;
//    private EnemyDtoBuilder enemyDtoFactory;
//    private EnemySpawner enemySpawner;
//
//    public EnemiesController(World world, EnemiesDto enemiesDto,
//                             Map<MovementDirection, Vector2> spawnAreas){
//        this.world=world;
//        this.enemies= new Array<>();
//        this.enemyFactory = new EnemyFactory();
//        this.enemySpawner = new EnemySpawner();
//        this.enemyDtoFactory = new EnemyDtoBuilder(enemiesDto, spawnAreas);
//        this.enemyRemover= new EnemyRemover(world);
//    }




//    public void addDeathListener(EnemyDeathObserver enemyDeathObserver) {
//        enemyRemover.addDeathListener(enemyDeathObserver);
//    }
//
//    public void update(float delta, Vector2 playerPosition){
//        updateEnemies(delta);
//        isEnemySpawnAble(playerPosition);
//        enemySpawner.update(delta);
//    }
//
//
//    public void draw(SpriteBatch spriteBatch){
//        for(Enemy enemy: enemies){
//            enemy.draw(spriteBatch);
//        }
//    }

//    private void updateEnemies(float delta){
//        Iterator<Enemy> iterator= enemies.iterator();
//        while(iterator.hasNext()){
//            Enemy enemy= iterator.next();
//            if(enemyRemover.isDestroy(enemy)){
//                iterator.remove();
//            }
//            enemy.update(delta);
//        }
//    }
//
//    public void emptyList(){
//        Iterator<Enemy> iterator= enemies.iterator();
//        while(iterator.hasNext()){
//            Enemy enemy= iterator.next();
//            enemy.destroy(world);
//            iterator.remove();
//        }
//    }
//
//    private void isEnemySpawnAble(Vector2 playerPosition){
//        int numEnemyToSpawn= enemySpawner.getNumEnemyToSpawn();
//
//        Logger.log(Logger.Tags.ENEMY_SPAWNER, "Enemy set to spawn");
//
//        for(int i =0; i< numEnemyToSpawn; i++){
//            EnemyDto enemyDto= enemyDtoFactory.getEnemyDto(playerPosition);
//            enemies.add(enemyFactory.getEnemy(enemyDto));
//        }
//
//        enemySpawner.resetNumEnemyToSpawn();
//
//    }


}
