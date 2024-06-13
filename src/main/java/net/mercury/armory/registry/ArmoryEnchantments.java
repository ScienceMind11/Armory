package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.enchantment.Drain;
import net.mercury.armory.enchantment.Reaping;
import net.mercury.armory.enchantment.Rending;
import net.mercury.armory.enchantment.Step;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryEnchantments {

	public static final Enchantment DRAIN = new Drain();
	public static final Enchantment RENDING = new Rending();
	public static final Enchantment REAPING = new Reaping();

	public static final Enchantment STEP = new Step();

	public static void register() {

		registerEnchantment("drain", DRAIN);
		registerEnchantment("rending", RENDING);
		registerEnchantment("reaping", REAPING);

		registerEnchantment("step", STEP);

	}

	public static void registerEnchantment(String id, Enchantment enchantment) {
		Registry.register(Registry.ENCHANTMENT, new Identifier(ArmoryMod.ID, id), enchantment);
	}

}
