package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.effect.Bleeding;
import net.mercury.armory.enchantment.Drain;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryEffects {

	public static final StatusEffect BLEEDING = new Bleeding(StatusEffectType.HARMFUL, 11347750);

	public static void register() {

		registerEffect("bleeding", BLEEDING);

	}

	public static void registerEffect(String id, StatusEffect effect) {
		Registry.register(Registry.STATUS_EFFECT, new Identifier(ArmoryMod.ID, id), effect);
	}

}
