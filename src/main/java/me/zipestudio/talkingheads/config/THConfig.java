package me.zipestudio.talkingheads.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import lombok.Getter;
import lombok.Setter;
import me.zipestudio.talkingheads.THServer;

@Setter
@Getter
public class THConfig {

    public static final ConfigClassHandler<THConfig> GSON = ConfigClassHandler.createBuilder(THConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(YACLPlatform.getConfigDir().resolve("talkingheads.json"))
                    .build())
            .build();

    @SerialEntry
    private boolean enableMod = true;

    @SerialEntry
    private double removedVolume = 0.0020;

    @SerialEntry
    private double scaleX = 1;

    @SerialEntry
    private double scaleY = 1;

    @SerialEntry
    private double scaleZ = 1;

    public static boolean isModDisabled() {
        return !THServer.getThConfig().enableMod;
    }
}
