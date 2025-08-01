package com.rgerva.dbr.datagen.model.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DragonBallModel {
  public static final ModelLayerLocation LAYER_LOCATION =
      new ModelLayerLocation(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "dragon_ball_template"),
          "main");

  private final ModelPart root;

  public DragonBallModel(ModelPart root) {
    this.root = root;
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition mesh = new MeshDefinition();
    PartDefinition root = mesh.getRoot();

    root.addOrReplaceChild(
        "starblock",
        CubeListBuilder.create()
            .texOffs(16, 0)
            .mirror()
            .addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape11",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(3.0F, -5.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape12",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape13",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, 3.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape14",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-3.0F, -5.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape15",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -1.0F, 2.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape16",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape17",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -6.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape18",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -5.0F, -3.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape19",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape110",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -1.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape111",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-3.0F, -5.0F, 2.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape112",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -6.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape113",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -6.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape114",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -6.0F, 2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape115",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape116",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -6.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape117",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, -3.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape118",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, 2.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape119",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -5.0F, 2.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape120",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, -3.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape121",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-3.0F, -5.0F, -2.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape123",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -5.0F, 2.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape122",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -5.0F, -2.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape124",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -6.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape125",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-3.0F, -5.0F, -2.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape126",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-3.0F, -1.0F, -2.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape127",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -1.0F, -2.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape128",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(2.0F, -5.0F, -2.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape129",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, 2.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape130",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -1.0F, -3.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));
    root.addOrReplaceChild(
        "Shape131",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .mirror()
            .addBox(-2.0F, -5.0F, -3.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
            .mirror(false),
        PartPose.offset(0.0F, 24.0F, 0.0F));

    return LayerDefinition.create(mesh, 64, 32);
  }

  public void renderToBuffer(
      PoseStack poseStack,
      VertexConsumer buffer,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha) {
    root.render(poseStack, buffer, packedLight, packedOverlay);
  }
}
