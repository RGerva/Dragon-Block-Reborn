/**
 * Generic Class: ModTags <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.tags;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
  public static class Blocks {

    private static TagKey<Block> createTag(String name) {
      return BlockTags.create(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name));
    }
  }

  public static class Items {

    private static TagKey<Item> createTag(String name) {
      return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name));
    }
  }
}
