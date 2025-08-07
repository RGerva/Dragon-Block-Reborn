/**
 * Generic Class: DragonBallBlock <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.block.custom;

import com.mojang.serialization.MapCodec;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.block.entity.custom.DragonBallEntity;
import com.rgerva.dbr.block.entity.data.DragonBallData;
import com.rgerva.dbr.properties.ModBlockProperties;
import com.rgerva.dbr.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DragonBallBlock extends BaseEntityBlock {
  private static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 6, 11);

  private static final MapCodec<DragonBallBlock> CODEC = simpleCodec(DragonBallBlock::new);

  public DragonBallBlock(Properties properties) {
    super(properties.mapColor(MapColor.COLOR_CYAN).strength(0.1F).noCollission());
    this.registerDefaultState(
        this.defaultBlockState().setValue(ModBlockProperties.DRAGON_BALL_IS_STONE, false));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(ModBlockProperties.DRAGON_BALL_IS_STONE);
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level level, BlockState state, BlockEntityType<T> blockEntityType) {
    return createTickerHelper(
        blockEntityType, ModBlockEntities.DRAGON_BALL_ENTITY.get(), DragonBallEntity::tick);
  }

  @Override
  protected MapCodec<? extends BaseEntityBlock> codec() {
    return CODEC;
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
  protected VoxelShape getShape(
      BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    if (state.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE)) {
      level.setBlock(pos, state.setValue(ModBlockProperties.DRAGON_BALL_IS_STONE, false), 3);
    }
  }

  @Override
  public void setPlacedBy(
      Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
      DragonBallData data = DragonBallData.get(serverLevel);
      if (data.canAddMore()) {
        data.addDragonBall(pos);
      } else {
        level.removeBlock(pos, false);
      }
    }
  }

  @Override
  protected InteractionResult useWithoutItem(
      BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

    if (!player.isCrouching()) {
      BlockEntity entity = level.getBlockEntity(pos);
      if (entity instanceof DragonBallEntity dragonBallEntity) {
        if (!level.isClientSide && checkStructure(level, pos, state)) {
          spawnDragon(level, pos, player, dragonBallEntity);
          return InteractionResult.SUCCESS;
        }
      }
    }
    return InteractionResult.PASS;
  }

  private void spawnDragon(Level level, BlockPos pos, Player player, DragonBallEntity entity) {
    //    EntityDragon dragon = new EntityDragon(level);
    //    dragon.moveTo(pos.getX(), pos.getY(), pos.getZ(), player.getYRot(), 0.0F);
    //    level.addFreshEntity(dragon);
    DragonBlockReborn.LOGGER.info("SPAWN DRAGON");
    level.playSound(null, pos, ModSounds.DRAGON_MAKEONE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
    //    destroyStructure(level, pos);

    entity.triggerAnimation();
  }

  private boolean checkStructure(Level level, BlockPos pos, BlockState state) {
    BlockPos left_z = pos.relative(Direction.Axis.Z, -1);
    BlockPos right_z = pos.relative(Direction.Axis.Z, 1);
    BlockPos left_x = pos.relative(Direction.Axis.X, -1);
    BlockPos right_x = pos.relative(Direction.Axis.X, 1);

    BlockPos up_right = pos.west().north();
    BlockPos up_left = pos.east().north();

    BlockPos down_right = pos.west().south();
    BlockPos down_left = pos.east().south();

    return (level.getBlockState(left_z).getBlock() == state.getBlock()
                && level.getBlockState(right_z).getBlock() == state.getBlock()
                && level.getBlockState(up_right).getBlock() == state.getBlock()
                && level.getBlockState(up_left).getBlock() == state.getBlock())
            && level.getBlockState(down_right).getBlock() == state.getBlock()
            && level.getBlockState(down_left).getBlock() == state.getBlock()
        || (level.getBlockState(left_x).getBlock() == state.getBlock()
            && level.getBlockState(right_x).getBlock() == state.getBlock()
            && level.getBlockState(up_right).getBlock() == state.getBlock()
            && level.getBlockState(up_left).getBlock() == state.getBlock()
            && level.getBlockState(down_right).getBlock() == state.getBlock()
            && level.getBlockState(down_left).getBlock() == state.getBlock());
  }

  private void destroyStructure(Level level, BlockPos pos) {
    BlockPos left_z = pos.relative(Direction.Axis.Z, -1);
    BlockPos right_z = pos.relative(Direction.Axis.Z, 1);
    BlockPos left_x = pos.relative(Direction.Axis.X, -1);
    BlockPos right_x = pos.relative(Direction.Axis.X, 1);

    BlockPos up_right = pos.west().north();
    BlockPos up_left = pos.east().north();

    BlockPos down_right = pos.west().south();
    BlockPos down_left = pos.east().south();

    BlockState blockStateToDestroy = level.getBlockState(pos);
    if (blockStateToDestroy.is(ModBlocks.DRAGON_BALL_BLOCK.get())) {
      level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(left_z, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(right_z, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(left_x, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(right_x, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(up_right, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(up_left, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(down_right, Blocks.AIR.defaultBlockState());
      level.setBlockAndUpdate(down_left, Blocks.AIR.defaultBlockState());
    }

    if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
      DragonBallData data = DragonBallData.get(serverLevel);
      data.removeDragonBall(pos);
    }
  }
}
