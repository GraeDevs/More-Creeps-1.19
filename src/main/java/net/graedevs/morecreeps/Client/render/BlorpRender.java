package net.graedevs.morecreeps.Client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.graedevs.morecreeps.Client.models.BlorpModel;
import net.graedevs.morecreeps.Client.models.ModelHolder;
import net.graedevs.morecreeps.Common.MoreCreeps;
import net.graedevs.morecreeps.Common.entity.BlorpEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class BlorpRender extends MobRenderer<BlorpEntity, BlorpModel> {
    public BlorpRender(@Nonnull EntityRendererProvider.Context context) {
        super(context, new BlorpModel(context.bakeLayer(ModelHolder.BLORP)), 0.5f);
    }

    protected void scale(BlorpEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.6f, 0.6f, 0.6f);
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull BlorpEntity entity) {
        return new ResourceLocation(MoreCreeps.MODID + ":textures/entity/blorp.png");
    }
}
