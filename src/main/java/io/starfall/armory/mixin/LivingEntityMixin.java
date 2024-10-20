package io.starfall.armory.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.starfall.armory.item.DaggerItem;
import io.starfall.armory.registry.ArmoryDamageSource;
import io.starfall.armory.registry.ArmoryEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@WrapWithCondition(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;takeKnockback(DDD)V"))
	public boolean armory$removeBleedingKnockback(LivingEntity instance, double strength, double x, double z, DamageSource source, float amount) {
		return source != ArmoryDamageSource.BLEEDING;
	}

	@ModifyExpressionValue(method = "damage", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/LivingEntity;maxHurtTime:I", opcode = 180))
	public int armory$removeInvincibilityFrames(int original, DamageSource source, float amount) {

		if(source.getSource() != null && (source.getSource() instanceof PlayerEntity || source.getSource() instanceof MobEntity)) {

			for(ItemStack stack : source.getSource().getItemsHand()) {
				if(stack.getItem() instanceof DaggerItem) {
					return 0;
				}
			}

		}

		return original;

	}

	@WrapOperation(method = "applyArmorToDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/DamageUtil;getDamageLeft(FFF)F"))
	public float armory$lowerArmorProtection(float damage, float armor, float armorToughness, Operation<Float> original, DamageSource source, float amount) {
		if(source.getSource() == null) return original.call(damage, armor, armorToughness);
		if(!(source.getSource() instanceof LivingEntity entity)) return original.call(damage, armor, armorToughness);

		int level = EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.CLEAVING, entity);
		if(level > 0) {
			return original.call(damage, armor * (1.0F - (0.07F * level)), armorToughness);
		}
		return original.call(damage, armor, armorToughness);
	}

}
