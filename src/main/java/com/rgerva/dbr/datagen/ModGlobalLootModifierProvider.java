/**
 * Generic Class: ModGlobalLootModifierProvider <T> A generic structure that works with type
 * parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.datagen;

import com.rgerva.dbr.DragonBlockReborn;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
  public ModGlobalLootModifierProvider(
      PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    super(output, registries, DragonBlockReborn.MOD_ID);
  }

  @Override
  protected void start() {}
}
