/**
 * Generic Class: ModSounds <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.sound;

import com.rgerva.dbr.DragonBlockReborn;
import java.util.function.Supplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
  public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
      DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, DragonBlockReborn.MOD_ID);

  public static final Supplier<SoundEvent> DRAGON_GLOW = registerSoundEvent("dragon_glow");
  public static final Supplier<SoundEvent> DRAGON_FLY = registerSoundEvent("dragon_fly");
  public static final Supplier<SoundEvent> DRAGON_GRANT = registerSoundEvent("dragon_grant");
  public static final Supplier<SoundEvent> DRAGON_MAKEONE = registerSoundEvent("dragon_makeone");

  public static final Supplier<SoundEvent> SPARK = registerSoundEvent("spark");

  private static ResourceKey<JukeboxSong> createSong(String name) {
    return ResourceKey.create(
        Registries.JUKEBOX_SONG,
        ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name));
  }

  private static Supplier<SoundEvent> registerSoundEvent(String name) {
    ResourceLocation id = ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, name);
    return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
  }

  public static void register(IEventBus eventBus) {
    SOUND_EVENTS.register(eventBus);
  }
}
