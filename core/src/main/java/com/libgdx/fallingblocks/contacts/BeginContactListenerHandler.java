package com.libgdx.fallingblocks.contacts;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.Logger;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.generic.OuterBound;

public class BeginContactListenerHandler {


    public boolean handleEnemyPlayerContact(Contact contact) {
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if (!(a.getUserData() instanceof Player && b.getUserData() instanceof Enemy) &&
            !(b.getUserData() instanceof Player && a.getUserData() instanceof Enemy)) {
            return false;
        }

        Player player = ((Player) (a.getUserData() instanceof Player ? a.getUserData() : b.getUserData()));
        Enemy enemy = ((Enemy) (a.getUserData() instanceof Enemy ? a.getUserData() : b.getUserData()));
//        player.onHit(enemy);
        enemy.setToDestroy();
        Logger.log(Logger.Tags.CONTACT_LISTENER, "Enemy Player Contact Handled");
        return true;
    }

    /**
     * Handles contact between Enemy class and OuterBound class
     * @param contact
     * @return
     */
    public boolean handleEnemyOuterBoundContact(Contact contact){
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if (!(a.getUserData() instanceof OuterBound && b.getUserData() instanceof Enemy) &&
            !(b.getUserData() instanceof OuterBound && a.getUserData() instanceof Enemy)) {
            return false;
        }

        Enemy enemy = ((Enemy) (a.getUserData() instanceof Enemy ? a.getUserData() : b.getUserData()));
        enemy.setToDestroy();

        Logger.log(Logger.Tags.ENEMY_OUTER_BOUND_CONTACT, "Enemy OuterBound Contact Handled");
        return true;
    }
}
