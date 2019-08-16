package com.fuzs.betteranimationscollection2.renderer.layer;

import com.fuzs.betteranimationscollection2.feature.FeatureEnderman;
import com.fuzs.betteranimationscollection2.renderer.render.RenderFlailingEnderman;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerFlailingHeldBlock implements LayerRenderer<EntityEnderman>
{
    private final RenderFlailingEnderman endermanRenderer;

    public LayerFlailingHeldBlock(RenderFlailingEnderman endermanRendererIn)
    {
        this.endermanRenderer = endermanRendererIn;
    }

    public void doRenderLayer(EntityEnderman entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        IBlockState iblockstate = entitylivingbaseIn.getHeldBlockState();

        if (iblockstate != null)
        {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            float f = 0.0F;
            if (FeatureEnderman.whileCarrying && entitylivingbaseIn.isScreaming()) {
                float f1 = (float) FeatureEnderman.speed * 0.025F;
                f = MathHelper.cos(ageInTicks * f1 * 5 + (float) 13 * 0.45F) * ((float) (13 + 8) / 8.0F) * f1;
            }
            GlStateManager.translate(-2.0F * f, 0.6875F, -0.75F);
            GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.25F, 0.1875F, 0.25F);
            GlStateManager.scale(-0.5F, -0.5F, 0.5F);
            int i = entitylivingbaseIn.getBrightnessForRender(partialTicks);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.endermanRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            blockrendererdispatcher.renderBlockBrightness(iblockstate, 1.0F);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}