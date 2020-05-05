package com.fuzs.betteranimationscollection2.feature;

import com.fuzs.betteranimationscollection2.feature.core.ModelFeature;
import com.fuzs.betteranimationscollection2.renderer.model.OinkyPigModel;
import net.minecraft.entity.passive.PigEntity;

public class PigFeature extends ModelFeature<PigEntity> {

    public PigFeature() {
        super(OinkyPigModel::new);
    }

    @Override
    public String getName() {
        return "pig";
    }

    @Override
    public String getDescription() {

        return "A very subtle animation, makes a pig's snout move when it oinks. It only moves up and down ever so " +
                "slightly, but it's there. Just a little bit more life for your livestock.";
    }

}