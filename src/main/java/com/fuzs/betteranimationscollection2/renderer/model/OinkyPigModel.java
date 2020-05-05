package com.fuzs.betteranimationscollection2.renderer.model;

import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class OinkyPigModel<T extends Entity> extends PigModel<T> {

    private final ModelRenderer snout;

    public OinkyPigModel() {
        this(6, 0.0F);
    }

    public OinkyPigModel(int height, float scale) {

        super(scale);
        // overwrite normal head as it already includes the snout
        this.headModel = new ModelRenderer(this, 0, 0);
        this.headModel.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, scale);
        this.headModel.setRotationPoint(0.0F, (float) (18 - height), -6.0F);

        this.snout = new ModelRenderer(this, 16, 16);
        this.snout.addBox(-2.0F, -3.0F, -1.0F, 4, 3, 1, scale);
        this.snout.setRotationPoint(0.0F, 3.0F, -8.0F);
        this.headModel.addChild(this.snout);
        //this.childYOffset = 4.0F;
    }

    /**
     * this only works because MobEntity#livingSoundTime is manually being synced to the client in {@link com.fuzs.betteranimationscollection2.handler.SoundSyncHandler}
     */
    @Override
    public void setLivingAnimations(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {

        if (entitylivingbaseIn instanceof MobEntity) {

            MobEntity entitylivingIn = (MobEntity) entitylivingbaseIn;
            int time = entitylivingIn.livingSoundTime + entitylivingIn.getTalkInterval();
            if (time > 8) {
                time = 0;
            }

            if (time > 0 && time < 8) {
                float rotate = MathHelper.sin((float) time * (float) (Math.PI / 8.0F));
                this.snout.rotationPointY = 3.0F - rotate;
            } else {
                this.snout.rotationPointY = 3.0F;
            }
        }
    }

}