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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ScytheItem extends SwordItem {

	private final Identifier handModel;

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation) {
		super(toolMaterial, 4, -2.7F, new QuiltItemSettings().group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	public ScytheItem(ToolMaterial toolMaterial, String handModelResourceLocation, Settings settings) {
		super(toolMaterial, 4, -2.7F, settings.group(ItemGroup.COMBAT));
		handModel = new Identifier(ArmoryMod.ID, handModelResourceLocation);
	}

	@ClientOnly
	public ModelIdentifier getHeldModel() {
		return new ModelIdentifier(handModel, "inventory");
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		boolean valid = !(target instanceof EnderDragonEntity || target instanceof ShulkerEntity);
		if(!valid) return super.postHit(stack, target, attacker);

		int level = EnchantmentHelper.getEquipmentLevel(ArmoryEnchantments.REAPING, attacker);
		if(level > 0) {

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

		}

		return super.postHit(stack, target, attacker);
	}

}
