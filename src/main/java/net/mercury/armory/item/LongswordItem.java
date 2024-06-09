package net.mercury.armory.item;

import net.mercury.armory.ArmoryMod;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class LongswordItem extends SwordItem {

	private final Identifier handModel;

	public LongswordItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, 8, -3.3F, new QuiltItemSettings().group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	public LongswordItem(ToolMaterial toolMaterial, String handModelResourceLocation, Settings settings) {
		super(toolMaterial, 8, -3.3F, settings.group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	@ClientOnly
	public ModelIdentifier getHeldModel() {
		return new ModelIdentifier(handModel, "inventory");
	}
}
