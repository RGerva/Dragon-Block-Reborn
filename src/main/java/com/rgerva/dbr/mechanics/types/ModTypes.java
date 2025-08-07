/**
 * Generic Class: ModTypes <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics.types;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;

public class ModTypes {
  public enum RaceType {
    HUMAN,
    SAIYAN,
    HALF_SAIYAN,
    NAMEKIAN,
    MAJIN,
    ARCOSIAN;

    public String getName() {
      return name();
    }

    public Component getFullName() {
      return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
    }
  }

  public enum ClassType {
    MARTIAL_ARTIST,
    SPIRITUALIST,
    WARRIOR;

    public String getName() {
      return name();
    }

    public Component getFullName() {
      return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
    }
  }

  public record RaceClassKey(RaceType race, ClassType clazz) {}
}
