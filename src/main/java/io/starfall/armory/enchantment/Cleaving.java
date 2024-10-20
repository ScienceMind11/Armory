package io.starfall.armory.enchantment;

import io.starfall.armory.item.ScytheItem;
import io.starfall.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;

public class Cleaving extends Enchantment {

	public Cleaving() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ScytheItem;
	}

}
