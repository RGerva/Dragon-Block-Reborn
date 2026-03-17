/**
 * Generic Class: ModBlocks <T>
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

package com.rgerva.dbr.block;

import com.rgerva.dbr.Dragon_Block_Reborn;
import com.rgerva.dbr.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Dragon_Block_Reborn.MOD_ID);

    public static final DeferredBlock<Block> GETE_BLOCK = registerBlock("gete_block",
            (properties) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .setId(id("gate_block"))));

    public static final DeferredBlock<Block> GETE_ORE = registerBlock("gete_debris_ore",
            (properties) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
                    .requiresCorrectToolForDrops()
                    .setId(id("gete_debris_ore"))));

    public static final DeferredBlock<Block> NAMEK_KIKONO_ORE = registerBlock("namek_kikono_ore",
            (properties) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
                    .requiresCorrectToolForDrops()
                    .setId(id("namek_kikono_ore"))));

    public static final DeferredBlock<Block> KIKONO_BLOCK = registerBlock("kikono_block",
            (properties) -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .setId(id("kikono_block"))));

    protected static ResourceKey<Block> id(@NotNull String path) {
        return ResourceKey.create(
                Registries.BLOCK, Identifier.fromNamespaceAndPath(Dragon_Block_Reborn.MOD_ID, path));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(
                name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
