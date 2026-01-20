package net.mercury.armory.item;

import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Weapon;

public class ScytheItem extends Item {

    public ScytheItem(Properties properties) {
        super(properties
                .stacksTo(1)
                .fireResistant()
                .component(ArmoryComponents.WEAPON_SKIN, Armory.id("default"))
                .component(DataComponents.WEAPON, new Weapon(11, 1.0F))
        );
    }

}
