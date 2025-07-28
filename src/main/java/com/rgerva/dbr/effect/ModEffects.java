/**
 * Generic Class: ModEffects <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.effect;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
  public static final DeferredRegister<MobEffect> MOB_EFFECTS =
      DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DragonBlockReborn.MOD_ID);

  public static void register(IEventBus eventBus) {
    MOB_EFFECTS.register(eventBus);
  }
}
