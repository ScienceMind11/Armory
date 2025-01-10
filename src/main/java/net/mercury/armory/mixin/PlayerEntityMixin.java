package net.mercury.armory.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryParticles;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @WrapOperation(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;spawnSweepAttackParticles()V"))
    private void armory$customScytheSweep(PlayerEntity instance, Operation<Void> original) {

        if(instance.getEquippedStack(EquipmentSlot.MAINHAND).isOf(ArmoryItems.SCYTHE)) {
            spawnCustomScytheSweep();
        } else {
            original.call(instance);
        }

    }

    @Unique
    private void spawnCustomScytheSweep() {
        double d = -MathHelper.sin(self().getYaw() * 0.017453292F);
        double e = MathHelper.cos(self().getYaw() * 0.017453292F);
        if (self().getWorld() instanceof ServerWorld) {
            ((ServerWorld) self().getWorld()).spawnParticles(ArmoryParticles.SILVER_SWEEP_ATTACK, self().getX() + d, self().getBodyY(0.5), self().getZ() + e, 0, d, 0.0, e, 0.0);
        }
    }

    @Unique
    private PlayerEntity self() {
        return (PlayerEntity) (Object) this;
    }

}
