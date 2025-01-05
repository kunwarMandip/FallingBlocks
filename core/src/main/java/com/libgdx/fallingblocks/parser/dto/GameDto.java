package com.libgdx.fallingblocks.parser.dto;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;


public class GameDto {

    private final WaveManager waveManager;


    private final int lastWaveNumber;
    private final Array<WorldDto> worldDtoArray;
    private final Array<TiledMapDto> tiledMapDtoArray;
    private final Array<WaveSettingDto> waveSettingDtoArray;

    private final Array<PlayerDto> playerDtoArray;
    private final Array<EnemiesSpawnInfoDto> enemyInfoDtoArray;

    public GameDto(GameDtoBuilder gameDtoBuilder) {
        this.lastWaveNumber=1;
        this.waveManager= new WaveManager();
        this.worldDtoArray = gameDtoBuilder.worldDto;
        this.tiledMapDtoArray = gameDtoBuilder.tiledMapDto;
        this.waveSettingDtoArray = gameDtoBuilder.waveSettingDto;
        this.playerDtoArray = gameDtoBuilder.playerDto;
        this.enemyInfoDtoArray = gameDtoBuilder.enemyInfoDto;
    }

    public WaveDto getNextWave(){

        WaveDto.WaveDtoBuilder waveDtoBuilder= new WaveDto.WaveDtoBuilder()
            .setWorldDto(waveManager.getWorldDto(worldDtoArray))
            .setTiledMapDto(waveManager.getTiledMapDto(tiledMapDtoArray))
            .setWaveSettingDto(waveManager.getWaveSettingDto(waveSettingDtoArray))
            .setPlayerDto(waveManager.getPlayerDto(playerDtoArray))
            .setEnemyInfoDto(waveManager.getEnemyInfoDto(enemyInfoDtoArray));

        return waveDtoBuilder.build();
    }


    //todo variables always returns 1
    public int getLastWaveNumber() {
        return lastWaveNumber;
    }

    public static class GameDtoBuilder {
        private Array<WorldDto> worldDto;
        private Array<TiledMapDto> tiledMapDto;
        private Array<WaveSettingDto> waveSettingDto;

        private Array<PlayerDto> playerDto;
        private Array<EnemiesSpawnInfoDto> enemyInfoDto;

        public GameDtoBuilder setWorldDto(Array<WorldDto> worldDto) {
            this.worldDto = worldDto;
            return this;
        }

        public GameDtoBuilder setTiledMapDto(Array<TiledMapDto > tiledMapDto) {
            this.tiledMapDto = tiledMapDto;
            return this;
        }

        public GameDtoBuilder setPlayerDto(Array<PlayerDto> playerDto) {
            this.playerDto = playerDto;
            return this;
        }

        public GameDtoBuilder setWaveSettingsDto(Array<WaveSettingDto> waveSettingDto) {
            this.waveSettingDto = waveSettingDto;
            return this;
        }

        public GameDtoBuilder setEnemyInfoDto(Array<EnemiesSpawnInfoDto> enemyInfoDto) {
            this.enemyInfoDto = enemyInfoDto;
            return this;
        }

        public boolean areAllVariablesInitialized() {
            return worldDto != null && tiledMapDto != null && playerDto != null && waveSettingDto != null && enemyInfoDto != null;
        }

        public GameDto build(){
//            if(!areAllVariablesInitialized()){
//                throw new IllegalStateException("GameDtoBuilder: WaveDtoBuilder variables not initialized!");
//            }

            return new GameDto(this);
        }
    }
}
