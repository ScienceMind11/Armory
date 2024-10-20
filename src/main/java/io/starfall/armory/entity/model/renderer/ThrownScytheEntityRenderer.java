package io.starfall.armory.entity.model.renderer;

import com.mojang.blaze3d.vertex.VertexConsumer;
import io.starfall.armory.entity.model.ThrownScytheEntityModel;
import io.starfall.armory.ArmoryMod;
import io.starfall.armory.entity.ThrownScytheEntity;
import io.starfall.armory.entity.model.DevilsknifeEntityModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class ThrownScytheEntityRenderer extends EntityRenderer<ThrownScytheEntity> {

	public static final Identifier SCYTHE_TEXTURE = new Identifier(ArmoryMod.ID, "textures/entity/scythe.png");
	public static final Identifier DEVILSKNIFE_TEXTURE = new Identifier(ArmoryMod.ID, "textures/entity/devilsknife.png");
	private final ThrownScytheEntityModel scytheModel;
	private final DevilsknifeEntityModel devilsknifeModel;

	public ThrownScytheEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.scytheModel = new ThrownScytheEntityModel(context.getPart(new EntityModelLayer(new Identifier(ArmoryMod.ID, "scythe"), "main")));
		this.devilsknifeModel = new DevilsknifeEntityModel(context.getPart(new EntityModelLayer(new Identifier(ArmoryMod.ID, "devilsknife"), "main")));
	}

	public void render(ThrownScytheEntity scytheEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

		matrixStack.push();

			matrixStack.scale(2, 2, 2);
			matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, scytheEntity.prevYaw, scytheEntity.getYaw()) - 180.0F));
			matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-90.0F));

			if(!scytheEntity.isInGround()) {
				float j = scytheEntity.getRotation();
				scytheEntity.setRotation(j -= 1);
				matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(j));
			}

			VertexConsumer vertexConsumer;
			if(scytheEntity.isDevilsknife()) {
				vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.devilsknifeModel.getLayer(this.getTexture(scytheEntity)), false, false);
				this.devilsknifeModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
			} else {
				vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.scytheModel.getLayer(this.getTexture(scytheEntity)), false, false);
				this.scytheModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
			}

		matrixStack.pop();

		super.render(scytheEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}

	public Identifier getTexture(ThrownScytheEntity scytheEntity) {
		return scytheEntity.isDevilsknife() ? DEVILSKNIFE_TEXTURE : SCYTHE_TEXTURE;
	}

}
