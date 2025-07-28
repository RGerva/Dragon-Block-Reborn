/**
 * Generic Class: ModItemTagProvider <T> A generic structure that works with type parameters.
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
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

public class ModItemTagProvider extends ItemTagsProvider {
  public ModItemTagProvider(
      PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(output, lookupProvider, DragonBlockReborn.MOD_ID);
  }

  @Override
  protected void addTags(HolderLookup.@NotNull Provider provider) {}
}
