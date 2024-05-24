package net.mercury.armory.enchantment;

import net.mercury.armory.item.ScytheItem;
import net.mercury.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class Reaping extends Enchantment {

	public Reaping() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ScytheItem;
	}

	@Override
	protected boolean canAccept(Enchantment other) {
		return !(other == Enchantments.KNOCKBACK);
	}

}
