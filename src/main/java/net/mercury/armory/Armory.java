package net.mercury.armory;

import net.fabricmc.api.ModInitializer;
import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Armory implements ModInitializer {

    public static final String NAME = "Armory";
    public static final String ID = "armory";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {

        ArmoryItems.register();
        ArmoryEntities.register();

        LOGGER.info("Successfully loaded");

    }

    public static Identifier id(String path) {
        return Identifier.of(ID, path);
    }

}
