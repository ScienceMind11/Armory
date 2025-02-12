package net.mercury.armory.entity;

import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ScytheEntity extends PersistentProjectileEntity {

    private ItemStack stack = new ItemStack(ArmoryItems.SCYTHE);

    public ScytheEntity(double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(ArmoryEntities.SCYTHE, x, y, z, world, stack, weapon);
    }

    public ScytheEntity(World world, PlayerEntity user, ItemStack stack) {
        this(user.getX(), user.getY() + 1, user.getZ(), world, stack, stack);
    }

    public ScytheEntity(EntityType<ScytheEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ArmoryItems.SCYTHE);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        Direction direction = blockHitResult.getSide();
        setVelocity(new Vec3d(direction.getUnitVector()).multiply(2.5F));

        super.onBlockHit(blockHitResult);

    }

    @Override
    protected ItemStack asItemStack() {
        return stack;
    }

}
