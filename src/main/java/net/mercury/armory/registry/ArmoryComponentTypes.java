package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ArmoryComponentTypes {

    public static final ComponentType<WeaponSkin> WEAPON_SKIN_COMPONENT = ComponentType.<WeaponSkin>builder().codec(WeaponSkin.CODEC).packetCodec(WeaponSkin.PACKET_CODEC).build();

    public static void register() {
        registerComponent("weapon_skin", WEAPON_SKIN_COMPONENT);
    }

    public static void registerComponent(String name, ComponentType<?> component) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, Armory.id(name), component);
    }

}
