package net.mercury.armory.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryComponents;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.block.model.TextureSlots;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.conditional.ComponentMatches;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.lang.classfile.instruction.SwitchCase;
import java.util.*;
import java.util.function.BiFunction;

public class ArmoryModelProvider extends FabricModelProvider {

    private static final List<ItemDisplayContext> HANDHELD = List.of(
            ItemDisplayContext.FIRST_PERSON_LEFT_HAND,
            ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
            ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
            ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
            ItemDisplayContext.GROUND,
            ItemDisplayContext.HEAD
    );

    private static final List<ItemDisplayContext> GUI = List.of(
            ItemDisplayContext.GUI,
            ItemDisplayContext.FIXED,
            ItemDisplayContext.ON_SHELF
    );

    private static final ModelTemplate LARGE = itemModel("large", TextureSlot.LAYER0);

    public ArmoryModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {

        registerAllSkins(
                ArmoryItems.GLAIVE,
                generator,
                createSkin(Armory.id("default"))
        );

        registerAllSkins(
                ArmoryItems.SCYTHE,
                generator,
                createSkin(Armory.id("default")),
                createSkin(Armory.id("carmine")),
                createSkin(Armory.id("devilsknife"))
        );

    }

    @SafeVarargs
    private static void registerAllSkins(
            Item item,
            ItemModelGenerators generator,
            BiFunction<Item, ItemModelGenerators, WeaponSkin>... factories
    ) {

        List<WeaponSkin> skins = Arrays.stream(factories)
                .map(factory -> factory.apply(item, generator))
                .toList();

        List<SelectItemModel.SwitchCase<Identifier>> cases = new ArrayList<>();
        for (WeaponSkin skin : skins) {
            cases.add(ItemModelUtils.when(skin.id(), skin.model()));
        }

        generator.itemModelOutput.accept(
                item,
                ItemModelUtils.select(
                        new ComponentContents<>(ArmoryComponents.WEAPON_SKIN),
                        cases
                )
        );

    }

    private static BiFunction<Item, ItemModelGenerators, WeaponSkin> createSkin(Identifier skin) {
        return (item, generator) -> {
            ItemModel.Unbaked handheld = ItemModelUtils.plainModel(generator.createFlatItemModel(
                    item,
                    "/hand/" + skin.getPath(),
                    LARGE
            ));

            ItemModel.Unbaked gui = ItemModelUtils.plainModel(generator.createFlatItemModel(
                    item,
                    "/" + skin.getPath(),
                    ModelTemplates.FLAT_ITEM
            ));

            return new WeaponSkin(skin, ItemModelUtils.select(
                    new DisplayContext(),
                    ItemModelUtils.when(HANDHELD, handheld),
                    ItemModelUtils.when(GUI, gui)
            ));
        };
    }

    public static ModelTemplate itemModel(String parent, TextureSlot keys) {
        return new ModelTemplate(
                Optional.of(Armory.id("item/" + parent)),
                Optional.empty(),
                keys
        );
    }

}
