
package project.thelittlethings;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import project.thelittlethings.entity.custom.SquirrelEntity;

public class SquirrelModel<T extends SquirrelEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone; // bone == squirrel itself
	private final ModelPart head;

	public SquirrelModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = bone.getChild("head");

		// porcupine -> body -> torso -> head
		// squirrel -> bone -> head
		// could go in to BB and change bone -> squirrel ***

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.6F, 25.0F, -1.85F));

		ModelPartData head = bone.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-0.35F, -4.25F, 0.5F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(20, 8).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -2.7211F, 1.159F, 0.0873F, -0.1745F, 0.0F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(8, 22).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, -2.7211F, 0.909F, 0.0436F, 0.1745F, 0.0F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(20, 0).cuboid(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.2211F, -2.341F, 0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(14, 10).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.9711F, -1.841F, -0.0873F, 0.0F, 0.0F));

		ModelPartData arms = bone.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, -4.0F, 1.0F));

		ModelPartData cube_r5 = arms.addChild("cube_r5", ModelPartBuilder.create().uv(4, 22).cuboid(0.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(1.6F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.2F, 4.0463F, -1.2758F, -0.0873F, 0.0F, 0.0F));

		ModelPartData leftleg = bone.addChild("leftleg", ModelPartBuilder.create(), ModelTransform.pivot(1.1F, -1.0F, 5.45F));

		ModelPartData bone3 = leftleg.addChild("bone3", ModelPartBuilder.create().uv(20, 2).cuboid(-0.6F, 0.0F, -1.15F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.4F, -1.0F, -0.85F));

		ModelPartData bone2 = leftleg.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(-0.4F, -1.0F, -0.85F));

		ModelPartData cube_r6 = bone2.addChild("cube_r6", ModelPartBuilder.create().uv(0, 18).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData rightleg = bone.addChild("rightleg", ModelPartBuilder.create(), ModelTransform.pivot(-2.3F, -2.0F, 4.6F));

		ModelPartData bone5 = rightleg.addChild("bone5", ModelPartBuilder.create().uv(20, 5).cuboid(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.45F, 1.0F, 0.85F));

		ModelPartData bone4 = rightleg.addChild("bone4", ModelPartBuilder.create(), ModelTransform.pivot(1.45F, 1.0F, 0.85F));

		ModelPartData cube_r7 = bone4.addChild("cube_r7", ModelPartBuilder.create().uv(6, 18).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.45F, -1.0F, -0.85F, -0.2618F, 0.0F, 0.0F));

		ModelPartData tail = bone.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(-0.35F, -4.3F, 3.8F));

		ModelPartData cube_r8 = tail.addChild("cube_r8", ModelPartBuilder.create().uv(0, 10).cuboid(-3.0F, -4.0F, -1.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -2.3033F, 1.1901F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r9 = tail.addChild("cube_r9", ModelPartBuilder.create().uv(14, 16).cuboid(-1.5F, -3.5F, -1.0F, 3.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.8681F, 1.1371F, -0.2618F, 0.0F, 0.0F));

		ModelPartData body = bone.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(1.2F, -1.25F, 0.75F));

		ModelPartData cube_r10 = body.addChild("cube_r10", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.5F, -2.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}


	// can adjust speed of animations here
	// need to modify animation speed of baby
	@Override
	public void setAngles(SquirrelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.SQUIRREL_RUNNING, limbSwing, limbSwingAmount, 3f, 3f); // the speed of its running animation
		this.updateAnimation(entity.idleAnimationState, ModAnimations.SQUIRREL_IDLE, ageInTicks, 0.1f); // speed and rate of idle animation
	}
	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
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