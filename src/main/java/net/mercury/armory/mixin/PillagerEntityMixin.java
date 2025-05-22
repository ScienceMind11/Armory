package net.mercury.armory.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PillagerEntity.class)
public class PillagerEntityMixin {

    @WrapOperation(method = "initEquipment", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/PillagerEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V"))
    private void armory$equipGlaives(PillagerEntity instance, EquipmentSlot equipmentSlot, ItemStack itemStack, Operation<Void> original) {
        Random random = instance.getWorld().getRandom();
        if ((double)random.nextFloat() > 0.80) {
            instance.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ArmoryItems.GLAIVE));
        } else {
            original.call(instance, equipmentSlot, itemStack);
        }
    }

}
