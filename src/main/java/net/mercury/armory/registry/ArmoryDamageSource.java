package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ArmoryDamageSource {

	public static final RegistryKey<DamageType> BLEEDING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(ArmoryMod.ID, "bleeding"));

	public static DamageSource of(World world, RegistryKey<DamageType> key) {
		return new DamageSource(Holder.createDirect(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).get(key.getRegistry())));
	}

}
