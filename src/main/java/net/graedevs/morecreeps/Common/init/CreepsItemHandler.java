package net.graedevs.morecreeps.Common.init;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreepsItemHandler {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreCreeps.MODID);

    public static final RegistryObject<Item> A_FLOOB = ITEMS.register("a_floob",
            () -> new Item(new Item.Properties().tab(MoreCreeps.CREEPSTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
