package net.mercury.armory.item;

import net.mercury.armory.registry.ArmoryEnchantments;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class MercuryScytheItem extends ScytheItem {

	public MercuryScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, handModelResourceLocation, new QuiltItemSettings().fireproof());
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 20;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		boolean canStep = EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.STEP, user) >= 1;
		if(!canStep) return super.use(world, user, hand);
		BlockPos check;

		int i;
		for(i = 1; i <= 4; i++) {
			Vec3d lookVec = Vec3d.of(user.getHorizontalFacing().getVector().multiply(i));
			check = new BlockPos(user.getPos().add(lookVec));
			if(MercuryClaymoreItem.isUnphaseable(world, check)) return super.use(world, user, hand);
			if(!world.isAir(check)) break;
		}

		if(i >= 4) return super.use(world, user, hand);

		int j;
		for(j = 1; j <= 6; j++) {
			Vec3d lookVec = Vec3d.of(user.getHorizontalFacing().getVector().multiply(i + j));
			check = new BlockPos(user.getPos().add(lookVec));
			if(MercuryClaymoreItem.isUnphaseable(world, check)) return super.use(world, user, hand);
			if(world.isAir(check)) break;
		}

		if(j >= 6) return super.use(world, user, hand);

		check = new BlockPos(user.getPos().add(Vec3d.of(user.getHorizontalFacing().getVector().multiply(i + j + 1))));
		user.teleport(check.getX(), check.getY(), check.getZ());

		world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WITHER_SHOOT, user.getSoundCategory(), 1.0F, 1.75F);

		user.getItemCooldownManager().set(this, 400);
		user.getItemCooldownManager().set(ArmoryItems.MERCURY_CLAYMORE, 400);

		return super.use(world, user, hand);

	}

}
