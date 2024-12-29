package com.libgdx.fallingblocks.entity.common.observers;

import java.util.ArrayList;
import java.util.List;

public class Subject<T>{

    private final List<Observers<T>> observersList= new ArrayList<>();

    public void addObserver(Observers<T> observers){
        observersList.add(observers);
    }

    public void removeObserver(Observers<T> observers){
        observersList.remove(observers);
    }

    public void notify(T event){
        for(Observers<T> observer: observersList){
            observer.notify(event);
        }
    }
}
