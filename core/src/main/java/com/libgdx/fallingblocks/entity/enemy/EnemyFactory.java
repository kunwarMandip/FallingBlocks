package com.libgdx.fallingblocks.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyDto;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.entity.enemy.types.BossEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.NormalEnemy;
import com.libgdx.fallingblocks.entity.enemy.types.QuickEnemy;


public class EnemyFactory {

    private final World world;
    private final EnemyDtoCreator enemyDtoCreator;

    public EnemyFactory(World world, EnemyInfoDto enemyInfoDto){
        this.world=world;
        this.enemyDtoCreator= new EnemyDtoCreator(enemyInfoDto);
    }

    public Enemy getEnemy(){
        EnemyDto enemyDto= enemyDtoCreator.getEnemyDto();
        switch (enemyDto.getEnemyType()){
            case NORMAL:
                return new NormalEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
            case QUICK:
                return new QuickEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
            case BOSS:
                return new BossEnemy(world, enemyDto.getSpawnPosition(), new Vector2(5, 5),enemyDto.getSpawnPosition());
        }

        throw new IllegalStateException("EnemyFactory: Unknown EnemyType");
    }

}
