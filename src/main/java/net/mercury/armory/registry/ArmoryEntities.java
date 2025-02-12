package net.mercury.armory.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mercury.armory.Armory;
import net.mercury.armory.entity.ScytheEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ArmoryEntities {

    public static final EntityType<ScytheEntity> SCYTHE = entity(
            ScytheEntity::new,
            "scythe",
            SpawnGroup.MISC,
            1.0F, 1.0F,
            true
    );

    public static void register() {

        registerEntity("scythe", SCYTHE);

    }

    public static void registerEntity(String name, EntityType<?> entityType) {
        Registry.register(Registries.ENTITY_TYPE, Armory.id(name), entityType);
    }

    public static <T extends Entity> EntityType<T> entity(EntityType.EntityFactory<T> factory, String name, SpawnGroup group, float width, float height, boolean fireImmune) {

        EntityType.Builder<T> builder = EntityType.Builder.create(factory, group);
        if(fireImmune) builder.makeFireImmune();
        builder.dimensions(width, height);

        return builder.build(name);

    }

}
