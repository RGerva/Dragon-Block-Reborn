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
import java.util.Map;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ModLevel {
  public enum ModDifficulty {
    EASY(2F),
    NORMAL(1F),
    HARD(0.05F),
    INSANE(0.01F);

    private final float modifier;

    ModDifficulty(float modifier) {
      this.modifier = modifier;
    }

    public float getModifier() {
      return modifier;
    }

    public String getName() {
      return name();
    }

    public Component getFullName() {
      return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
    }
  }

  public static int calculateLevel(Player player) {
    Map<ModAttributes.Attributes, Float> attributesMap = ModPlayerData.getMapAttributes(player);
    float total = 0f;
    for (ModAttributes.Attributes attr : ModAttributes.Attributes.values()) {
      total += attributesMap.getOrDefault(attr, ModAttributes.Attributes.getDefaultValue());
    }

    if (total <= 55f) return 1;
    return 1 + (int) ((total - 55f) / 5f);
  }

  public static int getMaxDailyTP(int level) {
    return 20 * level;
  }

  public static int getAvailableFreePoints(Player player) {
    int level = ModPlayerData.getLevel(player);
    int spent = ModPlayerData.getSpentPoints(player);

    int totalPoints = level / 5;
    return Math.max(0, totalPoints - spent);
  }

  public static boolean hasAvailableFreePoints(Player player) {
    return getAvailableFreePoints(player) > 0;
  }

  public static boolean spendFreePoint(Player player, ModAttributes.Attributes targetAttribute) {
    int available = getAvailableFreePoints(player);
    if (available <= 0) return false;

    float current = ModPlayerData.getAttribute(player, targetAttribute);
    ModPlayerData.setAttribute(player, targetAttribute, current + 1f);

    int spent = ModPlayerData.getSpentPoints(player);
    ModPlayerData.setSpentPoints(player, spent + 1);

    return true;
  }
}
