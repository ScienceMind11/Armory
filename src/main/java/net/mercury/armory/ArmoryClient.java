package net.mercury.armory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mercury.armory.entity.ScytheEntityRenderer;
import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryParticles;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.client.particle.SweepAttackParticle;

import java.lang.reflect.Field;

public class ArmoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ArmoryWeaponSkins.register();

        ModelLoadingPlugin.register(context -> {

            context.addModels(ArmoryWeaponSkins.MODELS);

        });

        EntityRendererRegistry.register(ArmoryEntities.SCYTHE, ScytheEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ArmoryParticles.SILVER_SWEEP_ATTACK, SweepAttackParticle.Factory::new);

    }

}
