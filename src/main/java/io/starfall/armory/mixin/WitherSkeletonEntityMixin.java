package io.starfall.armory.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.starfall.armory.registry.ArmoryItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.random.RandomGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonEntityMixin {

	@WrapOperation(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/WitherSkeletonEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"))
	private void armory$equipScythes(WitherSkeletonEntity instance, EquipmentSlot equipmentSlot, ItemStack itemStack, Operation<Void> original) {
		RandomGenerator random = instance.getWorld().getRandom();
		if ((double)random.nextFloat() > 0.65) {
			instance.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ArmoryItems.SCYTHE));
		} else {
			original.call(instance, equipmentSlot, itemStack);
		}
	}

}
