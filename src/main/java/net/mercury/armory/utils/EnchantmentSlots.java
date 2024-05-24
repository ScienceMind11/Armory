package net.mercury.armory.utils;

import net.minecraft.entity.EquipmentSlot;

public class EnchantmentSlots {

	public static EquipmentSlot[] eitherHand() {
		return new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND};
	}

	public static EquipmentSlot[] mainHand() {
		return new EquipmentSlot[] {EquipmentSlot.MAINHAND};
	}

	public static EquipmentSlot[] offHand() {
		return new EquipmentSlot[] {EquipmentSlot.OFFHAND};
	}

	public static EquipmentSlot[] armorAll() {
		return new EquipmentSlot[] {EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD};
	}

	public static EquipmentSlot[] helmet() {
		return new EquipmentSlot[] {EquipmentSlot.HEAD};
	}

	public static EquipmentSlot[] chestplate() {
		return new EquipmentSlot[] {EquipmentSlot.CHEST};
	}

	public static EquipmentSlot[] leggings() {
		return new EquipmentSlot[] {EquipmentSlot.LEGS};
	}

	public static EquipmentSlot[] boots() {
		return new EquipmentSlot[] {EquipmentSlot.FEET};
	}

}
