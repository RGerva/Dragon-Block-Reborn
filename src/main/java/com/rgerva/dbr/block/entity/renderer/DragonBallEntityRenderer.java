/**
 * Generic Class: DragonBallEntityRenderer <T>
 * A generic structure that works with type parameters.
 * <p>
 * Created by: rgerv
 * On: 2025/jul.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rgerva.dbr.block.entity.custom.DragonBallEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

public class DragonBallEntityRenderer implements BlockEntityRenderer<DragonBallEntity> {
    public DragonBallEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(DragonBallEntity dragonBallEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1, Vec3 vec3) {

    }
}
