package com.libgdx.fallingblocks.controller.controllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.fallingblocks.jsonParser.dto.levelDto.TiledMapDto;

import static com.libgdx.fallingblocks.GlobalVariables.*;

public class SceneGraphController {

    private Viewport gameViewport;
    private OrthographicCamera orthographicGameCamera;

    private TiledMap tiledMap;
    private TiledMapDto tiledMapDto;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    public SceneGraphController(TiledMapDto tiledMapDto){
        this.tiledMapDto= tiledMapDto;

        orthographicGameCamera = new OrthographicCamera();
        gameViewport = new FitViewport(VIRTUAL_WIDTH/PPM, VIRTUAL_HEIGHT/PPM, orthographicGameCamera);
        gameViewport.apply();
        orthographicGameCamera.position.set(gameViewport.getWorldWidth()/2f,gameViewport.getWorldHeight()/2f,0);
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
        gameViewport.update(width, height);
        gameViewport.apply();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
}
