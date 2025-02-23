package net.mercury.armory.mixin;

import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void armory$switchWeaponSkins(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {

        if(context.getWorld().isClient) cir.setReturnValue(ActionResult.PASS);
        if(!context.getWorld().getBlockState(context.getBlockPos()).isOf(Blocks.SMITHING_TABLE)) cir.setReturnValue(ActionResult.PASS);

        ItemStack stack = context.getStack();
        Item item = stack.getItem();
        if(!ArmoryWeaponSkins.SKINS.containsKey(item)) cir.setReturnValue(ActionResult.PASS);

        List<WeaponSkin> possibleSkins = ArmoryWeaponSkins.SKINS.get(item);
        if(possibleSkins.size() == 1) cir.setReturnValue(ActionResult.PASS);

        WeaponSkin currentSkin = stack.get(ArmoryComponentTypes.WEAPON_SKIN_COMPONENT);
        int index = possibleSkins.indexOf(currentSkin);

        WeaponSkin nextSkin;
        if(index >= possibleSkins.size() - 1) {
            nextSkin = possibleSkins.getFirst();
        } else {
            nextSkin = possibleSkins.get(possibleSkins.indexOf(currentSkin) + 1);
        }

        stack.set(ArmoryComponentTypes.WEAPON_SKIN_COMPONENT, nextSkin);

    }

}
