/**
 * Generic Class: ModAttachments <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.attachment;

import com.mojang.serialization.Codec;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.stats.ModStats;
import com.rgerva.dbr.mechanics.types.ModTypes;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.world.entity.animal.Cod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModAttachments {
  private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
      DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, DragonBlockReborn.MOD_ID);

  public static final Supplier<AttachmentType<Float>> TP =
      ATTACHMENT_TYPES.register(
          "tp",
          () ->
              AttachmentType.builder(() -> 0F)
                  .serialize(Codec.FLOAT.fieldOf("tp"))
                  .copyOnDeath()
                  .build());

  public static final Supplier<AttachmentType<String>> RACE_TYPE =
      ATTACHMENT_TYPES.register(
          "race_type",
          () -> AttachmentType.builder(() -> ModTypes.RaceType.HUMAN.getName().toUpperCase())
				  .serialize(Codec.STRING.fieldOf("race_type")).copyOnDeath().build());

  public static final Supplier<AttachmentType<String>> CLASS_TYPE =
      ATTACHMENT_TYPES.register(
          "class_type",
          () ->
              AttachmentType.builder(() -> ModTypes.ClassType.MARTIAL_ARTIST.getName().toUpperCase())
					  .serialize(Codec.STRING.fieldOf("class_type")).copyOnDeath().build());

  public static final Map<ModAttributes.Attributes, Supplier<AttachmentType<Float>>> ATTRIBUTES =
      new EnumMap<>(ModAttributes.Attributes.class);

  static {
    for (ModAttributes.Attributes attr : ModAttributes.Attributes.values()) {
      ATTRIBUTES.put(
          attr,
          ATTACHMENT_TYPES.register(
              attr.name().toLowerCase(),
              () ->
                  AttachmentType.builder(ModAttributes.Attributes::getDefaultValue)
                      .serialize(Codec.FLOAT.fieldOf(attr.name()))
                      .build()));
    }
  }

  public static final Map<ModStats.Stats, Supplier<AttachmentType<Float>>> STATS =
      new EnumMap<>(ModStats.Stats.class);

  static {
    for (ModStats.Stats stats : ModStats.Stats.values()) {
      STATS.put(
          stats,
          ATTACHMENT_TYPES.register(
              stats.name().toLowerCase(),
              () ->
                  AttachmentType.builder(() -> 0F)
                      .serialize(Codec.FLOAT.fieldOf(stats.name()))
                      .build()));
    }
  }

  public static final Supplier<AttachmentType<Integer>> LVL =
      ATTACHMENT_TYPES.register(
          "lvl",
          () ->
              AttachmentType.builder(() -> 0)
                  .serialize(Codec.INT.fieldOf("lvl"))
                  .copyOnDeath()
                  .build());

    public static final Supplier<AttachmentType<Integer>> SPENT_POINTS =
            ATTACHMENT_TYPES.register(
                    "spent_points",
                    () ->
                            AttachmentType.builder(() -> 0)
                                    .serialize(Codec.INT.fieldOf("spent_points"))
                                    .copyOnDeath()
                                    .build());

  public static void register(IEventBus eventBus) {
    ATTACHMENT_TYPES.register(eventBus);
  }
}
