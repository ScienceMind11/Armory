package net.mercury.armory.data;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ArmoryLangProvider extends FabricLanguageProvider {

    public ArmoryLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {

        builder.add(ArmoryItems.SCYTHE, "Scythe");
        builder.add(ArmoryItems.GLAIVE, "Glaive");

    }

}
