/**
 * Generic Class: ModCreativeTab <T>
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

package com.rgerva.dbr.creative;

import com.rgerva.dbr.Dragon_Block_Reborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Dragon_Block_Reborn.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TAB.register("tab_dragon_block_reborn",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GETE_INGOT.get()))
                    .title(Component.translatable("itemGroup.dragon_block_reborn"))
                    .displayItems(
                            ((itemDisplayParameters, output) -> {
                                output.accept(ModItems.GETE_SCRAP.get());
                                output.accept(ModItems.GETE_INGOT.get());
                                output.accept(ModItems.KIKONO_SHARD.get());
                                output.accept(ModItems.KIKONO_STICK.get());

                                output.accept(ModBlocks.GETE_BLOCK.get());
                                output.accept(ModBlocks.GETE_ORE.get());
                                output.accept(ModBlocks.KIKONO_BLOCK.get());
                                output.accept(ModBlocks.NAMEK_KIKONO_ORE.get());
                            }))
                    .build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
