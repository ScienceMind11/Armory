package net.mercury.armory.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.mercury.armory.Armory;
import net.mercury.armory.item.GlaiveItem;
import net.mercury.armory.item.ScytheItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ArmoryItems {

    public static final Item GLAIVE = registerItem("glaive", GlaiveItem::new);
    public static final Item SCYTHE = registerItem("scythe", ScytheItem::new);

    public static void register() {

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.insertAfter(Items.NETHERITE_AXE, ArmoryItems.SCYTHE);
        });

    }

    public static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        ResourceKey<Item> key = Armory.key(Registries.ITEM, name);
        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                factory.apply(new Item.Properties().setId(key))
        );
    }

}
