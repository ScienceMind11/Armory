package net.mercury.armory;

import net.fabricmc.api.ModInitializer;
import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmorySounds;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Armory implements ModInitializer {

    public static final String NAME = "Armory";
    public static final String ID = "armory";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @Override
    public void onInitialize() {

        ArmoryComponentTypes.register();
        ArmoryEntities.register();
        ArmoryItems.register();
        ArmorySounds.register();

        LOGGER.info("Successfully loaded");

    }

    public static Identifier id(String path) {
        return Identifier.of(ID, path);
    }

}
