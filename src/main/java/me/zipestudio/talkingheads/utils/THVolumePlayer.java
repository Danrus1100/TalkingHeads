package me.zipestudio.talkingheads.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class THVolumePlayer {

    private double playerVolume;
    private UUID playerUuid;

    public THVolumePlayer(UUID uuid, float volume) {
        setPlayerUuid(uuid);
        setPlayerVolume(volume);
    }

}
