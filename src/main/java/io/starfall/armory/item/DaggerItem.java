package io.starfall.armory.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class DaggerItem extends SwordItem {

	public DaggerItem(ToolMaterial toolMaterial) {
		super(toolMaterial, 1, -2.1F, new QuiltItemSettings().group(ItemGroup.COMBAT));
	}

	public DaggerItem(ToolMaterial toolMaterial, Settings settings) {
		super(toolMaterial, 1, -2.1F, settings.group(ItemGroup.COMBAT));
	}

}
