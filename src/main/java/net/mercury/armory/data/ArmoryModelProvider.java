package net.mercury.armory.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.mercury.armory.Armory;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.ComponentMatches;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArmoryModelProvider extends FabricModelProvider {

    public static HashMap<Item, List<ItemModel.Unbaked>> skins;

    public ArmoryModelProvider(FabricPackOutput output) {
        super(output);
        skins = new HashMap<>();
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {

        generator.itemModelOutput.accept(
                Items.ANDESITE,
                ItemModelUtils.select(
                        new ComponentContents<Object>(),
                        ItemModelUtils.when()
                )
        );

    }

    public static void registerSkin(Item item, String suffix, ItemModelGenerators generator) {
        skins.getOrDefault(item, new ArrayList<>()).add(
                ItemModelUtils.plainModel(generator.createFlatItemModel(
                        item,
                        suffix,
                        ModelTemplates.FLAT_HANDHELD_ITEM
                )
        )
    }

}
