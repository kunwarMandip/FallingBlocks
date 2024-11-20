package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.entity.enemy.Enemy;

import java.util.ArrayList;

public class LevelManager {

    private final ArrayList<Enemy> enemyArrayList= new ArrayList<>();

    private EnemyWavesController enemyWavesController;
    private TiledMapController tiledMapController;


    public LevelManager(World world, TiledMap tiledMap, int levelToLoad) {
        JsonDataExtractor jsonDataExtractor= new JsonDataExtractor();
        tiledMapController= new TiledMapController(world, tiledMap);
    }


    public void update(float delta){
        for(Enemy enemy: enemyArrayList){
            enemy.update(delta);
        }
    }

    public void draw(SpriteBatch spriteBatch){
        for(Enemy enemy: enemyArrayList){
            enemy.draw(spriteBatch);
        }
    }

    public void addEnemy(Enemy enemy){
        enemyArrayList.add(enemy);
    }
}
