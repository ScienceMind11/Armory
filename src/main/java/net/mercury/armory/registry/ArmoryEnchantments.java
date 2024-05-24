package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.enchantment.Drain;
import net.mercury.armory.enchantment.Rending;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryEnchantments {

	public static final Enchantment DRAIN = new Drain();
	public static final Enchantment RENDING = new Rending();

	public static void register() {

		registerEnchantment("drain", DRAIN);
		registerEnchantment("rending", RENDING);

	}

	public static void registerEnchantment(String id, Enchantment enchantment) {
		Registry.register(Registry.ENCHANTMENT, new Identifier(ArmoryMod.ID, id), enchantment);
	}

}
