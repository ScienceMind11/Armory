package net.mercury.armory.registry;

import net.mercury.armory.Armory;
import net.mercury.armory.item.ScytheItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ArmoryItems {

    public static final Item SCYTHE = registerItem("scythe", ScytheItem::new);

    public static void register() {



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
