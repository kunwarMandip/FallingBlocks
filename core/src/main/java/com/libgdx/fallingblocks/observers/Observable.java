package com.libgdx.fallingblocks.observers;

/**
 * A generic interface for observing events of type T.
 *
 * @param <T> The type of event being observed.
 */
public interface Observable<T>{
    void onEvent(T event);
}
