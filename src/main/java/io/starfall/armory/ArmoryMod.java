package io.starfall.armory;

import io.starfall.armory.entity.ThrownScytheEntity;
import io.starfall.armory.registry.ArmoryEffects;
import io.starfall.armory.registry.ArmoryEnchantments;
import io.starfall.armory.registry.ArmoryItems;
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

	public static final EntityType<ThrownScytheEntity> SCYTHE = registerEntity(
		"scythe",
		SpawnGroup.MISC,
		ThrownScytheEntity::new,
		EntityDimensions.changing(1.0F, 1.0F),
		true
	);

	@Override
	public void onInitialize(ModContainer mod) {

		ArmoryItems.register();
		ArmoryEnchantments.register();
		ArmoryEffects.register();

	}

	private static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup group, EntityType.EntityFactory<T> factory, EntityDimensions dimensions, boolean fireImmune) {
		QuiltEntityTypeBuilder<T> builder = QuiltEntityTypeBuilder.create(group, factory).setDimensions(dimensions);
		if (fireImmune) {
			builder = builder.makeFireImmune();
		}
		return Registry.register(Registry.ENTITY_TYPE, new Identifier(ID, name),
			builder.build());
	}

}
