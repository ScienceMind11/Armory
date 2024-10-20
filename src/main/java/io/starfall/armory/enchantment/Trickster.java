package io.starfall.armory.enchantment;

import io.starfall.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class Trickster extends Enchantment {

	public Trickster() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

}
