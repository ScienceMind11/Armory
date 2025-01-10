package net.mercury.armory.registry;

import com.mojang.serialization.Codec;
import net.mercury.armory.Armory;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ArmoryComponentTypes {

    public static final ComponentType<Boolean> DEVILSKNIFE = ComponentType.<Boolean>builder().codec(Codec.BOOL).build();

    public static void register() {
        registerComponent("devilsknife", DEVILSKNIFE);
    }

    public static void registerComponent(String name, ComponentType<?> component) {
        Registry.register(Registries.DATA_COMPONENT_TYPE, Armory.id(name), component);
    }

}
