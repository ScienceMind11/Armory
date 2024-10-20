package io.starfall.armory;

import io.starfall.armory.entity.model.ThrownScytheEntityModel;
import io.starfall.armory.entity.model.renderer.ThrownScytheEntityRenderer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import io.starfall.armory.entity.model.DevilsknifeEntityModel;
import io.starfall.armory.item.LongswordItem;
import io.starfall.armory.item.ScytheItem;
import io.starfall.armory.registry.ArmoryItems;
import io.starfall.armory.registry.ArmoryParticles;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ArmoryClient implements ClientModInitializer {

	public static final ModelIdentifier DEVILSKNIFE = new ModelIdentifier(new Identifier(ArmoryMod.ID, "devilsknife"), "inventory");
	public static final ModelIdentifier DEVILSKNIFE_HAND = new ModelIdentifier(new Identifier(ArmoryMod.ID, "devilsknife_hand"), "inventory");

	@Override
	public void onInitializeClient(ModContainer mod) {

		ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> {

			out.accept(((ScytheItem) ArmoryItems.SCYTHE).getHeldModel());
			out.accept(DEVILSKNIFE);
			out.accept(DEVILSKNIFE_HAND);

			for(Item item : ArmoryItems.longswords) {
				assert item instanceof LongswordItem;
				out.accept(((LongswordItem) item).getHeldModel());
			}

		});

		EntityRendererRegistry.register(ArmoryMod.SCYTHE, ThrownScytheEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(
			new EntityModelLayer(new Identifier(ArmoryMod.ID, "scythe"), "main"),
			ThrownScytheEntityModel::getTexturedModelData
		);

		EntityModelLayerRegistry.registerModelLayer(
			new EntityModelLayer(new Identifier(ArmoryMod.ID, "devilsknife"), "main"),
			DevilsknifeEntityModel::getTexturedModelData
		);

		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {

			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep1"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep2"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep3"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep4"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep5"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep6"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep7"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/silver_sweep8"));

		});

		ParticleFactoryRegistry.getInstance().register(ArmoryParticles.SILVER_SWEEP_ATTACK, SweepAttackParticle.Factory::new);

	}

}
