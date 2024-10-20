package io.starfall.armory.enchantment;

import io.starfall.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;

public class Drain extends Enchantment {

	public Drain() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {

		if(target instanceof LivingEntity attacked) {

			int armor = attacked.getArmor();
			double toughness = attacked.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS);
			double damage = user.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);

			user.heal(0.1F * (level / 2.0F) * DamageUtil.getDamageLeft((float) damage, (float) armor, (float) toughness));

		}

		super.onTargetDamaged(user, target, level);

	}

}
