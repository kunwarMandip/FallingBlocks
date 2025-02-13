package com.libgdx.fallingblocks.observers;

/**
 * A generic interface for observing any specified event Type.
 *
 * @param <T> The type of event being observed.
 */
public interface Observable<T>{
    void onEvent(T event);
}
