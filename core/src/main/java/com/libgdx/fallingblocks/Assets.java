//package com.libgdx.fallingblocks;
//
//import com.badlogic.gdx.assets.AssetManager;
//import com.badlogic.gdx.assets.loaders.SkinLoader;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//
///**
// * Singleton Approach of AssetHandler
// */
//public class Assets {
//
//    private static final Assets INSTANCE = new Assets();
//    private final AssetManager manager;
//
//
//    public static String skinAtlas              = "flat-earth/skin/flat-earth-ui.atlas";
//    public static String skinJson               = "flat-earth/skin/flat-earth-ui.json";
//
//
//    private Assets(){
//        manager= new AssetManager();
//    }
//
//    public static Assets getInstance(){
//        return INSTANCE;
//    }
//
//
//    public void loadMenuAssets(){
//        manager.load(skinAtlas, TextureAtlas.class);
//
//        // Load the skin (dependent on the atlas)
//        manager.load(skinJson, Skin.class,
//            new SkinLoader.SkinParameter(skinAtlas));
//
//        manager.finishLoading();
//    }
//
//
//    public void loadGameRunningAssets(){
//    }
//
//    private void disposeMenuAssets(){
//        manager.unload(skinAtlas);
//        manager.unload(skinJson);
//    }
//
//    private void disposeGameRunningAssets(){
//
//    }
//
//    public void dispose(){
//        manager.dispose();
//    }
//}
