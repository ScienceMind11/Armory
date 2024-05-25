package net.mercury.armory.effect;

import net.mercury.armory.registry.ArmoryDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class Bleeding extends StatusEffect {

	public Bleeding(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.damage(ArmoryDamageSource.of(entity.getWorld(), ArmoryDamageSource.BLEEDING), (amplifier / 3.0F));
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % 3 == 0;
	}

}
