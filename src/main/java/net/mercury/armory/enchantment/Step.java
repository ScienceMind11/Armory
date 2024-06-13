package net.mercury.armory.enchantment;

import net.mercury.armory.item.MercuryClaymoreItem;
import net.mercury.armory.item.MercuryScytheItem;
import net.mercury.armory.utils.EnchantmentSlots;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;

public class Step extends Enchantment {

	public Step() {
		super(Rarity.RARE, EnchantmentTarget.WEAPON, EnchantmentSlots.mainHand());
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof MercuryClaymoreItem || stack.getItem() instanceof MercuryScytheItem;
	}

}
