package net.mercury.armory.mixin;

import net.mercury.armory.item.LongswordItem;
import net.mercury.armory.item.ScytheItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@ClientOnly
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

	@Shadow
	@Final
	private ItemModels models;

	@ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
	private BakedModel armory$changeItemModel(BakedModel model, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel modelAgain) {

		boolean isHeld = !(renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.FIXED);

		if(isHeld && stack.getItem() instanceof ScytheItem item) {
			return models.getModelManager().getModel(item.getHeldModel());
		}

		if(isHeld && stack.getItem() instanceof LongswordItem item) {
			return models.getModelManager().getModel(item.getHeldModel());
		}

		return model;

	}

}
