package net.mercury.armory.registry;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.ArrayList;
import java.util.List;

public class ArmoryItems {

	public static List<Item> scythes = new ArrayList<>();
	public static List<Item> longswords = new ArrayList<>();

	public static final Item WOODEN_SCYTHE = new ScytheItem(ToolMaterials.WOOD, "wooden_scythe_hand");
	public static final Item STONE_SCYTHE = new ScytheItem(ToolMaterials.STONE, "stone_scythe_hand");
	public static final Item IRON_SCYTHE = new ScytheItem(ToolMaterials.IRON, "iron_scythe_hand");
	public static final Item GOLDEN_SCYTHE = new ScytheItem(ToolMaterials.GOLD, "golden_scythe_hand");
	public static final Item DIAMOND_SCYTHE = new ScytheItem(ToolMaterials.DIAMOND, "diamond_scythe_hand");
	public static final Item NETHERITE_SCYTHE = new ScytheItem(ToolMaterials.NETHERITE, "netherite_scythe_hand", new QuiltItemSettings().fireproof());

	public static final Item WOODEN_LONGSWORD = new LongswordItem(ToolMaterials.WOOD, "wooden_longsword_hand");
	public static final Item STONE_LONGSWORD = new LongswordItem(ToolMaterials.STONE, "stone_longsword_hand");
	public static final Item IRON_LONGSWORD = new LongswordItem(ToolMaterials.IRON, "iron_longsword_hand");
	public static final Item GOLDEN_LONGSWORD = new LongswordItem(ToolMaterials.GOLD, "golden_longsword_hand");
	public static final Item DIAMOND_LONGSWORD = new LongswordItem(ToolMaterials.DIAMOND, "diamond_longsword_hand");
	public static final Item NETHERITE_LONGSWORD = new LongswordItem(ToolMaterials.NETHERITE, "netherite_longsword_hand", new QuiltItemSettings().fireproof());

	public static final Item WOODEN_DAGGER = new DaggerItem(ToolMaterials.WOOD);
	public static final Item STONE_DAGGER = new DaggerItem(ToolMaterials.STONE);
	public static final Item IRON_DAGGER = new DaggerItem(ToolMaterials.IRON);
	public static final Item GOLDEN_DAGGER = new DaggerItem(ToolMaterials.GOLD);
	public static final Item DIAMOND_DAGGER = new DaggerItem(ToolMaterials.DIAMOND);
	public static final Item NETHERITE_DAGGER = new DaggerItem(ToolMaterials.NETHERITE, new QuiltItemSettings().fireproof());

	public static final Item MERCURY_SCYTHE = new MercuryScytheItem(ToolMaterials.NETHERITE, "mercury_scythe_hand");
	public static final Item MERCURY_CLAYMORE = new MercuryClaymoreItem(ToolMaterials.NETHERITE, "mercury_claymore_hand");

	public static final Item MERCURIAL_CRYSTAL = new Item(new QuiltItemSettings().group(ItemGroup.MATERIALS));

	public static void register() {

		scythes.add(registerItem("wooden_scythe", WOODEN_SCYTHE));
		scythes.add(registerItem("stone_scythe", STONE_SCYTHE));
		scythes.add(registerItem("iron_scythe", IRON_SCYTHE));
		scythes.add(registerItem("golden_scythe", GOLDEN_SCYTHE));
		scythes.add(registerItem("diamond_scythe", DIAMOND_SCYTHE));
		scythes.add(registerItem("netherite_scythe", NETHERITE_SCYTHE));

		longswords.add(registerItem("wooden_longsword", WOODEN_LONGSWORD));
		longswords.add(registerItem("stone_longsword", STONE_LONGSWORD));
		longswords.add(registerItem("iron_longsword", IRON_LONGSWORD));
		longswords.add(registerItem("golden_longsword", GOLDEN_LONGSWORD));
		longswords.add(registerItem("diamond_longsword", DIAMOND_LONGSWORD));
		longswords.add(registerItem("netherite_longsword", NETHERITE_LONGSWORD));

		registerItem("wooden_dagger", WOODEN_DAGGER);
		registerItem("stone_dagger", STONE_DAGGER);
		registerItem("iron_dagger", IRON_DAGGER);
		registerItem("golden_dagger", GOLDEN_DAGGER);
		registerItem("diamond_dagger", DIAMOND_DAGGER);
		registerItem("netherite_dagger", NETHERITE_DAGGER);

		scythes.add(registerItem("mercury_scythe", MERCURY_SCYTHE));
		longswords.add(registerItem("mercury_claymore", MERCURY_CLAYMORE));

		registerItem("mercurial_crystal", MERCURIAL_CRYSTAL);

	}

	public static Item registerItem(String id, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(ArmoryMod.ID, id), item);
	}

}
