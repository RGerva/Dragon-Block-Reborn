/**
 * Generic Class: DragonBallEntityRenderer <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.custom.DragonBallEntity;
import com.rgerva.dbr.datagen.model.custom.DragonBallModel;
import com.rgerva.dbr.properties.ModBlockProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class DragonBallEntityRenderer implements BlockEntityRenderer<DragonBallEntity> {

  private final DragonBallModel model;

  private static final ResourceLocation TEXTURE =
      ResourceLocation.fromNamespaceAndPath(
          DragonBlockReborn.MOD_ID, "textures/entity/dragon_block/dragon_ball.png");

  private static final ResourceLocation STONE_TEXTURE =
      ResourceLocation.fromNamespaceAndPath(
          DragonBlockReborn.MOD_ID, "textures/entity/dragon_block/dragon_ball_stone.png");

  public DragonBallEntityRenderer(BlockEntityRendererProvider.Context context) {
    this.model = new DragonBallModel(context.bakeLayer(DragonBallModel.LAYER_LOCATION));
  }

  @Override
  public void render(
          DragonBallEntity entity,
          float partialTick,
          PoseStack poseStack,
          MultiBufferSource bufferSource,
          int packedLight,
          int packedOverlay,
          Vec3 vec3) {

    poseStack.pushPose();

    float yOffset = 0.0F;
    float zOffset = 0.0F;

    if (entity.isAnimating()) {
      float progress = entity.getAnimationProgress() + partialTick / (float) DragonBallEntity.MAX_ANIMATION_TICKS;
      yOffset = progress * 5.0F;
      zOffset = (float) Math.sin(progress * Math.PI) * 0.25F;
    }

    BlockState state = entity.getBlockState();
    boolean isStone = state.hasProperty(ModBlockProperties.DRAGON_BALL_IS_STONE)
            && state.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE);
    ResourceLocation texture = isStone ? STONE_TEXTURE : TEXTURE;

    if (state.getBlock() == ModBlocks.DRAGON_BALL_BLOCK.get()) {
      poseStack.translate(0.5D, 1.51D + yOffset, 0.5D + zOffset);
    } else {
      poseStack.translate(0.5D, 3.01D, 0.5D);
      poseStack.scale(2.0F, 2.0F, 2.0F);
    }

    poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));

    VertexConsumer vertexConsumer =
            bufferSource.getBuffer(RenderType.entityTranslucent(texture));
    model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1F, 1F, 1F, 1F);

    poseStack.popPose();
  }

  @Override
  public boolean shouldRenderOffScreen() {
    return true;
  }
}
