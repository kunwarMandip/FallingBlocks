package com.libgdx.fallingblocks;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Singleton Approach of AssetHandler
 */
public class Assets {

    private static final Assets INSTANCE = new Assets();
    public final AssetManager manager = new AssetManager();

    private Assets(){}

    public static Assets getInstance(){
        return INSTANCE;
    }

    public void loadMenuAssets(){
        manager.load("flat-earth/skin/flat-earth-ui.atlas", TextureAtlas.class);

        // Load the skin (dependent on the atlas)
        manager.load("flat-earth/skin/flat-earth-ui.json", Skin.class,
            new SkinLoader.SkinParameter("flat-earth/skin/flat-earth-ui.atlas"));

        manager.finishLoading();
    }


    public void loadGameRunningAssets(){
    }

    private void disposeMenuAssets(){
        manager.unload("flat-earth/skin/flat-earth-ui.atlas");
        manager.unload("flat-earth/skin/flat-earth-ui.json");
    }

    private void disposeGameRunningAssets(){

    }

    public void dispose(){
        manager.dispose();
    }
}
