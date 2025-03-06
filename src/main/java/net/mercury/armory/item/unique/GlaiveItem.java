package net.mercury.armory.item.unique;

import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class GlaiveItem extends SwordItem{

    public GlaiveItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 6, -3.0F, 1.0F).component(
                        ArmoryComponentTypes.WEAPON_SKIN_COMPONENT,
                        ArmoryWeaponSkins.DEFAULT_GLAIVE
                ).rarity(Rarity.EPIC)
        );
    }

}
