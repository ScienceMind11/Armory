package net.mercury.armory.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.mercury.armory.item.DaggerItem;
import net.mercury.armory.registry.ArmoryDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@WrapWithCondition(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;takeKnockback(DDD)V"))
	public boolean armory$removeKnockback(LivingEntity instance, double strength, double x, double z, DamageSource source, float amount) {
		return source != ArmoryDamageSource.BLEEDING;
	}

	@ModifyExpressionValue(method = "damage", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;maxHurtTime:I", opcode = 180))
	public int armory$cancelInvincibility(int original, DamageSource source, float amount) {

		if(source.getSource() != null && (source.getSource() instanceof PlayerEntity || source.getSource() instanceof MobEntity)) {

			for(ItemStack stack : source.getSource().getItemsHand()) {
				if(stack.getItem() instanceof DaggerItem) {
					return 0;
				}
			}

		}

		return original;

	}

}
