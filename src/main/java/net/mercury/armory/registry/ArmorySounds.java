package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ArmorySounds {

    public static final SoundEvent SCYTHE_HIT = SoundEvent.of(Armory.id("scythe"));

    public static void register() {
        registerSound("scythe", SCYTHE_HIT);
    }

    public static void registerSound(String name, SoundEvent event) {
        Registry.register(Registries.SOUND_EVENT, Armory.id(name), event);
    }

}
