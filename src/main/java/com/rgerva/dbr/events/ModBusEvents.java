/**
 * Generic Class: ModBusEvents <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.events;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.block.ModBlocks;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.block.entity.renderer.DragonBallEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID, value = Dist.CLIENT)
public class ModBusEvents {

  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    // Some client setup code
    DragonBlockReborn.LOGGER.info("HELLO FROM CLIENT SETUP");
    DragonBlockReborn.LOGGER.info(
        "MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

    BlockEntityRenderers.register(ModBlockEntities.DRAGON_BALL_ENTITY.get(),
            DragonBallEntityRenderer::new);
  }

  @SubscribeEvent
  public static void registerScreens(RegisterMenuScreensEvent event) {}

  @SubscribeEvent
  public static void registerParticleFactories(RegisterParticleProvidersEvent event) {}

}
