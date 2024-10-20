package io.starfall.armory.registry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class ArmoryDamageSource {

	public static final DamageSource BLEEDING = new DamageSource("bleeding").setBypassesArmor();

	public static DamageSource bleeding(LivingEntity attacker) {
		return new EntityDamageSource("bleeding", attacker);
	}

}
