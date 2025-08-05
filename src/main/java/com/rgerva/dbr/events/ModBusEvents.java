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
import com.rgerva.dbr.attachment.ModAttachments;
import com.rgerva.dbr.block.entity.ModBlockEntities;
import com.rgerva.dbr.block.entity.renderer.DragonBallEntityRenderer;
import com.rgerva.dbr.command.ModCommands;
import com.rgerva.dbr.datagen.model.custom.DragonBallModel;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.stats.ModStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID, value = Dist.CLIENT)
public class ModBusEvents {

  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    // Some client setup code
    DragonBlockReborn.LOGGER.info("HELLO FROM CLIENT SETUP");
    DragonBlockReborn.LOGGER.info(
        "MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

    BlockEntityRenderers.register(
        ModBlockEntities.DRAGON_BALL_ENTITY.get(), DragonBallEntityRenderer::new);
  }

  @SubscribeEvent
  public static void onPlayerTick(PlayerTickEvent.Post event) {
      if(event.getEntity().isLocalPlayer()){
          ModPlayerData playerData = new ModPlayerData(event.getEntity());
          float type = playerData.getStats(ModStats.Stats.MELEE_DAMAGE);
          DragonBlockReborn.LOGGER.info("See Type MELEE:{}", type);
      }
  }

  @SubscribeEvent
  public static void onClone(PlayerEvent.Clone event) {
      if (event.isWasDeath()) {
          Player original = event.getOriginal();
          Player clone = event.getEntity();

          for (ModAttributes.Attributes attr : ModAttributes.Attributes.values()) {
              AttachmentType<Float> attachmentType = ModAttachments.ATTRIBUTES.get(attr).get();
              Float originalValue = original.getData(attachmentType);
              clone.setData(attachmentType, originalValue);
          }
      }
  }

  @SubscribeEvent
  public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
    event.registerBlockEntityRenderer(
        ModBlockEntities.DRAGON_BALL_ENTITY.get(), DragonBallEntityRenderer::new);
  }

  @SubscribeEvent
  public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(DragonBallModel.LAYER_LOCATION, DragonBallModel::createBodyLayer);
  }

  @SubscribeEvent
  public static void registerScreens(RegisterMenuScreensEvent event) {}

  @SubscribeEvent
  public static void registerParticleFactories(RegisterParticleProvidersEvent event) {}

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public static void onCommandsRegister(RegisterCommandsEvent event) {
    ConfigCommand.register(event.getDispatcher());
    ModCommands.statsCommand(event.getDispatcher());
  }
}
