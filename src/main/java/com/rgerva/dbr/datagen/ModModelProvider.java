/**
 * Generic Class: ModModelProvider <T> A generic structure that works with type parameters.
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
import com.rgerva.dbr.block.ModBlocks;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

import com.rgerva.dbr.datagen.model.ModTexturedModel;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelProvider extends ModelProvider {
  static BlockModelGenerators blockModelGenerator;
  static BiConsumer<ResourceLocation, ModelInstance> modelOutput;

  public ModModelProvider(PackOutput output) {
    super(output, DragonBlockReborn.MOD_ID);
  }

  @Override
  protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
    blockModelGenerator = blockModels;
    modelOutput = blockModels.modelOutput;

    registerBlock(blockModels);
    registerItem(itemModels);
  }

  protected void registerItem(ItemModelGenerators itemModels) {}

  protected void registerBlock(BlockModelGenerators blockModels) {
    createCutoutBlockWithItem(ModBlocks.DRAGON_BALL_BLOCK);
    createCutoutBlockWithItem(ModBlocks.DRAGON_BALL_STONE);
  }

  protected void createCutoutBlockWithItem(Holder<Block> block){
    ResourceLocation model =
            ModTexturedModel.DRAGON_BALL_MODEL.get(block.value()).create(block.value(), modelOutput);

    blockModelGenerator.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(
                    block.value(), new MultiVariant(WeightedList.of(new Variant(model)))));

    blockModelGenerator.registerSimpleItemModel(block.value(), model);
  }

  private void horizontalBlockWithItem(
      Holder<Block> block, boolean uniqueBottomTexture, boolean uniqueFrontTexture) {
    ResourceLocation model =
        TexturedModel.createDefault(
                unused ->
                    new TextureMapping()
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block.value(), "_top"))
                        .put(
                            TextureSlot.BOTTOM,
                            TextureMapping.getBlockTexture(
                                block.value(), uniqueBottomTexture ? "_bottom" : "_top"))
                        .put(
                            TextureSlot.FRONT,
                            TextureMapping.getBlockTexture(
                                block.value(), uniqueFrontTexture ? "_front" : "_side"))
                        .put(
                            TextureSlot.SIDE,
                            TextureMapping.getBlockTexture(block.value(), "_side"))
                        .copySlot(TextureSlot.TOP, TextureSlot.PARTICLE),
                ModelTemplates.CUBE_ORIENTABLE_TOP_BOTTOM)
            .get(block.value())
            .create(block.value(), modelOutput);

    if (uniqueFrontTexture) {
      blockModelGenerator.blockStateOutput.accept(
          MultiVariantGenerator.dispatch(
                  block.value(), new MultiVariant(WeightedList.of(new Variant(model))))
              .with(
                  PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                      .select(Direction.NORTH, BlockModelGenerators.NOP)
                      .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
                      .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
                      .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)));
    } else {
      blockModelGenerator.blockStateOutput.accept(
          MultiVariantGenerator.dispatch(
              block.value(), new MultiVariant(WeightedList.of(new Variant(model)))));
    }

    blockModelGenerator.registerSimpleItemModel(block.value(), model);
  }

}
