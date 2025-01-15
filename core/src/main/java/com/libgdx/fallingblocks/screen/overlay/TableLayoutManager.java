package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * Get or Create Table Automatically depending on the wanted Align
 */
public class TableLayoutManager {

    private final Map<Integer, Table> tableList = new HashMap<>();

    public Table getTable(Integer align){
        if(tableList.containsKey(align)){
            return tableList.get(align);
        }

        Table table= new Table();
        table.setFillParent(true);
        table.align(align);
        table.setDebug(true);
        return table;
    }

    public void dispose(){
        tableList.clear();
    }
}
