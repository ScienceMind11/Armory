package net.mercury.armory.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mercury.armory.Armory;
import net.mercury.armory.item.DaggerItem;
import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.item.unique.ScytheItem;
import net.mercury.armory.item.SeparateTransform;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.item.ToolMaterials.*;

public class ArmoryItems {

    public static final List<Identifier> MODEL_IDS = new ArrayList<>();

    public static final Item SCYTHE = new ScytheItem(NETHERITE, true);

    public static final Item WOODEN_DAGGER = new DaggerItem(WOOD, false);
    public static final Item STONE_DAGGER = new DaggerItem(STONE, false);
    public static final Item IRON_DAGGER = new DaggerItem(IRON, false);
    public static final Item GOLDEN_DAGGER = new DaggerItem(GOLD, false);
    public static final Item DIAMOND_DAGGER = new DaggerItem(DIAMOND, false);
    public static final Item NETHERITE_DAGGER = new DaggerItem(NETHERITE, true);

    public static final Item WOODEN_LONGSWORD = new LongswordItem(WOOD, false);
    public static final Item STONE_LONGSWORD = new LongswordItem(STONE, false);
    public static final Item IRON_LONGSWORD = new LongswordItem(IRON, false);
    public static final Item GOLDEN_LONGSWORD = new LongswordItem(GOLD, false);
    public static final Item DIAMOND_LONGSWORD = new LongswordItem(DIAMOND, false);
    public static final Item NETHERITE_LONGSWORD = new LongswordItem(NETHERITE, true);

    public static void register() {

        registerItem("scythe", SCYTHE, true);

        registerItem("wooden_dagger", WOODEN_DAGGER, false);
        registerItem("stone_dagger", STONE_DAGGER, false);
        registerItem("iron_dagger", IRON_DAGGER, false);
        registerItem("golden_dagger", GOLDEN_DAGGER, false);
        registerItem("diamond_dagger", DIAMOND_DAGGER, false);
        registerItem("netherite_dagger", NETHERITE_DAGGER, false);

        registerItem("wooden_longsword", WOODEN_LONGSWORD, false);
        registerItem("stone_longsword", STONE_LONGSWORD, false);
        registerItem("iron_longsword", IRON_LONGSWORD, false);
        registerItem("golden_longsword", GOLDEN_LONGSWORD, false);
        registerItem("diamond_longsword", DIAMOND_LONGSWORD, false);
        registerItem("netherite_longsword", NETHERITE_LONGSWORD, false);

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {

            entries.addAfter(
                    Items.NETHERITE_SWORD,
                    WOODEN_DAGGER,
                    STONE_DAGGER,
                    IRON_DAGGER,
                    GOLDEN_DAGGER,
                    DIAMOND_DAGGER,
                    NETHERITE_DAGGER
            );

        });

    }

    public static void registerItem(String name, Item item, boolean separateTransform) {
        if(separateTransform) MODEL_IDS.add(((SeparateTransform) item).getHeldModelIdentifier());
        Registry.register(Registries.ITEM, Armory.id(name), item);
    }

    public static Item.Settings getSettings(ToolMaterial material, boolean fireproof, int damage, float speed) {
        Item.Settings settings = new Item.Settings();

        if(fireproof) settings.fireproof();
        settings.attributeModifiers(SwordItem.createAttributeModifiers(material, damage, speed));

        return settings;
    }

}
