/**
 * Generic Class: ModItems <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.item;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModItems {

  public static final DeferredRegister.Items ITEMS =
      DeferredRegister.createItems(DragonBlockReborn.MOD_ID);

  protected static ResourceKey<Item> id(@NotNull String path) {
    return ResourceKey.create(
        Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, path));
  }

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
