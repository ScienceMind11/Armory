package net.mercury.armory.effect;

import net.mercury.armory.registry.ArmoryDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import org.quiltmc.loader.api.minecraft.DedicatedServerOnly;

public class Bleeding extends StatusEffect {

	public Bleeding(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.damage(ArmoryDamageSource.BLEEDING, 1.0F);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
