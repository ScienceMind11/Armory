package io.starfall.armory.effect;

import io.starfall.armory.registry.ArmoryDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class Bleeding extends StatusEffect {

	public Bleeding(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.damage(ArmoryDamageSource.BLEEDING, amplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % 20 == 0;
	}

}
