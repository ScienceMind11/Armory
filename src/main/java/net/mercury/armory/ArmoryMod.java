package net.mercury.armory;

import net.mercury.armory.registry.ArmoryEffects;
import net.mercury.armory.registry.ArmoryEnchantments;
import net.mercury.armory.registry.ArmoryItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmoryMod implements ModInitializer {

	public static final String NAME = "Armory";
	public static final String ID = "armory";

	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize(ModContainer mod) {

		ArmoryItems.register();
		ArmoryEnchantments.register();
		ArmoryEffects.register();

	}

}
