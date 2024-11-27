package com.libgdx.fallingblocks.contactlistener;

import com.badlogic.gdx.physics.box2d.*;

public class GameContactListener implements ContactListener {

    private final BeginContactListenerHandler beginContactListenerHandler;
    private final PreSolveContactListenerHandler preSolveContactListenerHandler;
    public GameContactListener(){
        this.beginContactListenerHandler= new BeginContactListenerHandler();
        this.preSolveContactListenerHandler= new PreSolveContactListenerHandler();
    }

    @Override
    public void beginContact(Contact contact) {
        if(isAnyBodiesNull(contact)){
            return;
        }
    }

    @Override
    public void endContact(Contact contact) {


    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        if(isAnyBodiesNull(contact)){
            return;
        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    /**
     * Checks if any of the contact body are null
     * @param contact the two bodies which collided
     * @return true if any bodies are not null
     */
    private boolean isAnyBodiesNull(Contact contact){
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();
        if (a == null || b == null){return true;}
        return a.getUserData() == null || b.getUserData() == null;

    }
}
