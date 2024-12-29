package com.libgdx.fallingblocks.parser.dto;

import com.libgdx.fallingblocks.parser.dto.levelDto.PlayerDto;
import com.libgdx.fallingblocks.parser.dto.levelDto.WaveSettingDto;
import com.libgdx.fallingblocks.parser.dto.wave.EnemiesSpawnInfoDto;
import com.libgdx.fallingblocks.parser.dto.wave.TiledMapDto;
import com.libgdx.fallingblocks.parser.dto.wave.WorldDto;

public class WaveDto {

    private final WorldDto worldDto;
    private final TiledMapDto tiledMapDto;

    private final PlayerDto playerDto;
    private final WaveSettingDto waveSettingDto;
    private final EnemiesSpawnInfoDto enemiesSpawnInfoDto;

    public WaveDto(WaveDtoBuilder waveDtoBuilder) {
        this.worldDto = waveDtoBuilder.worldDto;
        this.tiledMapDto = waveDtoBuilder.tiledMapDto;
        this.playerDto = waveDtoBuilder.playerDto;
        this.waveSettingDto = waveDtoBuilder.waveSettingDto;
        this.enemiesSpawnInfoDto = waveDtoBuilder.enemiesSpawnInfoDto;
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

    public EnemiesSpawnInfoDto getEnemyInfoDto() {
        return enemiesSpawnInfoDto;
    }

    public static class WaveDtoBuilder {
        private WorldDto worldDto;
        private TiledMapDto tiledMapDto;
        private WaveSettingDto waveSettingDto;
        private PlayerDto playerDto;
        private EnemiesSpawnInfoDto enemiesSpawnInfoDto;

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

        public WaveDtoBuilder setEnemyInfoDto(EnemiesSpawnInfoDto enemiesSpawnInfoDto) {
            this.enemiesSpawnInfoDto = enemiesSpawnInfoDto;
            return this;
        }

        public WaveDto build() {
            return new WaveDto(this);
        }
    }
}

