package com.libgdx.fallingblocks.observers;

public interface Observer<T>{
    void notify(T event);
}
