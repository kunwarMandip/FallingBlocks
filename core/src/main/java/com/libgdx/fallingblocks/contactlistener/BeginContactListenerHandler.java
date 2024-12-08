package com.libgdx.fallingblocks.contactlistener;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.libgdx.fallingblocks.entity.enemy.Enemy;
import com.libgdx.fallingblocks.entity.player.Player;
import com.libgdx.fallingblocks.map.objects.OuterBound;
import com.libgdx.fallingblocks.map.objects.PlayerWall;

public class BeginContactListenerHandler {


    public boolean handleEnemyPlayerContact(Contact contact) {
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if (!(a.getUserData() instanceof Player && b.getUserData() instanceof Enemy) &&
            !(b.getUserData() instanceof Player && a.getUserData() instanceof Enemy)) {
            return false;
        }

        System.out.println("Enemy Player Contact Handled");
        return true;
    }

    public boolean handleEnemyOuterBoundContact(Contact contact){
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if (!(a.getUserData() instanceof OuterBound && b.getUserData() instanceof Enemy) &&
            !(b.getUserData() instanceof OuterBound && a.getUserData() instanceof Enemy)) {
            return false;
        }

        System.out.println("Enemy OuterBound Contact Handled");
        return true;
    }

    public boolean handleEnemyWallContact(Contact contact){
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if (!(a.getUserData() instanceof PlayerWall && b.getUserData() instanceof Enemy) &&
            !(b.getUserData() instanceof PlayerWall && a.getUserData() instanceof Enemy)) {
            return false;
        }

        System.out.println("Enemy OuterBound Contact Handled");
        return true;
    }


}
