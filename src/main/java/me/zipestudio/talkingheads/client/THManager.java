package me.zipestudio.talkingheads.client;

import lombok.Getter;
import lombok.Setter;
import me.zipestudio.talkingheads.THServer;
import me.zipestudio.talkingheads.config.THConfig;
import me.zipestudio.talkingheads.utils.interfaces.ResizableModelPart;
import me.zipestudio.talkingheads.utils.THVolumePlayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.UUID;


@Getter
@Setter
public class THManager {

    @Getter
    public static final HashMap<UUID, THVolumePlayer> PLAYERS = new HashMap<>();

    private static THConfig thConfig = THServer.getThConfig();

    public static void renderHead(UUID uuid, BipedEntityModel<?> model) {
        HashMap<UUID, THVolumePlayer> playersMap = getPLAYERS();
        THVolumePlayer thVolumePlayerInfo = playersMap.get(uuid);

        if (thVolumePlayerInfo != null) {

            double playerVolume = thVolumePlayerInfo.getPlayerVolume();

            double sizeX = 1 + thConfig.getScaleX() * playerVolume;
            double sizeY = 1 + thConfig.getScaleY() * playerVolume;
            double sizeZ = 1 + thConfig.getScaleZ() * playerVolume;

            if (playerVolume <= 0.01) {
                playersMap.remove(uuid);
                ((ResizableModelPart) model.head).talkingHeads$setDefaultSize();

                //? <1.21.2 {
                /*((ResizableModelPart) model.hat).talkingHeads$setDefaultSize();
                 *///?}
                return;
            }

            //? <1.21.2 {
            /*((ResizableModelPart) model.hat).talkingHeads$setSize(sizeX, sizeY, sizeZ);
             *///?}

            ((ResizableModelPart) model.head).talkingHeads$setSize(sizeX, sizeY, sizeZ);

            thVolumePlayerInfo.setPlayerVolume(playerVolume - thConfig.getRemovedVolume());
        } else {
            playersMap.remove(uuid);
            ((ResizableModelPart) model.head).talkingHeads$setDefaultSize();

            //? <1.21.2 {
            /*((ResizableModelPart) model.hat).talkingHeads$setDefaultSize();
             *///?}
        }
    }

    public static void renderHead(UUID uuid, MatrixStack matrixStack) {
        HashMap<UUID, THVolumePlayer> playersMap = getPLAYERS();
        THVolumePlayer thVolumePlayerInfo = playersMap.get(uuid);

        if (thVolumePlayerInfo != null) {
            double playerVolume = thVolumePlayerInfo.getPlayerVolume();

            double sizeX = 1 + thConfig.getScaleX() * playerVolume;
            double sizeY = 1 + thConfig.getScaleY() * playerVolume;
            double sizeZ = 1 + thConfig.getScaleZ() * playerVolume;

            if (playerVolume <= 0.01) {
                playersMap.remove(uuid);

                matrixStack.scale(1, 1, 1);
                return;
            }

            matrixStack.scale((float) sizeX, (float) sizeY, (float) sizeZ);

            thVolumePlayerInfo.setPlayerVolume(playerVolume - thConfig.getRemovedVolume());
        } else {
            playersMap.remove(uuid);
            matrixStack.scale(1, 1, 1);
        }
    }

}
