package net.mercury.armory.entity;

import net.mercury.armory.registry.ArmoryEntities;
import net.mercury.armory.registry.ArmoryItems;
import net.mercury.armory.registry.ArmorySounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
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

//    @Override
//    protected void onBlockHit(BlockHitResult blockHitResult) {
//
//        Direction direction = blockHitResult.getSide();
//        setVelocity(new Vec3d(direction.getUnitVector()).multiply(2.5F));
//
//        super.onBlockHit(blockHitResult);
//
//    }

    @Override
    protected ItemStack asItemStack() {
        return stack;
    }

    @Override
    protected SoundEvent getHitSound() {
        return ArmorySounds.SCYTHE_HIT;
    }

}
