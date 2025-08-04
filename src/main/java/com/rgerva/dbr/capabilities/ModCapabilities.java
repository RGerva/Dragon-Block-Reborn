/**
 * Generic Class: ModCapabilities <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.capabilities;

import java.util.Optional;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;

public class ModCapabilities {

  public static void registerCapabilities(final RegisterCapabilitiesEvent event) {

  }

  public static Optional<IItemHandler> getCapabilityItemHandler(
      Level level, BlockEntity blockEntity) {
    return Optional.ofNullable(
        level.getCapability(
            Capabilities.ItemHandler.BLOCK,
            blockEntity.getBlockPos(),
            blockEntity.getBlockState(),
            blockEntity,
            null));
  }
}
