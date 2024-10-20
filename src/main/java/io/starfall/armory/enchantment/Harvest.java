package io.starfall.armory.enchantment;

import io.starfall.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class Harvest extends Enchantment {

	public Harvest() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

}
