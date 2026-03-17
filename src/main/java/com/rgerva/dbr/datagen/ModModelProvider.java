/**
 * Generic Class: ModModelProvider <T>
 * A generic structure that works with type parameters.
 *
 * <p>Created by: bb785
 * <p>On: 2026/mar.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2026 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the GNU General Public License, Version 3.0.
 */

package com.rgerva.dbr.datagen;

import com.rgerva.dbr.Dragon_Block_Reborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, Dragon_Block_Reborn.MOD_ID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        registerBlock(blockModels);
        registerItem(itemModels);
    }

    private void registerItem(ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.GETE_SCRAP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GETE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.KIKONO_SHARD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.KIKONO_STICK.get(), ModelTemplates.FLAT_ITEM);
    }

    private void registerBlock(BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(ModBlocks.GETE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.GETE_ORE.get()); // TODO Create a custom cube
        blockModels.createTrivialCube(ModBlocks.KIKONO_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.NAMEK_KIKONO_ORE.get());
    }

    @Override
    protected @NonNull Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }

    @Override
    protected @NonNull Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }
}
