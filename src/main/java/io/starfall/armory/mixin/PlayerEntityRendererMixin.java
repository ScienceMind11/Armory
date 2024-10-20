package io.starfall.armory.mixin;

import io.starfall.armory.item.LongswordItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

	@Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
	private static void armory$longsword(@NotNull AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {

		ItemStack main = player.getMainHandStack();

		if(main.getItem() instanceof LongswordItem) {

			boolean offhandFilled = !(player.getOffHandStack().getItem() == Items.AIR);
			boolean shield = offhandFilled && player.getOffHandStack().getItem() == Items.SHIELD;
			boolean blocking = player.isBlocking() && shield;

			if(blocking) {
				cir.setReturnValue(BipedEntityModel.ArmPose.BLOCK);
			} else {
				cir.setReturnValue(offhandFilled ? BipedEntityModel.ArmPose.ITEM : BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
			}

		}

	}

}
