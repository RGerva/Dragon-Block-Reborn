/**
 * Generic Class: ModDataGenerators <T>
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
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Dragon_Block_Reborn.MOD_ID)
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                true,
                new LootTableProvider(
                        packOutput,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                        lookupProvider));

        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModModelProvider(packOutput));

        generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModGlobalLootModifierProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModEquipmentProvider(packOutput));

        generator.addProvider(true, new ModSpriteProvider(packOutput, lookupProvider));
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                true,
                new LootTableProvider(
                        packOutput,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                        lookupProvider));

        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModModelProvider(packOutput));

        generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModGlobalLootModifierProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModEquipmentProvider(packOutput));

        generator.addProvider(true, new ModSpriteProvider(packOutput, lookupProvider));
    }
}
