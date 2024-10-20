package io.starfall.armory.registry;

import io.starfall.armory.enchantment.*;
import io.starfall.armory.ArmoryMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryEnchantments {

	public static final Enchantment DRAIN = new Drain();
	public static final Enchantment RENDING = new Rending();
	public static final Enchantment REAPING = new Reaping();
	public static final Enchantment TOSS = new Toss();
	public static final Enchantment CLEAVING = new Cleaving();
	public static final Enchantment REAVER = new Reaver();
	public static final Enchantment HARVEST = new Harvest();
	public static final Enchantment TRICKSTER = new Trickster();

	public static void register() {

		registerEnchantment("drain", DRAIN);
		registerEnchantment("rending", RENDING);
		registerEnchantment("reaping", REAPING);
		registerEnchantment("toss", TOSS);
		registerEnchantment("cleaving", CLEAVING);
		registerEnchantment("reaver", REAVER);

	}

	public static void registerEnchantment(String id, Enchantment enchantment) {
		Registry.register(Registry.ENCHANTMENT, new Identifier(ArmoryMod.ID, id), enchantment);
	}

}
