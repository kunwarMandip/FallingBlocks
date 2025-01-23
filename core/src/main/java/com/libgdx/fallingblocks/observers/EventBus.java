package com.libgdx.fallingblocks.observers;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class EventBus {

    private Map<Subject<?>, Array<Observable<?>>> eventBus= new HashMap<>();

    public void add(Subject<?> subject){
        eventBus.putIfAbsent(subject, new Array<>());
    }

}
