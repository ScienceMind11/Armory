package net.mercury.armory.enchantment;

import net.mercury.armory.item.ScytheItem;
import net.mercury.armory.registry.ArmoryEffects;
import net.mercury.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class Rending extends Enchantment {

	public Rending() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity attacked) {
			attacked.addStatusEffect(new StatusEffectInstance(ArmoryEffects.BLEEDING, 100, 2), user);
		}

		super.onTargetDamaged(user, target, level);

	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ScytheItem;
	}

}
