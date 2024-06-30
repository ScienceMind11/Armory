package net.mercury.armory;

import net.mercury.armory.entity.ThrownScytheEntity;
import net.mercury.armory.registry.ArmoryEffects;
import net.mercury.armory.registry.ArmoryEnchantments;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmoryMod implements ModInitializer {

	public static final String NAME = "Armory";
	public static final String ID = NAME.toLowerCase();
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final EntityType<ThrownScytheEntity> SCYTHE =
		Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ArmoryMod.ID, "scythe"),
			QuiltEntityTypeBuilder.create(SpawnGroup.MISC, ThrownScytheEntity::new).setDimensions(EntityDimensions.changing(0.25F, 0.25F)).build()
		)
	;

	@Override
	public void onInitialize(ModContainer mod) {

		ArmoryItems.register();
		ArmoryEnchantments.register();
		ArmoryEffects.register();

	}

}
