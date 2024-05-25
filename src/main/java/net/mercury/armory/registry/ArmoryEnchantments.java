package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.enchantment.Drain;
import net.mercury.armory.enchantment.Reaping;
import net.mercury.armory.enchantment.Rending;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ArmoryEnchantments {

	public static final Enchantment DRAIN = new Drain();
	public static final Enchantment RENDING = new Rending();
	public static final Enchantment REAPING = new Reaping();

	public static void register() {

		registerEnchantment("drain", DRAIN);
		registerEnchantment("rending", RENDING);
		registerEnchantment("reaping", REAPING);

	}

	public static void registerEnchantment(String id, Enchantment enchantment) {
		Registry.register(Registries.ENCHANTMENT, new Identifier(ArmoryMod.ID, id), enchantment);
	}

}
