package net.mercury.armory;

import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.item.ScytheItem;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.item.Item;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ArmoryClient implements ClientModInitializer {

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

	}

}
