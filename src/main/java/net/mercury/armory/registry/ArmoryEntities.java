package net.mercury.armory.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mercury.armory.Armory;
import net.mercury.armory.entity.ScytheEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ArmoryEntities {

    public static final EntityType<ScytheEntity> SCYTHE = registerEntity(
            "scythe",
            SpawnGroup.MISC,
            1.0F, 1.0F,
            true
    );

    public static void register() {
        Armory.LOGGER.info("Registered scythe entity");
    }

    public static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup group, float width, float height, boolean fireImmune) {

        EntityType.Builder<T> builder = EntityType.Builder.create(group);
        if(fireImmune) builder.makeFireImmune();
        builder.dimensions(width, height);

        return Registry.register(Registries.ENTITY_TYPE, Armory.id(name), builder.build(name));

    }

}
