package io.starfall.armory.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import io.starfall.armory.ArmoryMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryParticles {

	public static final DefaultParticleType SILVER_SWEEP_ATTACK = Registry.register(Registry.PARTICLE_TYPE, new Identifier(ArmoryMod.ID, "silver_sweep"), FabricParticleTypes.simple(true));

}
