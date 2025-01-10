package net.mercury.armory.effect;

import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class Bleeding extends StatusEffect {

    public Bleeding(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(ArmoryDamageTypes.source(ArmoryDamageTypes.BLEEDING), amplifier);
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }

}
