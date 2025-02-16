package net.mercury.armory.mixin;

import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Unique
    private static final List<ModelTransformationMode> MODES = List.of(
            ModelTransformationMode.GROUND,
            ModelTransformationMode.GUI,
            ModelTransformationMode.FIXED
    );

    @Shadow @Final private ItemModels models;

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
    private BakedModel armory$separateTransforms(BakedModel model, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {

        if(!stack.getComponents().contains(ArmoryComponentTypes.WEAPON_SKIN_COMPONENT) && !(stack.getItem() instanceof LongswordItem)) return model;

        if(stack.getItem() instanceof LongswordItem item) {
            if(MODES.contains(renderMode)) return model;
            return models.getModelManager().getModel(item.getHeldModel());
        }

        WeaponSkin skin = stack.getComponents().get(ArmoryComponentTypes.WEAPON_SKIN_COMPONENT);
        Identifier modelId = MODES.contains(renderMode) ? skin.guiModel() : skin.handModel();

        return models.getModelManager().getModel(modelId);

    }

}
