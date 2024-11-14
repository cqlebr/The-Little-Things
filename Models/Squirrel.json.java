// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Squirrel.json<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "squirrel.json"), "main");
	private final ModelPart bone;
	private final ModelPart head;
	private final ModelPart arms;
	private final ModelPart leftleg;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart rightleg;
	private final ModelPart bone5;
	private final ModelPart bone4;
	private final ModelPart tail;
	private final ModelPart body;

	public Squirrel.json(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = this.bone.getChild("head");
		this.arms = this.bone.getChild("arms");
		this.leftleg = this.bone.getChild("leftleg");
		this.bone3 = this.leftleg.getChild("bone3");
		this.bone2 = this.leftleg.getChild("bone2");
		this.rightleg = this.bone.getChild("rightleg");
		this.bone5 = this.rightleg.getChild("bone5");
		this.bone4 = this.rightleg.getChild("bone4");
		this.tail = this.bone.getChild("tail");
		this.body = this.bone.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.6F, 25.0F, -1.85F));

		PartDefinition head = bone.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-0.35F, -4.25F, 0.5F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -2.7211F, 1.159F, 0.0873F, -0.1745F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 22).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -2.7211F, 0.909F, 0.0436F, 0.1745F, 0.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.2211F, -2.341F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 10).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9711F, -1.841F, -0.0873F, 0.0F, 0.0F));

		PartDefinition arms = bone.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-0.4F, 3.0F, 3.0F));

		PartDefinition cube_r5 = arms.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(4, 22).addBox(0.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(1.6F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 4.0463F, -1.2758F, -0.0873F, 0.0F, 0.0F));

		PartDefinition leftleg = bone.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(1.1F, -1.0F, 5.45F));

		PartDefinition bone3 = leftleg.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(20, 2).addBox(-0.6F, 0.0F, -1.15F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, -1.0F, -0.85F));

		PartDefinition bone2 = leftleg.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-0.4F, -1.0F, -0.85F));

		PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition rightleg = bone.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-2.3F, -2.0F, 4.6F));

		PartDefinition bone5 = rightleg.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(20, 5).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.45F, 1.0F, 0.85F));

		PartDefinition bone4 = rightleg.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(1.45F, 1.0F, 0.85F));

		PartDefinition cube_r7 = bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 18).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.45F, -1.0F, -0.85F, -0.2618F, 0.0F, 0.0F));

		PartDefinition tail = bone.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(-0.35F, -4.3F, 3.8F));

		PartDefinition cube_r8 = tail.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -4.0F, -1.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.3033F, 1.1901F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r9 = tail.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(14, 16).addBox(-1.5F, -3.5F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8681F, 1.1371F, -0.2618F, 0.0F, 0.0F));

		PartDefinition body = bone.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(1.2F, -1.25F, 0.75F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.5F, -2.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}