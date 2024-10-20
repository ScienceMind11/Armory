package io.starfall.armory.entity.model;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.starfall.armory.ArmoryMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DevilsknifeEntityModel extends Model {

	public static final Identifier TEXTURE = new Identifier(ArmoryMod.ID, "textures/entity/devilsknife.png");
	private final ModelPart root;

	public DevilsknifeEntityModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		this.root = root;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();

		modelData.getRoot().addChild("devilsknife", ModelPartBuilder.create().uv(0, 24).cuboid(-1.5F, -0.5F, -7.5F, 3.5F, 0.5F, 0.5F)
			.uv(16, 18).cuboid(-3.0F, -0.5F, -7.0F, 6.5F, 0.5F, 0.5F)
			.uv(34, 24).cuboid(-7.0F, -0.5F, -7.0F, 1.5F, 0.5F, 0.5F)
			.uv(0, 15).cuboid(-4.0F, -0.5F, -6.5F, 8.5F, 0.5F, 0.5F)
			.uv(16, 30).cuboid(-7.0F, -0.5F, -6.5F, 2.5F, 0.5F, 0.5F)
			.uv(0, 9).cuboid(-7.0F, -0.5F, -6.0F, 12.5F, 0.5F, 0.5F)
			.uv(0, 6).cuboid(-6.5F, -0.5F, -5.5F, 12.5F, 0.5F, 0.5F)
			.uv(0, 3).cuboid(-6.0F, -0.5F, -5.0F, 12.5F, 0.5F, 0.5F)
			.uv(0, 0).cuboid(-6.0F, -0.5F, -4.5F, 13.0F, 0.5F, 0.5F)
			.uv(4, 36).cuboid(-7.5F, -0.5F, -4.5F, 1.0F, 0.5F, 0.5F)
			.uv(0, 21).cuboid(3.5F, -0.5F, -4.0F, 4.0F, 0.5F, 0.5F)
			.uv(34, 15).cuboid(1.5F, -0.5F, -4.0F, 1.5F, 0.5F, 0.5F)
			.uv(0, 12).cuboid(-8.0F, -0.5F, -4.0F, 9.0F, 0.5F, 0.5F)
			.uv(8, 30).cuboid(5.5F, -0.5F, -3.5F, 2.5F, 0.5F, 0.5F)
			.uv(34, 12).cuboid(3.5F, -0.5F, -3.5F, 1.5F, 0.5F, 0.5F)
			.uv(30, 33).cuboid(1.5F, -0.5F, -3.5F, 1.5F, 0.5F, 0.5F)
			.uv(24, 33).cuboid(-0.5F, -0.5F, -3.5F, 1.5F, 0.5F, 0.5F)
			.uv(0, 18).cuboid(-8.0F, -0.5F, -3.5F, 7.0F, 0.5F, 0.5F)
			.uv(12, 33).cuboid(6.0F, -0.5F, -3.0F, 2.0F, 0.5F, 0.5F)
			.uv(18, 33).cuboid(3.5F, -0.5F, -3.0F, 1.5F, 0.5F, 0.5F)
			.uv(36, 3).cuboid(2.0F, -0.5F, -3.0F, 1.0F, 0.5F, 0.5F)
			.uv(36, 0).cuboid(0.0F, -0.5F, -3.0F, 1.0F, 0.5F, 0.5F)
			.uv(20, 15).cuboid(-7.5F, -0.5F, -3.0F, 6.0F, 0.5F, 0.5F)
			.uv(0, 36).cuboid(6.5F, -0.5F, -2.5F, 1.0F, 0.5F, 0.5F)
			.uv(35, 35).cuboid(4.0F, -0.5F, -2.5F, 1.0F, 0.5F, 0.5F)
			.uv(20, 12).cuboid(-7.0F, -0.5F, -2.5F, 6.0F, 0.5F, 0.5F)
			.uv(0, 30).cuboid(-3.0F, -0.5F, -2.0F, 2.5F, 0.5F, 0.5F)
			.uv(16, 27).cuboid(-6.5F, -0.5F, -2.0F, 3.0F, 0.5F, 0.5F)
			.uv(6, 33).cuboid(-2.5F, -0.5F, -1.5F, 2.0F, 0.5F, 0.5F)
			.uv(0, 33).cuboid(-6.0F, -0.5F, -1.5F, 2.0F, 0.5F, 0.5F)
			.uv(32, 27).cuboid(-2.0F, -0.5F, -1.0F, 2.0F, 0.5F, 0.5F)
			.uv(32, 18).cuboid(-1.5F, -0.5F, -0.5F, 2.0F, 0.5F, 0.5F)
			.uv(30, 30).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 0.5F, 0.5F)
			.uv(24, 30).cuboid(-0.5F, -0.5F, 0.5F, 2.0F, 0.5F, 0.5F)
			.uv(28, 9).cuboid(0.0F, -0.5F, 1.0F, 2.5F, 0.5F, 0.5F)
			.uv(8, 27).cuboid(0.5F, -0.5F, 1.5F, 3.0F, 0.5F, 0.5F)
			.uv(20, 21).cuboid(1.0F, -0.5F, 2.0F, 3.5F, 0.5F, 0.5F)
			.uv(10, 21).cuboid(1.5F, -0.5F, 2.5F, 3.5F, 0.5F, 0.5F)
			.uv(0, 27).cuboid(2.5F, -0.5F, 3.0F, 3.0F, 0.5F, 0.5F)
			.uv(28, 6).cuboid(3.5F, -0.5F, 3.5F, 2.5F, 0.5F, 0.5F)
			.uv(28, 3).cuboid(4.0F, -0.5F, 4.0F, 2.5F, 0.5F, 0.5F)
			.uv(28, 0).cuboid(4.5F, -0.5F, 4.5F, 2.5F, 0.5F, 0.5F)
			.uv(26, 24).cuboid(4.5F, -0.5F, 5.0F, 3.0F, 0.5F, 0.5F)
			.uv(18, 24).cuboid(5.0F, -0.5F, 5.5F, 3.0F, 0.5F, 0.5F)
			.uv(10, 24).cuboid(5.0F, -0.5F, 6.0F, 3.0F, 0.5F, 0.5F)
			.uv(24, 27).cuboid(5.5F, -0.5F, 6.5F, 2.5F, 0.5F, 0.5F)
			.uv(30, 21).cuboid(6.0F, -0.5F, 7.0F, 2.0F, 0.5F, 0.5F), ModelTransform.NONE);

		return TexturedModelData.of(modelData, 64, 64);

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}

}
