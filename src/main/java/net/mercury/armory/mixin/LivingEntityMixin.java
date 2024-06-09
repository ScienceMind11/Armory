package net.mercury.armory.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.mercury.armory.item.DaggerItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@ModifyExpressionValue(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageSource;isTypeIn(Lnet/minecraft/registry/tag/TagKey;)Z", ordinal = 3))
	public boolean damage(boolean original, DamageSource source, float amount) {

		if(source.getSource() != null && (source.getSource() instanceof PlayerEntity || source.getSource() instanceof MobEntity)) {

			for(ItemStack stack : source.getSource().getItemsHand()) {
				if(stack.getItem() instanceof DaggerItem) {
					return true;
				}
			}

		}

		return original;

	}

}
