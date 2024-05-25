package net.mercury.armory.item;

import net.mercury.armory.ArmoryMod;
import net.mercury.armory.registry.ArmoryEnchantments;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ScytheItem extends SwordItem {

	private final ModelIdentifier handModel;

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, 4, -2.6F, new QuiltItemSettings().group(ItemGroup.COMBAT));
		handModel = new ModelIdentifier(ArmoryMod.ID, handModelResourceLocation, "inventory");
	}

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation, Settings settings) {
		super(toolMaterial, 4, -2.6F, settings.group(ItemGroup.COMBAT));
		handModel = new ModelIdentifier(ArmoryMod.ID, handModelResourceLocation, "inventory");
	}

	public ModelIdentifier getHeldModel() {
		return handModel;
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		boolean valid = !(target instanceof EnderDragonEntity || target instanceof ShulkerEntity);
		if(!valid) return super.postHit(stack, target, attacker);

		if(EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.REAPING, attacker) > 0) {

			float yaw = attacker.getYaw();
			float pitch = attacker.getPitch();

			Vec3d result = Vec3d.fromPolar(pitch, yaw)
				.multiply(-1.0F)
				.add(target.getVelocity());

			if(!attacker.isOnGround() || !target.isOnGround()) {
				target.setVelocity(result);
			} else {
				target.setVelocity(result.multiply(1, 0, 1));
			}

		}

		return super.postHit(stack, target, attacker);
	}

}
