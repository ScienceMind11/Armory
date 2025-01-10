package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ArmoryDamageTypes {

    public static final RegistryKey<DamageType> BLEEDING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Armory.id("bleeding"));

    public static DamageSource source(RegistryKey<DamageType> type) {
        return new DamageSource(MinecraftClient.getInstance().world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(type));
    }

}
