package net.mercury.armory.item;

import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryComponents;
import net.minecraft.world.item.Item;

public class GlaiveItem extends Item {

    public GlaiveItem(Properties properties) {
        super(properties
                .component(ArmoryComponents.WEAPON_SKIN, Armory.id("default"))
        );
    }

}
