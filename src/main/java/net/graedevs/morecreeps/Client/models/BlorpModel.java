package net.graedevs.morecreeps.Client.models;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.graedevs.morecreeps.Common.entity.BlorpEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BlorpModel extends EntityModel<BlorpEntity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart arm1;
	private final ModelPart arm2;

	public BlorpModel(ModelPart root) {

		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition partDefinition = mesh.getRoot();

		PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -44.0F, -5.5F, 13.0F, 13.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(28, 72).addBox(-2.5F, -38.0F, -1.5F, 4.0F, 25.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(50, 38).addBox(-2.5F, -38.0F, -7.5F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 58).addBox(-8.5F, -59.0F, 0.7F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 25).addBox(-7.0F, -13.0F, -3.5F, 13.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(39, 14).addBox(-8.0F, -13.25F, -5.0F, 15.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(66, 8).addBox(-3.5F, -8.25F, -4.75F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(50, 8).addBox(-3.5F, -8.25F, 3.5F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leg1 = partDefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(98, 21).addBox(-8.0F, -4.0F, -2.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 18.0F, 4.0F));

		PartDefinition leg2 = partDefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(98, 21).addBox(1.0F, -4.0F, -2.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 18.0F, 4.0F));

		PartDefinition leg3 = partDefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(98, 21).addBox(-2.0F, -4.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 18.0F, -4.0F));

		PartDefinition leg4 = partDefinition.addOrReplaceChild("leg4", CubeListBuilder.create(), PartPose.offset(2.0F, 18.0F, -4.0F));

		PartDefinition arm1 = partDefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(29, 41).addBox(-18.75F, -18.0F, -11.5F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = arm1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 30).addBox(-1.5F, -24.0F, -2.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0322F, -0.0295F, -0.8295F));

		PartDefinition arm2 = partDefinition.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(50, 45).addBox(13.85F, -18.0F, -10.0F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r2 = arm2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 0).addBox(-17.0F, -23.25F, -2.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0322F, -0.0295F, 0.8295F));

		return LayerDefinition.create(mesh, 128, 128);
	}


	@Override
	public void setupAnim(BlorpEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}