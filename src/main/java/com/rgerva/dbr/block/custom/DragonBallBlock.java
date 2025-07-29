/**
 * Generic Class: DragonBallBlock <T>
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

package com.rgerva.dbr.block.custom;

import com.mojang.serialization.MapCodec;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.block.entity.custom.DragonBallEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DragonBallBlock extends BaseEntityBlock {
    public static final int MAX_STACK_SIZE = 7;
    private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 4, 10);

    private static final MapCodec<DragonBallBlock> CODEC = simpleCodec(DragonBallBlock::new);

    public DragonBallBlock(Properties properties) {
        super(properties.mapColor(MapColor.COLOR_CYAN).strength(0.1F).noCollission());
        this.registerDefaultState(this.defaultBlockState());
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.DRAGON_BALL_ENTITY.get(), DragonBallEntity::tick);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DragonBallEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isClientSide()) return;

        boolean pattern1 =
                level.getBlockState(pos.east()).is(this) &&
                        level.getBlockState(pos.east().north()).is(this) &&
                        level.getBlockState(pos.east().south()).is(this) &&
                        level.getBlockState(pos.west()).is(this) &&
                        level.getBlockState(pos.west().north()).is(this) &&
                        level.getBlockState(pos.west().south()).is(this);
        boolean pattern2 =
                level.getBlockState(pos.north()).is(this) &&
                        level.getBlockState(pos.east().north()).is(this) &&
                        level.getBlockState(pos.east().south()).is(this) &&
                        level.getBlockState(pos.north().south()).is(this) &&
                        level.getBlockState(pos.west().south()).is(this) &&
                        level.getBlockState(pos.west().north()).is(this);

        if (pattern1 || pattern2) {
            level.setBlock(pos, ModBlocks.DRAGON_BALL_STONE.get().defaultBlockState(), 3);
        }

        level.scheduleTick(pos, this, 20);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!level.isClientSide()) {
            level.scheduleTick(pos, this, 20);
        }
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return false;
    }
}
