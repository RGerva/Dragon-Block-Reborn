/**
 * Generic Class: ModBlockEntities <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.block.entity;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.custom.DragonBallEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Locale;
import java.util.function.Supplier;

public class ModBlockEntities {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DragonBlockReborn.MOD_ID);

  public static final Supplier<BlockEntityType<DragonBallEntity>> DRAGON_BALL_ENTITY = BLOCK_ENTITIES.register("dragon_ball",
          () -> new BlockEntityType<>(DragonBallEntity::new, ModBlocks.DRAGON_BALL_BLOCK.get()));

  public static void register(IEventBus eventBus) {
    BLOCK_ENTITIES.register(eventBus);
  }
}
