/**
 * Generic Class: DragonBallEntity <T>
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

package com.rgerva.dbr.block.entity.custom;

import com.rgerva.dbr.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DragonBallEntity extends BlockEntity {
    public DragonBallEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.DRAGON_BALL_ENTITY.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, DragonBallEntity entity) {

    }
}
