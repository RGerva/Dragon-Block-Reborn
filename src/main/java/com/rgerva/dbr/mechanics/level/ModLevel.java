/**
 * Generic Class: ModLevel <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics.level;

import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.types.ModTypes;
import java.util.Map;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ModLevel {
  public enum ModDifficulty {
    EASY(2F),
    NORMAL(1F),
    HARD(0.05F),
    INSANE(0.01F);

    ModDifficulty(float modifier) {}

    public String getName() {
      return name();
    }

    public Component getFullName() {
      return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
    }
  }

  private static final int BASE_THRESHOLD = 55;
  private static final int POINTS_PER_LEVEL = 5;

  public static int calculateLevel(Player player) {
    if (player == null) return -1;

    Map<ModAttributes.Attributes, Float> attr = ModPlayerData.getMapAttributes(player);

    int total = 0;
    for (Float value : attr.values()) {
      total += value;
    }

    if (total <= BASE_THRESHOLD) {
      return 1;
    }

    return 1 + ((total - BASE_THRESHOLD) / POINTS_PER_LEVEL);
  }

  public static int calculateCombatTP(Player player, float powerRelease) {
    if (player == null) return -1;

    float mind = ModPlayerData.getAttribute(player, ModAttributes.Attributes.MND);
    if (powerRelease < 5) return 0;
    return 2 + (2 * ((int) mind / 5) * ((int) powerRelease / 100));
  }

  public static int calculateKiAttackBonus(String kiType) {
    return switch (kiType.toLowerCase()) {
      case "barrage" -> 1;
      case "wave", "ball", "disk", "laser", "spiral" -> 2;
      case "large_ball", "explosion" -> 3;
      default -> 0;
    };
  }

  private static float getRaceModifier(Player player) {
    return 0F;
    //		return switch (ModTypes.RaceType) {
    //			case ModTypes.RaceType.HUMAN, ModTypes.RaceType.NAMEKIAN -> 0.05f;
    //			default -> 0f;
    //		};
  }

  private static float getFormPenalty(int formLevel, ModTypes.RaceType race) {
    if (race != ModTypes.RaceType.ARCOSIAN) return 0f;
    return switch (formLevel) {
      case 3 -> 0.04f;
      case 4 -> 0.08f;
      case 5 -> 0.12f;
      case 6 -> 0.16f;
      default -> 0f;
    };
  }

  public static final int MINIGAME_DAILY_LIMIT_MULTIPLIER = 20;

  public static int getMinigameDailyLimit(int playerLevel) {
    return MINIGAME_DAILY_LIMIT_MULTIPLIER * playerLevel;
  }

  public static float calculateTPGainRateModifier(Player player) {

    //		float baseRate = 1.0f;
    //		float dex = ModPlayerData.getAttribute(player, ModAttributes.Attributes.DEX);
    //		float weight = stats.getWeight();
    //		float difficultyMod = getDifficultyModifier(stats.getDifficulty());
    //		float raceMod = getRaceModifier(player);
    //		float formMod = getFormPenalty(stats.getFormLevel(), stats.getRace());
    //
    //		float t = 1.0f + ((weight - (dex / 16f)) / (dex / 16f));
    //		return (baseRate + t - 1.0f + difficultyMod + raceMod - formMod);

    return 0F;
  }

  public static int applyTPGainRate(int baseTP, Player player) {
    return Math.round(baseTP * calculateTPGainRateModifier(player));
  }
}
