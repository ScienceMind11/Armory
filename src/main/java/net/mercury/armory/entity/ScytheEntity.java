package net.mercury.armory.entity;

import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ScytheEntity extends PersistentProjectileEntity {

    private ItemStack stack = new ItemStack(ArmoryItems.SCYTHE);

    public ScytheEntity(double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(ArmoryEntities.SCYTHE, x, y, z, world, stack, weapon);
    }

    public ScytheEntity(World world, PlayerEntity user, ItemStack stack) {
        this(user.getX(), user.getY(), user.getZ(), world, stack, stack);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ArmoryItems.SCYTHE);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {



        super.onBlockHit(blockHitResult);

    }

    @Override
    protected ItemStack asItemStack() {
        return stack;
    }

}
