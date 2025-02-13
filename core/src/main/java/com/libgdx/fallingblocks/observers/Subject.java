package com.libgdx.fallingblocks.observers;

import java.util.ArrayList;
import java.util.List;

public final class Subject<T>{

    private final List<Observable<T>> observableList = new ArrayList<>();

    public void addObserver(Observable<T> observable){
        observableList.add(observable);
    }

    public void removeObserver(Observable<T> observable){
        observableList.remove(observable);
    }

    public void notify(T event){
        for(Observable<T> observable : observableList){
            observable.onEvent(event);
        }
    }
}
