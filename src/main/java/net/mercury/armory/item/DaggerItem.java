package net.mercury.armory.item;

import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class DaggerItem extends SwordItem {

    public DaggerItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 1, -0.4F)
        );
    }

}
