package io.starfall.armory.entity;

import io.starfall.armory.ArmoryMod;
import io.starfall.armory.registry.ArmoryItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class ThrownScytheEntity extends PersistentProjectileEntity {

	private ItemStack scytheStack = new ItemStack(ArmoryItems.SCYTHE);
	private boolean dealtDamage;
	public int returnTimer;

	private static final TrackedData<Float> ROTATION = DataTracker.registerData(ThrownScytheEntity.class, TrackedDataHandlerRegistry.FLOAT);
	private static final TrackedData<Boolean> DEVILSKNIFE = DataTracker.registerData(ThrownScytheEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

	public ThrownScytheEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world, ItemStack stack) {
		super(entityType, world);
		this.scytheStack = stack;
	}

	public ThrownScytheEntity(World world, LivingEntity owner, ItemStack stack) {
		super(ArmoryMod.SCYTHE, owner, world);
		this.dataTracker.set(DEVILSKNIFE, stack.getOrCreateSubNbt("display").getBoolean("isDevilsknife"));
		this.scytheStack = stack;
	}

	public ThrownScytheEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public EntityType<?> getType() {
		return ArmoryMod.SCYTHE;
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(ROTATION, -112.5F);
		this.dataTracker.startTracking(DEVILSKNIFE, false);
	}

	public void setRotation(float rotation) {
		this.dataTracker.set(ROTATION, rotation);
	}

	public float getRotation() {
		return this.dataTracker.get(ROTATION);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {

		Entity entity = entityHitResult.getEntity();
		float f = 8.0F;
		if (entity instanceof LivingEntity livingEntity) {
			f += EnchantmentHelper.getAttackDamage(this.scytheStack, livingEntity.getGroup());
		}

		Entity entity2 = this.getOwner();
		DamageSource damageSource = DamageSource.thrownProjectile(this, entity2 == null ? this : entity2);
		this.dealtDamage = true;
		if (entity.damage(damageSource, f)) {
			if (entity.getType() == EntityType.ENDERMAN) return;

			if (entity instanceof LivingEntity livingEntity2) {
				if (entity2 instanceof LivingEntity) {
					EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
					EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
				}

				this.onHit(livingEntity2);
			}
		}

		this.setVelocity(this.getVelocity().multiply(0, 0, 0));
		ServerPlayerEntity player = this.getOwner() instanceof ServerPlayerEntity spe ? spe : null;
		this.scytheStack.damage(1, this.world.random, player);

	}

	@Override
	public void tick() {
		if(this.inGroundTime > 4) {
			this.dealtDamage = true;
		}

		Entity entity = this.getOwner();
		if((this.dealtDamage || this.isNoClip()) && entity != null && entity.isAlive()) {
			this.setNoClip(true);
			Vec3d vec3d = entity.getEyePos().subtract(this.getPos());
			this.setPos(this.getX(), this.getY() + vec3d.y * 0.030, this.getZ());
			if (this.world.isClient) {
				this.lastRenderY = this.getY();
			}

			double d = 0.1;
			this.setVelocity(this.getVelocity().multiply(0.95).add(vec3d.normalize().multiply(d)));
		}

		super.tick();
	}

	public ItemStack asItemStack() {
		return this.scytheStack;
	}

	public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
		return true;
	}

	public boolean isInGround() {
		return inGround;
	}

	public boolean isDevilsknife() {
		return this.dataTracker.get(DEVILSKNIFE);
	}

}
