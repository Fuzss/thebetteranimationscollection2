package com.fuzs.betteranimationscollection2.feature;

import com.fuzs.betteranimationscollection2.helper.ConfigPropHelper;
import com.fuzs.betteranimationscollection2.renderer.render.RenderFlailingEnderman;
import net.minecraft.entity.monster.EntityEnderman;

public class FeatureEnderman extends Feature {

    public static int speed;
    public static boolean whileCarrying;

    public FeatureEnderman() {
        super(EntityEnderman.class, RenderFlailingEnderman::new);
    }

    @Override
    public String getName() {
        return "enderman";
    }

    @Override
    protected String getDescription() {
        return "If an enderman is angry it will wave its arms around wildly while chasing its target. Suits their twisted nature very well.";
    }

    @Override
    public void setupConfig() {
        super.setupConfig();
        speed = ConfigPropHelper.loadPropInt("animation swing", this.getCategory(), 5, "Animation swing of the arms.", 1, 20, false);
        whileCarrying = ConfigPropHelper.loadPropBoolean("while carrying", this.getCategory(), true, "Flail arms while carrying a block.", false);
    }

}
