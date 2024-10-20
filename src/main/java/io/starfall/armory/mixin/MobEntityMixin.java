package io.starfall.armory.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.starfall.armory.registry.ArmoryEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MobEntityMixin {

	@Inject(method = "tryAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F"))
	public void armory$tricksterEnchantPlayerEntity(Entity target, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 0) float f) {

		if(EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.TRICKSTER, (MobEntity) (Object) this) > 0) {
			for(StatusEffectInstance ignored : ((LivingEntity)target).getStatusEffects()) {
				f += 1;
			}
		}

	}

}
