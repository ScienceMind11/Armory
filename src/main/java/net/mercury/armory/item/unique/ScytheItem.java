package net.mercury.armory.item.unique;

import net.mercury.armory.Armory;
import net.mercury.armory.ArmoryClient;
import net.mercury.armory.entity.ScytheEntity;
import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmoryWeaponSkins;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ScytheEntity entity = new ScytheEntity(world, user, user.getStackInHand(hand));
        entity.setYaw(user.getYaw());
        entity.setPitch(user.getPitch());
        if(user.isInCreativeMode()) entity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
        entity.setVelocity(user, user.getPitch(), user.getYaw(), 90.0F, 2.5F, 1.0F);

        world.spawnEntity(entity);

        return super.use(world, user, hand);

    }

}
