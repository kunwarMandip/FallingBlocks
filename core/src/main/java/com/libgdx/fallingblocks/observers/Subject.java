package com.libgdx.fallingblocks.observers;

import java.util.ArrayList;
import java.util.List;

public final class Subject<T>{

    private final List<Observer<T>> observerList = new ArrayList<>();

    public void addObserver(Observer<T> observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer<T> observer){
        observerList.remove(observer);
    }

    public void notify(T event){
        for(Observer<T> observer: observerList){
            observer.notify(event);
        }
    }
}
