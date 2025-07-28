/**
 * Generic Class: ModBiomeModifiers <T> A generic structure that works with type parameters. A
 * generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.worldgen;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.util.ModOresUtils;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

  public static List<ResourceKey<BiomeModifier>> OVERWORLD_ADD_ORE = new ArrayList<>();
  public static List<ResourceKey<BiomeModifier>> NETHER_ADD_ORE = new ArrayList<>();
  public static List<ResourceKey<BiomeModifier>> END_ADD_ORE = new ArrayList<>();

  public static void bootstrap(BootstrapContext<BiomeModifier> context) {

    registerAllKey();

    var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
    var biomes = context.lookup(Registries.BIOME);

    for (int x = 0; x < ModOresUtils.getOres().size(); x++) {
      context.register(
          OVERWORLD_ADD_ORE.get(x),
          new BiomeModifiers.AddFeaturesBiomeModifier(
              biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_PLACED_KEY.get(x))),
              GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    for (int x = 0; x < ModOresUtils.getOres().size(); x++) {
      context.register(
          NETHER_ADD_ORE.get(x),
          new BiomeModifiers.AddFeaturesBiomeModifier(
              biomes.getOrThrow(BiomeTags.IS_NETHER),
              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_PLACED_KEY.get(x))),
              GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    for (int x = 0; x < ModOresUtils.getOres().size(); x++) {
      context.register(
          END_ADD_ORE.get(x),
          new BiomeModifiers.AddFeaturesBiomeModifier(
              biomes.getOrThrow(BiomeTags.IS_END),
              HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_PLACED_KEY.get(x))),
              GenerationStep.Decoration.UNDERGROUND_ORES));
    }
  }

  private static void registerAllKey() {}

  private static ResourceKey<BiomeModifier> registerKey(String name) {
    return ResourceKey.create(
        NeoForgeRegistries.Keys.BIOME_MODIFIERS,
        ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name));
  }
}
