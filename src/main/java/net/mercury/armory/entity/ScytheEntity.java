package net.mercury.armory.entity;

import net.mercury.armory.registry.*;
import net.mercury.armory.skin.WeaponSkin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ScytheEntity extends PersistentProjectileEntity {

    private static final TrackedData<Integer> SKIN = DataTracker.registerData(ScytheEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private boolean hasHit;

    public ScytheEntity(double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon) {
        super(ArmoryEntities.SCYTHE, x, y, z, world, stack, weapon);
        this.initSkin(stack);
        this.setNoGravity(true);
    }

    public ScytheEntity(World world, PlayerEntity user, ItemStack stack) {
        this(user.getX(), user.getY() + 1, user.getZ(), world, stack, stack);
    }

    public ScytheEntity(EntityType<ScytheEntity> type, World world) {
        super(type, world);
        this.initSkin(ArmoryItems.SCYTHE.getDefaultStack());
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SKIN, 0);
    }

    private void initSkin(ItemStack stack) {
        this.dataTracker.set(SKIN, ArmoryWeaponSkins.SKINS.get(ArmoryItems.SCYTHE).indexOf(stack.get(ArmoryComponentTypes.WEAPON_SKIN_COMPONENT)));
    }

    public WeaponSkin getSkin() {
        return ArmoryWeaponSkins.SKINS.get(ArmoryItems.SCYTHE).get(this.dataTracker.get(SKIN));
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ArmoryItems.SCYTHE);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        super.onBlockHit(blockHitResult);

        if(this.hasHit) return;

        Vec3d velocity = this.getVelocity();

        Vec3d normal = new Vec3d(blockHitResult.getSide().getUnitVector());

        // Reflect formula: R = V - 2 * (V · N) * N
        double dot = velocity.dotProduct(normal);
        Vec3d reflected = velocity.subtract(normal.multiply(2 * dot)).multiply(5.0);

        this.setVelocity(reflected);
        this.hasHit = true;

    }

    @Override
    protected SoundEvent getHitSound() {
        return ArmorySounds.SCYTHE_HIT;
    }



}
