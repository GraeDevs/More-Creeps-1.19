package net.graedevs.morecreeps.Client.models;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelHolder {
    public static final ModelLayerLocation BLORP = new ModelLayerLocation(new ResourceLocation(MoreCreeps.MODID, "blorp"), "main");

    public static void init() {
    }
}
