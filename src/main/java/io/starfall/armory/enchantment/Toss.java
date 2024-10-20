package io.starfall.armory.enchantment;

import io.starfall.armory.utils.EnchantmentSlots;
import io.starfall.armory.item.ScytheItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;

public class Toss extends Enchantment {

	public Toss() {
		super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ScytheItem;
	}

}

