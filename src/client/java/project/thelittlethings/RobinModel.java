package project.thelittlethings;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import project.thelittlethings.entity.custom.RobinEntity;

public class RobinModel<T extends RobinEntity> extends SinglePartEntityModel<T> {
    private final ModelPart bone;
    private final ModelPart Head;


    public RobinModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.Head = bone.getChild("Head");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Head = bone.addChild("Head", ModelPartBuilder.create().uv(22, 0).cuboid(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(12, 21).cuboid(0.0F, -1.5F, -2.25F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.75F, -6.5F, -3.25F));

        ModelPartData Body = bone.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 0.5F));

        ModelPartData cube_r1 = Body.addChild("cube_r1", ModelPartBuilder.create().uv(20, 11).cuboid(-3.0F, -4.0F, -1.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, 2.0F, 0.5F, -0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r2 = Body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, -3.0F, -1.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 0.75F, -2.75F, 0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r3 = Body.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -1.0F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.75F, 2.25F, -2.5F, -0.1745F, 0.0F, 0.0F));

        ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create().uv(20, 18).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.25F, 0.5F, 3.25F));

        ModelPartData Feet = Body.addChild("Feet", ModelPartBuilder.create().uv(18, 24).cuboid(4.35F, 1.5F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(22, 24).cuboid(1.85F, 1.5F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(22, 6).cuboid(4.35F, 3.25F, -4.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(12, 24).cuboid(1.85F, 3.25F, -4.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.85F, 0.5F, 2.75F));

        ModelPartData Wings = Body.addChild("Wings", ModelPartBuilder.create(), ModelTransform.pivot(0.25F, 0.5F, 3.25F));

        ModelPartData RightWing = Wings.addChild("RightWing", ModelPartBuilder.create(), ModelTransform.pivot(-3.05F, -2.75F, -5.25F));

        ModelPartData cube_r4 = RightWing.addChild("cube_r4", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -1.0F, -1.0F, 6.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.05F, 2.75F, 4.75F, -3.098F, 1.1345F, -1.5272F));

        ModelPartData LeftWing = Wings.addChild("LeftWing", ModelPartBuilder.create(), ModelTransform.pivot(2.2F, -3.0F, -5.25F));

        ModelPartData cube_r5 = LeftWing.addChild("cube_r5", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -1.0F, -1.0F, 6.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.25F, 3.0F, 4.75F, -3.098F, 1.1345F, -1.5272F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(RobinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);


            this.animateMovement(ModAnimations.FLY, limbSwing, limbSwingAmount, 3f, 3f);
            this.updateAnimation(entity.idleAnimationState, ModAnimations.WALK, 0);



    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017453292F;
        this.Head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return bone;
    }
}
