package com.libgdx.fallingblocks.gameDto;

import com.badlogic.gdx.utils.Array;
import com.libgdx.fallingblocks.gameDto.levelDto.EnemyInfoDto;
import com.libgdx.fallingblocks.gameDto.levelDto.WorldDto;
import com.libgdx.fallingblocks.gameDto.levelDto.PlayerDto;
import com.libgdx.fallingblocks.gameDto.levelDto.TiledMapDto;
import com.libgdx.fallingblocks.gameDto.levelDto.WaveSettingDto;


public class GameDto {

    private final Array<WorldDto> worldDto;
    private final Array<TiledMapDto> tiledMapDto;
    private final Array<WaveSettingDto> waveSettingDto;

    private final Array<PlayerDto> playerDto;
    private final Array<EnemyInfoDto> enemyInfoDto;

    public GameDto(GameDtoBuilder gameDtoBuilder) {
        this.worldDto = gameDtoBuilder.worldDto;
        this.tiledMapDto = gameDtoBuilder.tiledMapDto;
        this.waveSettingDto = gameDtoBuilder.waveSettingDto;
        this.playerDto = gameDtoBuilder.playerDto;
        this.enemyInfoDto = gameDtoBuilder.enemyInfoDto;
    }


    public WaveDto getWave(){
        WaveDto.WaveDtoBuilder waveDtoBuilder= new WaveDto.WaveDtoBuilder()
            .setWaveSettingDto(null)
            .setWorldDto(null)
            .setTiledMapDto(null)
            .setPlayerDto(null)
            .setEnemyInfoDto(null);

        return waveDtoBuilder.build();
    }

    public static class GameDtoBuilder {
        private Array<WorldDto> worldDto;
        private Array<TiledMapDto> tiledMapDto;
        private Array<WaveSettingDto> waveSettingDto;

        private Array<PlayerDto> playerDto;
        private Array<EnemyInfoDto> enemyInfoDto;

        public GameDtoBuilder setWorldDto(Array<WorldDto> worldDto) {
            this.worldDto = worldDto;
            return this;
        }

        public GameDtoBuilder setTiledMapDto(Array<TiledMapDto> tiledMapDto) {
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

        public GameDtoBuilder setEnemyInfoDto(Array<EnemyInfoDto> enemyInfoDto) {
            this.enemyInfoDto = enemyInfoDto;
            return this;
        }

        public boolean areAllVariablesInitialized() {
            return worldDto != null &&
                tiledMapDto != null &&
                playerDto != null &&
                waveSettingDto != null &&
                enemyInfoDto != null;
        }

        public GameDto build(){
            if(!areAllVariablesInitialized()){
                throw new IllegalStateException("GameDtoBuilder: WaveDtoBuilder variables not initialized!");
            }

            return new GameDto(this);
        }
    }
}
