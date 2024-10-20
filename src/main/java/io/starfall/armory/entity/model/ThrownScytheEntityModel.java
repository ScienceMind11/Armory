package io.starfall.armory.entity.model;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.starfall.armory.ArmoryMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ThrownScytheEntityModel extends Model {

	public static final Identifier TEXTURE = new Identifier(ArmoryMod.ID, "textures/entity/scythe.png");
	private final ModelPart root;

	public ThrownScytheEntityModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		this.root = root;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();

		modelData.getRoot().addChild("scythe", ModelPartBuilder.create().uv(0, 18).cuboid(-2.0F, -0.5F, -7.5F, 3.5F, 0.5F, 0.5F)
			.uv(0, 12).cuboid(-3.5F, -0.5F, -7.0F, 6.5F, 0.5F, 0.5F)
			.uv(26, 10).cuboid(-7.5F, -0.5F, -7.0F, 1.5F, 0.5F, 0.5F)
			.uv(0, 8).cuboid(-4.5F, -0.5F, -6.5F, 8.5F, 0.5F, 0.5F)
			.uv(0, 24).cuboid(-7.5F, -0.5F, -6.5F, 2.5F, 0.5F, 0.5F)
			.uv(0, 6).cuboid(-7.5F, -0.5F, -6.0F, 12.5F, 0.5F, 0.5F)
			.uv(0, 4).cuboid(-7.0F, -0.5F, -5.5F, 12.5F, 0.5F, 0.5F)
			.uv(0, 2).cuboid(-6.5F, -0.5F, -5.0F, 12.5F, 0.5F, 0.5F)
			.uv(0, 0).cuboid(-6.5F, -0.5F, -4.5F, 13.0F, 0.5F, 0.5F)
			.uv(10, 16).cuboid(3.5F, -0.5F, -4.0F, 3.5F, 0.5F, 0.5F)
			.uv(0, 10).cuboid(-7.0F, -0.5F, -4.0F, 6.5F, 0.5F, 0.5F)
			.uv(6, 26).cuboid(5.0F, -0.5F, -3.5F, 2.0F, 0.5F, 0.5F)
			.uv(0, 14).cuboid(-7.0F, -0.5F, -3.5F, 5.5F, 0.5F, 0.5F)
			.uv(12, 26).cuboid(6.0F, -0.5F, -3.0F, 1.0F, 0.5F, 0.5F)
			.uv(14, 14).cuboid(-7.0F, -0.5F, -3.0F, 5.0F, 0.5F, 0.5F)
			.uv(16, 20).cuboid(-4.5F, -0.5F, -2.5F, 3.0F, 0.5F, 0.5F)
			.uv(0, 26).cuboid(-7.0F, -0.5F, -2.5F, 2.0F, 0.5F, 0.5F)
			.uv(23, 23).cuboid(-3.5F, -0.5F, -2.0F, 2.5F, 0.5F, 0.5F)
			.uv(26, 8).cuboid(-7.0F, -0.5F, -2.0F, 1.5F, 0.5F, 0.5F)
			.uv(25, 25).cuboid(-3.0F, -0.5F, -1.5F, 2.0F, 0.5F, 0.5F)
			.uv(25, 19).cuboid(-2.5F, -0.5F, -1.0F, 2.0F, 0.5F, 0.5F)
			.uv(19, 25).cuboid(-2.0F, -0.5F, -0.5F, 2.0F, 0.5F, 0.5F)
			.uv(14, 24).cuboid(-1.5F, -0.5F, 0.0F, 2.0F, 0.5F, 0.5F)
			.uv(24, 12).cuboid(-1.0F, -0.5F, 0.5F, 2.0F, 0.5F, 0.5F)
			.uv(23, 21).cuboid(-0.5F, -0.5F, 1.0F, 2.5F, 0.5F, 0.5F)
			.uv(8, 20).cuboid(0.0F, -0.5F, 1.5F, 3.0F, 0.5F, 0.5F)
			.uv(0, 16).cuboid(0.5F, -0.5F, 2.0F, 3.5F, 0.5F, 0.5F)
			.uv(15, 11).cuboid(1.0F, -0.5F, 2.5F, 3.5F, 0.5F, 0.5F)
			.uv(0, 20).cuboid(2.0F, -0.5F, 3.0F, 3.0F, 0.5F, 0.5F)
			.uv(16, 22).cuboid(3.0F, -0.5F, 3.5F, 2.5F, 0.5F, 0.5F)
			.uv(8, 22).cuboid(3.5F, -0.5F, 4.0F, 2.5F, 0.5F, 0.5F)
			.uv(0, 22).cuboid(4.0F, -0.5F, 4.5F, 2.5F, 0.5F, 0.5F)
			.uv(19, 9).cuboid(4.0F, -0.5F, 5.0F, 3.0F, 0.5F, 0.5F)
			.uv(18, 18).cuboid(4.5F, -0.5F, 5.5F, 3.0F, 0.5F, 0.5F)
			.uv(10, 18).cuboid(4.5F, -0.5F, 6.0F, 3.0F, 0.5F, 0.5F)
			.uv(20, 16).cuboid(5.0F, -0.5F, 6.5F, 2.5F, 0.5F, 0.5F)
			.uv(8, 24).cuboid(5.5F, -0.5F, 7.0F, 2.0F, 0.5F, 0.5F), ModelTransform.NONE);

		return TexturedModelData.of(modelData, 32, 32);

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}

}
