package net.graedevs.morecreeps.Events.mod;

import net.graedevs.morecreeps.Client.models.BlorpModel;
import net.graedevs.morecreeps.Client.models.ModelHolder;
import net.graedevs.morecreeps.Client.render.BlorpRender;
import net.graedevs.morecreeps.Common.MoreCreeps;
import net.graedevs.morecreeps.Common.init.CreepsEntityHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoreCreeps.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        ModelHolder.init();
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CreepsEntityHandler.BLORP.get(), BlorpRender::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelHolder.BLORP, BlorpModel::createBodyLayer);
    }
}
