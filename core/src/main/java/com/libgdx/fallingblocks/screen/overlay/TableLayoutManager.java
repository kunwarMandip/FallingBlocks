package com.libgdx.fallingblocks.screen.overlay;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.HashMap;
import java.util.Map;

public class TableLayoutManager {

    private final Stage stage;
    private final Table masterTable;
    private final Map<Integer, Table> tableList = new HashMap<>();

    public TableLayoutManager(Stage stage){
        this.stage=stage;
        this.masterTable= new Table();
        this.masterTable.setFillParent(true);
        stage.addActor(masterTable);
    }

    public boolean isTableSet(Integer align){
        return tableList.containsKey(align);
    }

    public void addTable(Table table){
        tableList.put(table.getAlign(), table);
    }

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

    public void updateTable(){
        tableList.forEach((Key, value) -> {
            masterTable.add(value);
        });

        stage.getActors().removeValue(masterTable, true);
        stage.addActor(masterTable);
    }
}
