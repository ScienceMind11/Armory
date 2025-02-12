package net.mercury.armory.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mercury.armory.Armory;
import net.mercury.armory.registry.ArmoryItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class ScytheEntityRenderer extends EntityRenderer<ScytheEntity> {

    public ScytheEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(ScytheEntity entity) {
        return null;
    }

    @Override
    public void render(ScytheEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();

            ItemStack stack = entity.asItemStack();

            float lerpedYaw = MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw());
            float lerpedPitch = MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch());

            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(lerpedYaw - 180.0F));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(lerpedPitch - 90.0F));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));

            long worldTime = entity.getWorld().getTime();
            float rotation = (worldTime + tickDelta) * -5;
            if(!(entity.isInsideWall() || entity.isOnGround())) matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotation));

            matrices.translate(0.5F, -0.1F, 0.0F);

            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            itemRenderer.renderItem(
                    stack,
                    ModelTransformationMode.FIRST_PERSON_RIGHT_HAND,
                    light,
                    OverlayTexture.DEFAULT_UV,
                    matrices,
                    vertexConsumers,
                    MinecraftClient.getInstance().world,
                    0
            );

        matrices.pop();

    }

}
