package net.mercury.armory.item.unique;

import net.mercury.armory.Armory;
import net.mercury.armory.ArmoryClient;
import net.mercury.armory.entity.ScytheEntity;
import net.mercury.armory.item.SeparateTransform;
import net.mercury.armory.registry.ArmoryComponentTypes;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScytheItem extends SwordItem implements SeparateTransform {

    public ScytheItem(ToolMaterial material, boolean fireproof) {
        super(
                material,
                ArmoryItems.getSettings(material, fireproof, 6, -3.0F).component(ArmoryComponentTypes.DEVILSKNIFE, false)
        );
    }

    @Override
    public Identifier getHeldModelIdentifier() {
        return Armory.id("item/hand/scythe");
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ScytheEntity entity = new ScytheEntity(world, user, user.getStackInHand(hand));
        entity.setYaw(user.getYaw());
        entity.setPitch(user.getPitch());
        entity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;

        world.spawnEntity(entity);

        return super.use(world, user, hand);

    }

}
