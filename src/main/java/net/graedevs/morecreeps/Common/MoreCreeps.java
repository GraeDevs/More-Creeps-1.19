package net.graedevs.morecreeps.Common;

import com.mojang.logging.LogUtils;
import net.graedevs.morecreeps.Common.init.CreepsItemHandler;
import net.graedevs.morecreeps.Common.init.CreepsSoundHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MoreCreeps.MODID)
public class MoreCreeps
{
    public static final String MODID = "morecreeps";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static CreativeModeTab CREEPSTAB = new CreativeModeTab("morecreeps") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CreepsItemHandler.A_FLOOB.get());
        }
    };

    public MoreCreeps()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        CreepsItemHandler.register(modEventBus);
        CreepsSoundHandler.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
