package net.graedevs.morecreeps.Common.init;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.graedevs.morecreeps.Common.entity.BlorpEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MoreCreeps.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreepsEntityHandler {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoreCreeps.MODID);
    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        return (EntityType) builder.build(entityName);
    }
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static final RegistryObject<EntityType<BlorpEntity>> BLORP = ENTITY_TYPES.register("blorp",
            () -> registerEntity(EntityType.Builder.of(BlorpEntity::new, MobCategory.CREATURE).sized(1.5F, 1.5F), "blorp"));

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CreepsEntityHandler.BLORP.get(), BlorpEntity.createAttributes().build());
    }

}
