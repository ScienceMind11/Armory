package net.mercury.armory.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mercury.armory.Armory;
import net.mercury.armory.item.DaggerItem;
import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.item.unique.GlaiveItem;
import net.mercury.armory.item.unique.ScytheItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.item.ToolMaterials.*;

public class ArmoryItems {

    public static final List<Identifier> MODEL_IDS = new ArrayList<>();

    public static final Item SCYTHE = new ScytheItem(NETHERITE, true);
    public static final Item GLAIVE = new GlaiveItem(NETHERITE, true);
    public static final Item HALBERD = new Item(new Item.Settings());
    public static final Item GREATAXE = new Item(new Item.Settings());

    public static final Item WOODEN_DAGGER = new DaggerItem(WOOD, false);
    public static final Item STONE_DAGGER = new DaggerItem(STONE, false);
    public static final Item IRON_DAGGER = new DaggerItem(IRON, false);
    public static final Item GOLDEN_DAGGER = new DaggerItem(GOLD, false);
    public static final Item DIAMOND_DAGGER = new DaggerItem(DIAMOND, false);
    public static final Item NETHERITE_DAGGER = new DaggerItem(NETHERITE, true);

    public static final Item WOODEN_LONGSWORD = new LongswordItem(WOOD, false, "item/hand/wooden_longsword");
    public static final Item STONE_LONGSWORD = new LongswordItem(STONE, false, "item/hand/stone_longsword");
    public static final Item IRON_LONGSWORD = new LongswordItem(IRON, false, "item/hand/iron_longsword");
    public static final Item GOLDEN_LONGSWORD = new LongswordItem(GOLD, false, "item/hand/golden_longsword");
    public static final Item DIAMOND_LONGSWORD = new LongswordItem(DIAMOND, false, "item/hand/diamond_longsword");
    public static final Item NETHERITE_LONGSWORD = new LongswordItem(NETHERITE, true, "item/hand/netherite_longsword");

    public static void register() {

        registerItem("scythe", SCYTHE);
        registerItem("glaive", GLAIVE);
        registerItem("halberd", HALBERD);
        registerItem("greataxe", GREATAXE);

        registerItem("wooden_dagger", WOODEN_DAGGER);
        registerItem("stone_dagger", STONE_DAGGER);
        registerItem("iron_dagger", IRON_DAGGER);
        registerItem("golden_dagger", GOLDEN_DAGGER);
        registerItem("diamond_dagger", DIAMOND_DAGGER);
        registerItem("netherite_dagger", NETHERITE_DAGGER);

        registerItem("wooden_longsword", WOODEN_LONGSWORD);
        registerItem("stone_longsword", STONE_LONGSWORD);
        registerItem("iron_longsword", IRON_LONGSWORD);
        registerItem("golden_longsword", GOLDEN_LONGSWORD);
        registerItem("diamond_longsword", DIAMOND_LONGSWORD);
        registerItem("netherite_longsword", NETHERITE_LONGSWORD);

        // Register additional models for the longswords
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) WOODEN_LONGSWORD).getHeldModel());
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) STONE_LONGSWORD).getHeldModel());
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) IRON_LONGSWORD).getHeldModel());
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) GOLDEN_LONGSWORD).getHeldModel());
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) DIAMOND_LONGSWORD).getHeldModel());
        ArmoryWeaponSkins.MODELS.add(((LongswordItem) NETHERITE_LONGSWORD).getHeldModel());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {

            entries.addBefore(
                    Items.WOODEN_SWORD,
                    WOODEN_DAGGER,
                    STONE_DAGGER,
                    IRON_DAGGER,
                    GOLDEN_DAGGER,
                    DIAMOND_DAGGER,
                    NETHERITE_DAGGER
            );

            entries.addAfter(
                    Items.NETHERITE_AXE,
                    WOODEN_LONGSWORD,
                    STONE_LONGSWORD,
                    IRON_LONGSWORD,
                    GOLDEN_LONGSWORD,
                    DIAMOND_LONGSWORD,
                    NETHERITE_LONGSWORD
            );

            entries.addAfter(
                    Items.MACE,
                    SCYTHE,
                    GLAIVE/*,
                    HALBERD,
                    GREATAXE*/
            );

        });

    }

    public static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, Armory.id(name), item);
    }

    public static Item.Settings getSettings(ToolMaterial material, boolean fireproof, int damage, float speed) {
        Item.Settings settings = new Item.Settings();

        if(fireproof) settings.fireproof();
        settings.attributeModifiers(SwordItem.createAttributeModifiers(material, damage, speed));

        return settings;
    }

//    public static Item.Settings getSettings(ToolMaterial material, boolean fireproof, int damage, float speed, float reach) {
//        Item.Settings settings = new Item.Settings();
//
//        if(fireproof) settings.fireproof();
//        settings.attributeModifiers(
//                SwordItem.createAttributeModifiers(material, damage, speed).with(
//                        RegistryEntry.of(ReachEntityAttributes.ATTACK_RANGE),
//                        new EntityAttributeModifier(Armory.id("attack_range"), reach, EntityAttributeModifier.Operation.ADD_VALUE),
//                        AttributeModifierSlot.MAINHAND
//                )
//        );
//
//        return settings;
//    }

}
