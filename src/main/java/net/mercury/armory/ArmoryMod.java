package net.mercury.armory;

import net.mercury.armory.item.MercuryClaymoreItem;
import net.mercury.armory.item.MercuryScytheItem;
import net.mercury.armory.networking.ArmoryConstants;
import net.mercury.armory.registry.ArmoryEffects;
import net.mercury.armory.registry.ArmoryEnchantments;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmoryMod implements ModInitializer {

	public static final String NAME = "Armory";
	public static final String ID = "armory";

	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize(ModContainer mod) {

		ArmoryItems.register();
		ArmoryEnchantments.register();
		ArmoryEffects.register();

		ServerPlayNetworking.registerGlobalReceiver(ArmoryConstants.SWAP_PACKET_ID, (server, player, handler, buf, responseSender) -> {

			ItemStack stack = buf.readItemStack();

			server.execute(() -> {

				if(stack.getItem() instanceof MercuryClaymoreItem) {

					ItemStack scythe = ArmoryItems.MERCURY_SCYTHE.getDefaultStack();
					scythe.setNbt(stack.getNbt());

					player.setStackInHand(Hand.MAIN_HAND, scythe);

				} else if(stack.getItem() instanceof MercuryScytheItem) {

					ItemStack sword = ArmoryItems.MERCURY_CLAYMORE.getDefaultStack();
					sword.setNbt(stack.getNbt());

					player.setStackInHand(Hand.MAIN_HAND, sword);

				}

			});

		});

	}

}
