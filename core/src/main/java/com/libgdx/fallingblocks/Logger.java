package com.libgdx.fallingblocks;

import com.badlogic.gdx.Gdx;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Logger {

    public enum Tags {
        TILED_MAP_PARSER,
        ENEMY_INFO_PARSER,
        WAVE_PARSER,
        CONTACT_LISTENER,
        WAVE_TIMER_CONTROLLER,
        DISABLE_ALL
    }

    private static final Set<Tags> enabledTags= new HashSet<>();

    static{
        Collections.addAll(enabledTags, Tags.values());
        disableTag(Tags.DISABLE_ALL);
    }

    public static void enableTag(Tags tag) {
        enabledTags.add(tag);
    }

    public static void disableTag(Tags tag) {
        enabledTags.remove(tag);
    }

    public static void disableAll() {
        enabledTags.add(Tags.DISABLE_ALL);
    }

    public static void enableSingle(Tags tag){
        enabledTags.clear();
        enableTag(tag);
    }

    public static void log(Tags tag, String message){
        if(enabledTags.contains(Tags.DISABLE_ALL)) return;
        if(!enabledTags.contains(tag))return;
        Gdx.app.log(String.valueOf(tag), tag + " : " +  message);
    }
}
