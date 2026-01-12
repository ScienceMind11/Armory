package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ArmoryComponents {

    public static final DataComponentType<Identifier> WEAPON_SKIN = DataComponentType.<Identifier>builder()
            .persistent(Identifier.CODEC.fieldOf("skin").codec())
            .build();

    public static void register() {
        registerComponent("weapon_skin", WEAPON_SKIN);
    }

    public static <T> void registerComponent(String name, DataComponentType<T> type) {
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Armory.id(name), type);
    }

}
