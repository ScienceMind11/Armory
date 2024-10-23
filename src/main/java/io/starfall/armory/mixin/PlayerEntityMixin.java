package io.starfall.armory.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import io.starfall.armory.item.ScytheItem;
import io.starfall.armory.registry.ArmoryEnchantments;
import io.starfall.armory.registry.ArmoryParticles;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	@WrapOperation(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;spawnSweepAttackParticles()V"))
	private void armory$customSweep(PlayerEntity instance, Operation<Void> original) {

		if(instance.getMainHandStack().getItem() instanceof ScytheItem) {

			armory$spawnCustomSweepParticles();

		} else {
			original.call(instance);
		}

	}

	@Unique
	public void armory$spawnCustomSweepParticles() {
		double d = -MathHelper.sin(self().getYaw() * 0.017453292F);
		double e = MathHelper.cos(self().getYaw() * 0.017453292F);
		if (self().getWorld() instanceof ServerWorld) {
			((ServerWorld) self().world).spawnParticles(ArmoryParticles.SILVER_SWEEP_ATTACK, self().getX() + d, self().getBodyY(0.5), self().getZ() + e, 0, d, 0.0, e, 0.0);
		}
	}

	@Unique
	private PlayerEntity self() {
		return (PlayerEntity) (Object) this;
	}

	@ModifyVariable(method = "attack", at = @At("STORE"), ordinal = 1)
	public float armory$tricksterEnchantPlayerEntity(float g, Entity target) {

		if(EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.TRICKSTER, self()) > 0) {
			for(StatusEffectInstance ignored : ((LivingEntity)target).getStatusEffects()) {
				g += 1;
			}
		}

		return g;

	}

}
