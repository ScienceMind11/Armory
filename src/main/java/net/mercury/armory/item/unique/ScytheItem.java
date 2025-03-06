package net.mercury.armory.item.unique;

import net.mercury.armory.entity.ScytheEntity;
import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity.PickupPermission;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ScytheItem extends SwordItem {

    public ScytheItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 5, -3.0F).component(
                        ArmoryComponentTypes.WEAPON_SKIN_COMPONENT,
                        ArmoryWeaponSkins.DEFAULT_SCYTHE
                ).rarity(Rarity.EPIC)
        );
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.getDamage() >= (stack.getMaxDamage() - 1)) {
            return TypedActionResult.fail(stack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(stack);
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if(user instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(stack, player) - remainingUseTicks;
            if(i >= 10) {
                ScytheEntity entity = new ScytheEntity(world, player, stack);
                entity.setYaw(player.getYaw());
                entity.setPitch(player.getPitch());
                if(player.isInCreativeMode()) entity.pickupType = PickupPermission.CREATIVE_ONLY;
                entity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);

                world.spawnEntity(entity);
            }
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);

    }

}
