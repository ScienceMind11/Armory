package net.mercury.armory.item;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class DaggerItem extends SwordItem {

    public DaggerItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                fireproof ? new Item.Settings().fireproof() : new Item.Settings()
        );
    }

}
