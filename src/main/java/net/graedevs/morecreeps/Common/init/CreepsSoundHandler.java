package net.graedevs.morecreeps.Common.init;

import net.graedevs.morecreeps.Common.MoreCreeps;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreepsSoundHandler {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MoreCreeps.MODID);

    public static final RegistryObject<SoundEvent> BANDAID_SOUND =
            registerSoundEvents("bandaid");

    public static final RegistryObject<SoundEvent> BLORPCOLA =
            registerSoundEvents("blorpcola");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MoreCreeps.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
