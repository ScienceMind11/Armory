package net.mercury.armory;

import net.fabricmc.api.ModInitializer;

import net.mercury.armory.registry.ArmoryComponents;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class Armory implements ModInitializer {

	public static final String NAME = "Armory";
	public static final String ID = "armory";
	public static final Logger LOGGER = LogManager.getLogger(NAME);

	@Override
	public void onInitialize() {

		ArmoryComponents.register();
		ArmoryItems.register();

		LOGGER.info("Successfully initialized.");

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(ID, path);
	}

	public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registry, String path) {
		return ResourceKey.create(registry, id(path));
	}

}