package com.libgdx.fallingblocks.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;

import static com.libgdx.fallingblocks.GlobalVariables.*;

public class SceneController {

    private Viewport viewport;
    private OrthographicCamera orthographicGameCamera;

    private TiledMap tiledMap;
    private TiledMapDto tiledMapDto;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    public SceneController(TiledMapDto tiledMapDto){
        loadNextWave(tiledMapDto);
    }

    private void loadNextWave(TiledMapDto tiledMapDto){
        this.tiledMapDto= tiledMapDto;
        orthographicGameCamera = new OrthographicCamera();
        viewport = new FitViewport(VIRTUAL_WIDTH/PPM, VIRTUAL_HEIGHT/PPM, orthographicGameCamera);
        viewport.apply();
        orthographicGameCamera.position.set(viewport.getWorldWidth()/2f, viewport.getWorldHeight()/2f,0);
        orthographicGameCamera.update();
        tiledMap= new TmxMapLoader().load(this.tiledMapDto.getMapPath());
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,1/PPM);
    }

    public void render(){
        orthographicGameCamera.update();
        orthogonalTiledMapRenderer.setView(orthographicGameCamera);
        orthogonalTiledMapRenderer.render();
    }

    public OrthographicCamera getOrthographicGameCamera() {
        return orthographicGameCamera;
    }

    public void resize(int width, int height){
        viewport.update(width, height);
        viewport.apply();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
}
