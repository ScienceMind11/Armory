package net.mercury.armory.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class DaggerItem extends SwordItem {

	public DaggerItem(ToolMaterial toolMaterial) {
		super(toolMaterial, 1, -1.3F, new QuiltItemSettings());
	}

	public DaggerItem(ToolMaterial toolMaterial, Settings settings) {
		super(toolMaterial, 1, -1.3F, settings);
	}

}
