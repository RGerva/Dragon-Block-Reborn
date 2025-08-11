/**
 * Generic Class: ModEntities <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.entity;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.entity.entity.AuraEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, DragonBlockReborn.MOD_ID);

	public static ResourceKey<EntityType<?>> AURA_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("aura"));

  public static final Supplier<EntityType<AuraEntity>> AURA_ENTITY =
      ENTITY_TYPES.register(
          "aura_entity",
          () ->
              EntityType.Builder.of(AuraEntity::new, MobCategory.MISC)
                  .sized(0.5f, 0.5f)
                  .clientTrackingRange(64)
                  .updateInterval(1)
                  .build(AURA_KEY));

		public static final Supplier<EntityType<EntityAura>> AURA =
						ENTITY_TYPES.register("aura_new_entity", () -> EntityType.Builder.of(EntityAura::new, MobCategory.MISC)
										.sized(0.5f, 0.5f).clientTrackingRange(64).updateInterval(1).build(AURA_KEY));

		public static void register(IEventBus eventBus) {
    ENTITY_TYPES.register(eventBus);
  }
}
