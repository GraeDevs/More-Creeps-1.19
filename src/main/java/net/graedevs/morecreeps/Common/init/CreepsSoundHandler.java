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

    /*Items*/
    public static final RegistryObject<SoundEvent> BANDAID_SOUND =
            registerSoundEvents("bandaid");
    public static final RegistryObject<SoundEvent> BLORPCOLA =
            registerSoundEvents("blorpcola");

    /*Entities*/
    public static final RegistryObject<SoundEvent> BLORPSOUND =
            registerSoundEvents("blorp1");
    public static final RegistryObject<SoundEvent> BLORPSOUND2 =
            registerSoundEvents("blorp2");
    public static final RegistryObject<SoundEvent> BLORPSOUND3 =
            registerSoundEvents("blorp3");
    public static final RegistryObject<SoundEvent> BLORPSOUND4 =
            registerSoundEvents("blorp4");
    public static final RegistryObject<SoundEvent> BLORPSOUND5 =
            registerSoundEvents("blorp5");
    public static final RegistryObject<SoundEvent> BLORPBOUNCE1 =
            registerSoundEvents("blorpbounce1");
    public static final RegistryObject<SoundEvent> BLORPHURT =
            registerSoundEvents("blorphurt1");
    public static final RegistryObject<SoundEvent> BLORPHURT2 =
            registerSoundEvents("blorphurt2");
    public static final RegistryObject<SoundEvent> BLORPGROW =
            registerSoundEvents("blorpgrow");
    public static final RegistryObject<SoundEvent> BLORPEAT =
            registerSoundEvents("blorpeat");
    public static final RegistryObject<SoundEvent> BLORPDEATH =
            registerSoundEvents("blorpdeath1");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MoreCreeps.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
