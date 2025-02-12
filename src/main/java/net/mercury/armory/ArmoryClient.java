package net.mercury.armory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mercury.armory.entity.ScytheEntityRenderer;
import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryParticles;
import net.minecraft.client.particle.SweepAttackParticle;

public class ArmoryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModelLoadingPlugin.register(context -> {

            context.addModels(ArmoryItems.MODEL_IDS);

            context.addModels(Armory.id("item/hand/devilsknife"), Armory.id("item/devilsknife"));

        });

        Armory.LOGGER.info("Register entity renderer");
        EntityRendererRegistry.register(ArmoryEntities.SCYTHE, ScytheEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ArmoryParticles.SILVER_SWEEP_ATTACK, SweepAttackParticle.Factory::new);

    }

}
