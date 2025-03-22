package me.zipestudio.talkingheads.mixin;

import me.zipestudio.talkingheads.client.THManager;
import me.zipestudio.talkingheads.utils.interfaces.ResizableModelPart;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelPart.class)
public abstract class ModelPartMixin implements ResizableModelPart {

    @Unique
    private double sizeX = 1;

    @Unique
    private double sizeY = 1;

    @Unique
    private double sizeZ = 1;

    @Override
    public void talkingHeads$setSize(double sizeX, double sizeY, double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    @Override
    public double talkingHeads$getSizeX() {
        return this.sizeX;
    }

    @Override
    public double talkingHeads$getSizeY() {
        return this.sizeY;
    }

    @Override
    public double talkingHeads$getSizeZ() {
        return this.sizeZ;
    }

    @Override
    public void talkingHeads$setDefaultSize() {
        this.sizeX = 1;
        this.sizeY = 1;
        this.sizeZ = 1;
    }

    //? if <1.21 {
    /*@Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V",
                    shift = At.Shift.AFTER))
    public void scaleHead(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, CallbackInfo ci) {

        double x = this.talkingHeads$getSizeX();
        double y = this.talkingHeads$getSizeY();
        double z = this.talkingHeads$getSizeZ();

        boolean xScale = x != this.talkingHeads$getDefaultSize();
        boolean yScale = y != this.talkingHeads$getDefaultSize();
        boolean zScale = z != this.talkingHeads$getDefaultSize();

        if (xScale || yScale || zScale) {
            matrices.scale((float) x, (float) y, (float) z);
        }

    }
    *///?} else {
    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;III)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V",
                    shift = At.Shift.AFTER))
    public void scaleHead(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color, CallbackInfo ci) {

        double x = this.talkingHeads$getSizeX();
        double y = this.talkingHeads$getSizeY();
        double z = this.talkingHeads$getSizeZ();

        boolean xScale = x != this.talkingHeads$getDefaultSize();
        boolean yScale = y != this.talkingHeads$getDefaultSize();
        boolean zScale = z != this.talkingHeads$getDefaultSize();

        if (xScale || yScale || zScale) {
            matrices.scale((float) x, (float) y, (float) z);
        }

    }
    //?}
}
