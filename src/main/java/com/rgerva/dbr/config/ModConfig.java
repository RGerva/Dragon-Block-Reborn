/**
 * Generic Class: ModConfig <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.config;

import com.rgerva.dbr.DragonBlockReborn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID)
public class ModConfig {
  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

  public static final ModConfigSpec SPEC = BUILDER.build();

  @SubscribeEvent
  static void onLoad(final ModConfigEvent event) {}
}
