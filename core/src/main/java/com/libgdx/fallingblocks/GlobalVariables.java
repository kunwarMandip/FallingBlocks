package com.libgdx.fallingblocks;

public class GlobalVariables {
    public static final float PPM                   = 16;
    public static final float VIRTUAL_WIDTH         = 720;
    public static final float VIRTUAL_HEIGHT        = 1440;


    //CONTACT MANAGER --- SET WHICH EACH CAN COLLIDE WITH
    public static final short CATEGORY_PLAYER           = 0x0001;
    public static final short CATEGORY_ENEMY            = 0x0002;
    public static final short CATEGORY_WALL             = 0x0004;
    public static final short CATEGORY_ENEMY_SPAWN_AREA = 0x0008;
    public static final short CATEGORY_OUTER_BOUND      = 0x00016;

}
