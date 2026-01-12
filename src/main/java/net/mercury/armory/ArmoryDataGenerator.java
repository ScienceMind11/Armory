package net.mercury.armory;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mercury.armory.data.ArmoryModelProvider;

public class ArmoryDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {

		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(ArmoryModelProvider::new);

	}

}
