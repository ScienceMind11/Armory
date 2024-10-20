package io.starfall.armory.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@Inject(method = "setCustomName", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;putString(Ljava/lang/String;Ljava/lang/String;)V"))
	private void armory$devilsknifeName(Text name, CallbackInfoReturnable<ItemStack> cir, @Local NbtCompound nbtCompound) {
		nbtCompound.putBoolean("isDevilsknife", name.getString().matches("Devilsknife"));
	}

}
