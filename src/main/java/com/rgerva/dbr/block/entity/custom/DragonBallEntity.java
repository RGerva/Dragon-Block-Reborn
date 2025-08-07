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

import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.properties.ModBlockProperties;
import com.rgerva.dbr.sound.ModSounds;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public class DragonBallEntity extends BlockEntity {
  private int animationTick = 0;
  private boolean animating = false;
  public static final int MAX_ANIMATION_TICKS = 120; // animação subida (6s)

  private int respawnTimer = -1;
  private static final int RESPAWN_TICKS = 2400; // 2 minutos
  private int glowSoundCooldown = 0;

  public DragonBallEntity(BlockPos pos, BlockState blockState) {
    super(ModBlockEntities.DRAGON_BALL_ENTITY.get(), pos, blockState);
  }

  public static void tick(Level level, BlockPos pos, BlockState state, DragonBallEntity entity) {
    if (level.isClientSide) {
      if (entity.animating) {
        entity.animationTick++;
      }
      return;
    }

    if (!state.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE)
        && entity.shouldEmitGlow(level, pos)) {
      entity.particlesEffects((ServerLevel) level, pos, state, entity);
    }
  }

  private void animationEffects(
      ServerLevel level, BlockPos pos, BlockState state, DragonBallEntity entity) {
    if (entity.animating) {
      entity.animationTick++;
      if (entity.animationTick >= MAX_ANIMATION_TICKS) {
        entity.animating = false;
        entity.animationTick = 0;
        entity.setChanged();
        level.sendBlockUpdated(pos, state, state, 3);
      }
      return;
    }
  }

  private void setRespawnEntity(ServerLevel level, BlockPos pos, DragonBallEntity entity) {
    if (entity.respawnTimer > 0) {
      entity.respawnTimer--;
      if (entity.respawnTimer == 0) {
        entity.restoreNearbyStones(level, pos);
      }
    }
  }

  private void particlesEffects(
      ServerLevel level, BlockPos pos, BlockState state, DragonBallEntity entity) {
    if (entity.glowSoundCooldown > 0) entity.glowSoundCooldown--;

    if (!state.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE)
        && entity.shouldEmitGlow(level, pos)) {
      if (entity.getGlowSoundCooldown() <= 0) {
        level.playSound(null, pos, ModSounds.DRAGON_GLOW.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        entity.setGlowSoundCooldown(MAX_ANIMATION_TICKS);
      }
      ((ServerLevel) level)
          .sendParticles(
              ParticleTypes.END_ROD,
              pos.getX() + 0.5,
              pos.getY() + 0.7,
              pos.getZ() + 0.5,
              10,
              0.2,
              0.2,
              0.2,
              0.01);
    }
  }

  private void afterDragon(
      ServerLevel level, BlockPos pos, BlockState state, DragonBallEntity entity) {
    entity.spawnScatteredBalls(level, pos);
    level.setBlock(pos, state.setValue(ModBlockProperties.DRAGON_BALL_IS_STONE, true), 3);
    entity.respawnTimer = RESPAWN_TICKS;
    entity.setChanged();
    level.sendBlockUpdated(pos, state, state, 3);
  }

  public void triggerAnimation() {
    if (!this.animating) {
      this.animating = true;
      this.animationTick = 0;
      this.respawnTimer = 0;
      if (level != null) {
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
      }
    }
  }

  private void spawnScatteredBalls(Level level, BlockPos center) {
    Random random = new Random();
    for (int i = 0; i < 7; i++) {
      int dx = random.nextInt(129) - 64;
      int dz = random.nextInt(129) - 64;
      BlockPos newPos = center.offset(dx, 0, dz);
      BlockPos validPos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, newPos);
      level.setBlock(
          validPos,
          ModBlocks.DRAGON_BALL_BLOCK
              .get()
              .defaultBlockState()
              .setValue(ModBlockProperties.DRAGON_BALL_IS_STONE, true),
          3);
    }
  }

  private void restoreNearbyStones(Level level, BlockPos center) {
    BlockPos.betweenClosedStream(center.offset(-64, -10, -64), center.offset(64, 10, 64))
        .forEach(
            pos -> {
              BlockState bs = level.getBlockState(pos);
              if (bs.getBlock() == ModBlocks.DRAGON_BALL_BLOCK.get()
                  && bs.getValue(ModBlockProperties.DRAGON_BALL_IS_STONE)) {
                level.setBlock(pos, bs.setValue(ModBlockProperties.DRAGON_BALL_IS_STONE, false), 3);
              }
            });
  }

  private boolean shouldEmitGlow(Level level, BlockPos pos) {
    Block block = getBlockState().getBlock();
    return isFormationEastWest(level, pos, block) || isFormationNorthSouth(level, pos, block);
  }

  private boolean isFormationEastWest(Level level, BlockPos pos, Block block) {
    return level.getBlockState(pos.east()).is(block)
        && level.getBlockState(pos.west()).is(block)
        && level.getBlockState(pos.east().north()).is(block)
        && level.getBlockState(pos.east().south()).is(block)
        && level.getBlockState(pos.west().north()).is(block)
        && level.getBlockState(pos.west().south()).is(block);
  }

  private boolean isFormationNorthSouth(Level level, BlockPos pos, Block block) {
    return level.getBlockState(pos.north()).is(block)
        && level.getBlockState(pos.south()).is(block)
        && level.getBlockState(pos.north().east()).is(block)
        && level.getBlockState(pos.north().west()).is(block)
        && level.getBlockState(pos.south().east()).is(block)
        && level.getBlockState(pos.south().west()).is(block);
  }

  @Override
  protected void saveAdditional(ValueOutput output) {
    super.saveAdditional(output);
    output.putInt("animationTick", animationTick);
    output.putBoolean("animating", animating);
    output.putInt("respawnTimer", respawnTimer);
    output.putInt("glowSoundCooldown", glowSoundCooldown);
  }

  @Override
  protected void loadAdditional(ValueInput input) {
    super.loadAdditional(input);
    animationTick = input.getIntOr("animationTick", 0);
    animating = input.getBooleanOr("animating", false);
    respawnTimer = input.getIntOr("RespawnTimer", -1);
    glowSoundCooldown = input.getIntOr("glowSoundCooldown", 0);
  }

  @Override
  public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
    CompoundTag tag = super.getUpdateTag(registries);
    tag.putInt("animationTick", animationTick);
    tag.putBoolean("animating", animating);
    tag.putInt("respawnTimer", respawnTimer);
    tag.putInt("glowSoundCooldown", glowSoundCooldown);
    return tag;
  }

  @Override
  public void handleUpdateTag(ValueInput input) {
    super.handleUpdateTag(input);
    this.animating = input.getBooleanOr("animating", false);
    this.animationTick = input.getIntOr("animationTick", 0);
    this.respawnTimer = input.getIntOr("respawnTimer", -1);
    this.glowSoundCooldown = input.getIntOr("glowSoundCooldown", 0);
    this.respawnTimer = input.getIntOr("respawnTimer", -1);
    this.glowSoundCooldown = input.getIntOr("glowSoundCooldown", 0);
  }

  @Override
  public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
    return ClientboundBlockEntityDataPacket.create(this);
  }

  public float getAnimationProgress() {
    return animationTick / (float) MAX_ANIMATION_TICKS;
  }

  public boolean isAnimating() {
    return animating;
  }

  public int getGlowSoundCooldown() {
    return glowSoundCooldown;
  }

  public void setGlowSoundCooldown(int ticks) {
    this.glowSoundCooldown = ticks;
  }
}
