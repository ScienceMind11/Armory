package net.mercury.armory.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class LongswordItem extends SwordItem {

    public LongswordItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 4, -2.7F)
        );
    }

}
