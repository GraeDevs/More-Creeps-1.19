package net.graedevs.morecreeps.Common.init;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.graedevs.morecreeps.Common.item.BandaidItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreepsItemHandler {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreCreeps.MODID);

    /* Items */
    public static final RegistryObject<Item> BANDAID = ITEMS.register("bandaid",
            () -> new BandaidItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(24)));

    /* Achievements*/
    public static final RegistryObject<Item> A_FLOOB = ITEMS.register("a_floob",
            () -> new Item(new Item.Properties().tab(MoreCreeps.CREEPSTAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
