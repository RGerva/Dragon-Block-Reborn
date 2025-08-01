/**
 * Generic Class: ModBlocks <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.block;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.block.custom.DragonBallBlock;
import com.rgerva.dbr.item.ModItems;
import java.util.function.Function;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ModBlocks {

  public static final DeferredRegister.Blocks BLOCKS =
      DeferredRegister.createBlocks(DragonBlockReborn.MOD_ID);

  public static final DeferredBlock<Block> DRAGON_BALL_BLOCK =
      registerBlock(
          "dragon_ball",
          (properties ->
              new DragonBallBlock(BlockBehaviour.Properties.of().setId(id("dragon_ball")))),
          new Item.Properties().setId(ModItems.id("dragon_ball")).stacksTo(7));

  protected static ResourceKey<Block> id(@NotNull String path) {
    return ResourceKey.create(
        Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, path));
  }

  private static <T extends Block> DeferredBlock<T> registerBlock(
      String name, Function<BlockBehaviour.Properties, T> function) {
    DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> DeferredBlock<T> registerBlock(
      String name,
      Function<BlockBehaviour.Properties, T> function,
      Item.Properties itemProperties) {
    DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
    registerBlockItem(name, toReturn, itemProperties);
    return toReturn;
  }

  private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    ModItems.ITEMS.registerItem(
        name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
  }

  private static <T extends Block> void registerBlockItem(
      String name, DeferredBlock<T> block, Item.Properties itemProperties) {
    ModItems.ITEMS.registerItem(
        name,
        (properties) -> new BlockItem(block.get(), itemProperties.useBlockDescriptionPrefix()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
