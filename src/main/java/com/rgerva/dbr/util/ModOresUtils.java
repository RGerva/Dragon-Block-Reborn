/**
 * Generic Class: ModOresUtils <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.world.level.block.Block;

public class ModOresUtils {
  public record ModBlockVeinProperties(int veinSize, int minY, int maxY, int count) {}

  private static final Map<Block, ModBlockVeinProperties> blockPropertiesMap = new HashMap<>();

  public static void addProperties(Block block, int veinSize, int minY, int maxY, int count) {
    ModBlockVeinProperties properties = new ModBlockVeinProperties(veinSize, minY, maxY, count);
    blockPropertiesMap.put(block, properties);
  }

  public static ModBlockVeinProperties getProperties(Block block) {
    return blockPropertiesMap.get(block);
  }

  public static boolean hasProperties(Block block) {
    return blockPropertiesMap.containsKey(block);
  }

  public static void setOresProperties() {}

  public static List<Block> getOres() {
    return null;
  }

  public static List<Block> getDeepslateOre() {
    return null;
  }

  public static List<Block> getNetherOre() {
    return null;
  }

  public static List<Block> getEndOre() {
    return null;
  }
}
