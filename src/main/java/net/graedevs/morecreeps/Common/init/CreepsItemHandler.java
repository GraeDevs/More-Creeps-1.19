package net.graedevs.morecreeps.Common.init;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.graedevs.morecreeps.Common.item.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreepsItemHandler {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreCreeps.MODID);

    /* Achievements*/
    public static final RegistryObject<Item> A_FLOOB = ITEMS.register("a_floob",
            () -> new Item(new Item.Properties().tab(MoreCreeps.CREEPSTAB)));

    /* Items */
    public static final RegistryObject<Item> BANDAID = ITEMS.register("bandaid",
            () -> new BandaidItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(24)));
    public static final RegistryObject<Item> BLORPCOLA = ITEMS.register("blorpcola",
            () -> new BlorpcolaItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(24)));
    public static final RegistryObject<Item> LOLLY = ITEMS.register("lolly",
            () -> new LollyItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(32)));
    public static final RegistryObject<Item> POPSICLE = ITEMS.register("popsicle",
            () -> new PopsicleItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(32)));
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
            () -> new BatteryItem(new Item.Properties().tab(MoreCreeps.CREEPSTAB).stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
