package net.mercury.armory.item;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class DaggerItem extends SwordItem {

    public DaggerItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                fireproof ? new Item.Settings().fireproof() : new Item.Settings()
        );
    }

}
