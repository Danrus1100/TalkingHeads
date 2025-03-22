package me.zipestudio.talkingheads.utils.interfaces;

import net.minecraft.entity.player.PlayerEntity;

@SuppressWarnings("java:S100")
public interface PlayerRenderStateWithParent {
    void talkingheads$setEntity(PlayerEntity entity);
    PlayerEntity talkingheads$getEntity();
}