package io.starfall.armory.item;

import io.starfall.armory.entity.ThrownScytheEntity;
import io.starfall.armory.ArmoryMod;
import io.starfall.armory.registry.ArmoryEnchantments;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ScytheItem extends SwordItem {

	private final Identifier handModel;

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, 6, -3.0F, new QuiltItemSettings().group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation, Settings settings) {
		super(toolMaterial, 6, -3.0F, settings.group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	@ClientOnly
	public ModelIdentifier getHeldModel() {
		return new ModelIdentifier(handModel, "inventory");
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		boolean valid = !(target instanceof EnderDragonEntity || target instanceof ShulkerEntity);
		int level = EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.REAPING, attacker);
		if(!valid || level <= 0) return super.postHit(stack, target, attacker);

		float yaw = attacker.getYaw();
		float pitch = attacker.getPitch();

		Vec3d result = Vec3d.fromPolar(pitch, yaw)
			.negate()
			.add(target.getVelocity())
			.multiply(level);

		if(!attacker.isOnGround() || !target.isOnGround()) {
			target.setVelocity(result);
		} else {
			target.setVelocity(result.multiply(1, 0, 1));
		}

		return super.postHit(stack, target, attacker);
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.SPEAR;
	}

	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1 || EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.TOSS, user) <= 0) {
			return TypedActionResult.fail(itemStack);
		} else {
			user.setCurrentHand(hand);
			return TypedActionResult.consume(itemStack);
		}
	}

	@Override
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

		int i = this.getMaxUseTime(stack) - remainingUseTicks;
		if(user instanceof PlayerEntity player && i >= 10) {

			ThrownScytheEntity scythe = new ThrownScytheEntity(world, player, stack);
			scythe.setProperties(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);

			if (player.getAbilities().creativeMode) {
				scythe.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
			}

			if(!player.getAbilities().creativeMode) {
				player.getInventory().removeOne(stack);
			}

			world.spawnEntity(scythe);
		}

	}

}
