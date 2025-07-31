/**
 * Generic Class: DragonBallEntity <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.block.entity.custom;

import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.properties.ModBlockProperties;
import com.rgerva.dbr.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class DragonBallEntity extends BlockEntity {
  private int cb = 100;
  private int cb2 = 100;

  public DragonBallEntity(BlockPos pos, BlockState blockState) {
    super(ModBlockEntities.DRAGON_BALL_ENTITY.get(), pos, blockState);
  }

  public static void tick(Level level, BlockPos blockPos, BlockState blockState, DragonBallEntity entity) {
    entity.updateSound(level, blockPos, blockState);
  }

  private void updateSound(Level level, BlockPos pos, BlockState state) {
    if (--this.cb <= 0) {
      this.cb = 100;

      boolean isStone = state.hasProperty(ModBlockProperties.DRAGON_BALL_IS_STONE)
              && state.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE);

      if (!isStone) {
        Block block = state.getBlock();

        if (isFormationEastWest(level, pos, block) || isFormationNorthSouth(level, pos, block)) {
          level.playSound(null, pos, ModSounds.DRAGON_GLOW.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
      }

    }

  }

  private boolean isFormationEastWest(Level level, BlockPos pos, Block block) {
    return level.getBlockState(pos.east()).is(block)
            && level.getBlockState(pos.east().north()).is(block)
            && level.getBlockState(pos.east().south()).is(block)
            && level.getBlockState(pos.west()).is(block)
            && level.getBlockState(pos.west().north()).is(block)
            && level.getBlockState(pos.west().south()).is(block);
  }

  private boolean isFormationNorthSouth(Level level, BlockPos pos, Block block) {
    return level.getBlockState(pos.north()).is(block)
            && level.getBlockState(pos.north().east()).is(block)
            && level.getBlockState(pos.north().west()).is(block)
            && level.getBlockState(pos.south()).is(block)
            && level.getBlockState(pos.south().east()).is(block)
            && level.getBlockState(pos.south().west()).is(block);
  }


  @Override
  protected void saveAdditional(ValueOutput output) {
    super.saveAdditional(output);
    output.putInt("cb", cb);
    output.putInt("cb2", cb2);
  }

  @Override
  protected void loadAdditional(ValueInput input) {
    super.loadAdditional(input);
    cb = input.getIntOr("cb", 100);
    cb2 = input.getIntOr("cb2", 100);
  }
}
