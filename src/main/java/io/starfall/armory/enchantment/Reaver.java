package io.starfall.armory.enchantment;

import io.starfall.armory.item.ScytheItem;
import io.starfall.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class Reaver extends Enchantment {

	public Reaver() {
		super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity entity) {
			for(StatusEffectInstance effect : entity.getStatusEffects()) {

				user.addStatusEffect(
					new StatusEffectInstance(
						effect.getEffectType(),
						(int) (effect.getDuration() * 0.5F),
						effect.getAmplifier(),
						effect.isAmbient(),
						effect.shouldShowParticles(),
						effect.shouldShowIcon()
					)
				);

				entity.removeStatusEffect(effect.getEffectType());

			}
		}

		super.onTargetDamaged(user, target, level);
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ScytheItem;
	}

}
