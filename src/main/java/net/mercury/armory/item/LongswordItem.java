package net.mercury.armory.item;

import net.mercury.armory.ArmoryMod;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class LongswordItem extends SwordItem {

	private final ModelIdentifier handModel;

	public LongswordItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, 8, -3.4F, new QuiltItemSettings());
		handModel = new ModelIdentifier(ArmoryMod.ID, handModelResourceLocation, "inventory");
	}

	public LongswordItem(ToolMaterial toolMaterial, String handModelResourceLocation, Settings settings) {
		super(toolMaterial, 8, -3.4F, settings);
		handModel = new ModelIdentifier(ArmoryMod.ID, handModelResourceLocation, "inventory");
	}

	public ModelIdentifier getHeldModel() {
		return handModel;
	}

}
