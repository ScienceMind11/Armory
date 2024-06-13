package net.mercury.armory;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.item.ScytheItem;
import net.mercury.armory.networking.ArmoryConstants;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryParticles;
import net.minecraft.client.option.KeyBind;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

import javax.swing.text.JTextComponent;

public class ArmoryClient implements ClientModInitializer {

	private static KeyBind swapWeapon = KeyBindingHelper.registerKeyBinding(new KeyBind(
		"key.armory.swap",
		InputUtil.Type.KEYSYM,
		GLFW.GLFW_KEY_Y,
		"key.categories.misc"
	));

	@Override
	public void onInitializeClient(ModContainer mod) {

		ModelLoadingRegistry.INSTANCE.registerModelProvider((resources, out) -> {

			for(Item item : ArmoryItems.scythes) {
				assert item instanceof ScytheItem;
				out.accept(((ScytheItem) item).getHeldModel());
			}

			for(Item item : ArmoryItems.longswords) {
				assert item instanceof LongswordItem;
				out.accept(((LongswordItem) item).getHeldModel());
			}

		});

		ClientTickEvents.END.register(client -> {
			while(swapWeapon.wasPressed()) {

				PacketByteBuf packet = PacketByteBufs.create();
				packet.writeItemStack(client.player.getMainHandStack());

				ClientPlayNetworking.send(ArmoryConstants.SWAP_PACKET_ID, packet);
			}
		});

		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) -> {

			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_0"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_1"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_2"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_3"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_4"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_5"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_6"));
			registry.register(new Identifier(ArmoryMod.ID, "particle/golden_sweep_7"));

			registry.register(new Identifier(ArmoryMod.ID, "gui/mercury_longsword_name"));

		})));

		ParticleFactoryRegistry.getInstance().register(ArmoryParticles.GOLDEN_SWEEP_ATTACK, SweepAttackParticle.Factory::new);

	}

}
