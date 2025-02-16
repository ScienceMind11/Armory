package net.mercury.armory.item.unique;

import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class HalberdItem extends SwordItem {

    public HalberdItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 5, -3.0F).component(
                        ArmoryComponentTypes.WEAPON_SKIN_COMPONENT,
                        ArmoryWeaponSkins.DEFAULT_HALBERD
                ).rarity(Rarity.EPIC)
        );
    }

}
