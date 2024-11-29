package com.libgdx.fallingblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.controller.LevelManager;

import static com.libgdx.fallingblocks.GlobalVariables.*;

public class GameScreen implements Screen {

    private final int levelToLoad;
    private final SpriteBatch spriteBatch;

    private Viewport gameViewport;
    private OrthographicCamera orthographicGameCamera;

    private World world;
    private TiledMap tiledMap;
    private Box2DDebugRenderer box2DDebugRenderer;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    private LevelManager levelManager;

    public GameScreen(int levelToLoad, SpriteBatch spriteBatch){
        this.levelToLoad=levelToLoad;
        this.spriteBatch=spriteBatch;
    }

    @Override
    public void show() {
        orthographicGameCamera = new OrthographicCamera();
        gameViewport = new FitViewport(VIRTUAL_WIDTH/PPM, VIRTUAL_HEIGHT/PPM, orthographicGameCamera);
        gameViewport.apply();
        orthographicGameCamera.position.set(gameViewport.getWorldWidth()/2f,gameViewport.getWorldHeight()/2f,0);
        orthographicGameCamera.update();
        world= new World(new Vector2(0,0),true);
        box2DDebugRenderer= new Box2DDebugRenderer();
        box2DDebugRenderer.SHAPE_STATIC.set(0,0,0,1);
        box2DDebugRenderer.setDrawBodies(true);

        tiledMap= new TmxMapLoader().load("map/tiledMap.tmx");
        orthogonalTiledMapRenderer= new OrthogonalTiledMapRenderer(tiledMap,1/PPM);

        levelManager = new LevelManager(levelToLoad, world,tiledMap);
    }

    private void update(float delta){
        levelManager.update(delta);
        world.step(1/60f, 6, 2);
    }


    private void clearScreen(){
        Gdx.gl.glClearColor(0,0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void renderSpriteBatch(){
        spriteBatch.setProjectionMatrix(orthographicGameCamera.combined);
        spriteBatch.begin();
        levelManager.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void render(float delta) {
        update(delta);
        clearScreen();

        orthographicGameCamera.update();
        orthogonalTiledMapRenderer.setView(orthographicGameCamera);
        orthogonalTiledMapRenderer.render();
        box2DDebugRenderer.render(world, orthographicGameCamera.combined);

        renderSpriteBatch();
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width, height);
        gameViewport.apply();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
