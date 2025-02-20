package net.mercury.armory.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mercury.armory.Armory;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ArmoryParticles {

    public static final SimpleParticleType SILVER_SWEEP_ATTACK = register("silver_sweep", true);

    public static SimpleParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, Armory.id(name), FabricParticleTypes.simple(alwaysShow));
    }

}
