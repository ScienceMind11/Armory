package net.mercury.armory.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.mercury.armory.ArmoryMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmoryParticles {

	public static final DefaultParticleType GOLDEN_SWEEP_ATTACK = Registry.register(Registry.PARTICLE_TYPE, new Identifier(ArmoryMod.ID, "golden_sweep_attack"), FabricParticleTypes.simple(true));

}
