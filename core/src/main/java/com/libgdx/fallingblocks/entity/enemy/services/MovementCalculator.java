package com.libgdx.fallingblocks.entity.enemy.services;

import com.badlogic.gdx.math.Vector2;
import com.libgdx.fallingblocks.box2d.world.tiled.objects.spawnArea.MovementDirection;

import java.util.Map;

public class MovementCalculator {

    private final Map<MovementDirection, Vector2> spawnAreas;
    public MovementCalculator(Map<MovementDirection, Vector2> spawnAreas){
        this.spawnAreas= spawnAreas;
    }

    public Vector2 calculateSpeed(MovementDirection movementDirection){
        float constantSpeed=5f;
        Vector2 speed;
        switch(movementDirection){
            case TOP:
                speed= new Vector2(0, -(constantSpeed));
                break;
            case BOTTOM:
                speed= new Vector2(0, constantSpeed);
                break;
            case RIGHT:
                speed= new Vector2(-constantSpeed, 0);
                break;
            case LEFT:
                speed=  new Vector2(constantSpeed, 0);
                break;
            default:
                throw new IllegalStateException("Unknown MovementDirection: " + movementDirection);
        }

        return speed;
    }

    public Vector2 calculateSpawnPosition(MovementDirection movementDirection, Vector2 playerLocation){
        Vector2 spawnArea= spawnAreas.get(movementDirection);
        Vector2 spawnPosition;
        switch(movementDirection){
            case TOP :
            case BOTTOM:
                spawnPosition= new Vector2(playerLocation.x,spawnArea.y);
                break;
            case RIGHT:
                spawnPosition= new Vector2(spawnArea.y, playerLocation.y);
                break;
            case LEFT:
                spawnPosition= new Vector2(spawnArea.x, playerLocation.y );
                break;
            default:
                throw new IllegalStateException("Unknown MovementDirection: " + movementDirection);
        }
        return spawnPosition;
    }
}
