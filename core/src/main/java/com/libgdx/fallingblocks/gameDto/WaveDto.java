package com.libgdx.fallingblocks.gameDto;

import com.libgdx.fallingblocks.gameDto.levelDto.*;

public class WaveDto {

    private final WorldDto worldDto;
    private final TiledMapDto tiledMapDto;

    private final PlayerDto playerDto;
    private final WaveSettingDto waveSettingDto;
    private final EnemyInfoDto enemyInfoDto;

    public WaveDto(WaveDtoBuilder waveDtoBuilder) {
        this.worldDto = waveDtoBuilder.worldDto;
        this.tiledMapDto = waveDtoBuilder.tiledMapDto;
        this.playerDto = waveDtoBuilder.playerDto;
        this.waveSettingDto = waveDtoBuilder.waveSettingDto;
        this.enemyInfoDto = waveDtoBuilder.enemyInfoDto;
    }

    public WorldDto getWorldDto() {
        return worldDto;
    }

    public TiledMapDto getTiledMapDto() {
        return tiledMapDto;
    }

    public PlayerDto getPlayerDto() {
        return playerDto;
    }

    public WaveSettingDto getWaveSettingDto() {
        return waveSettingDto;
    }

    public EnemyInfoDto getEnemyInfoDto() {
        return enemyInfoDto;
    }

    public static class WaveDtoBuilder {
        private WorldDto worldDto;
        private TiledMapDto tiledMapDto;
        private WaveSettingDto waveSettingDto;
        private PlayerDto playerDto;
        private EnemyInfoDto enemyInfoDto;

        public WaveDtoBuilder setWorldDto(WorldDto worldDto) {
            this.worldDto = worldDto;
            return this;
        }

        public WaveDtoBuilder setTiledMapDto(TiledMapDto tiledMapDto) {
            this.tiledMapDto = tiledMapDto;
            return this;
        }

        public WaveDtoBuilder setWaveSettingDto(WaveSettingDto waveSettingDto) {
            this.waveSettingDto = waveSettingDto;
            return this;
        }

        public WaveDtoBuilder setPlayerDto(PlayerDto playerDto) {
            this.playerDto = playerDto;
            return this;
        }

        public WaveDtoBuilder setEnemyInfoDto(EnemyInfoDto enemyInfoDto) {
            this.enemyInfoDto = enemyInfoDto;
            return this;
        }

        public WaveDto build() {
            return new WaveDto(this);
        }
    }
}

