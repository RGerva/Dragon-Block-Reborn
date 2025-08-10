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
import com.rgerva.dbr.datagen.model.custom.AuraModel;
import com.rgerva.dbr.datagen.model.custom.DragonBallModel;
import com.rgerva.dbr.entity.AuraEntity;
import com.rgerva.dbr.entity.AuraVariant;
import com.rgerva.dbr.entity.ModEntities;
import com.rgerva.dbr.entity.renderer.AuraEntityRenderer;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.level.ModLevel;
import com.rgerva.dbr.mechanics.stats.ModStats;
import com.rgerva.dbr.mechanics.types.ModTypes;
import java.util.Map;

import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.ClientToServer.AuraSyncC2SPackage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;
import org.lwjgl.glfw.GLFW;

import static com.rgerva.dbr.entity.ModEntities.AURA_ENTITY;

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

			EntityRenderers.register(AURA_ENTITY.get(), AuraEntityRenderer::new);
  }

  @SubscribeEvent
  private static void onLivingJump(LivingEvent.LivingJumpEvent event) {
    LivingEntity entity = event.getEntity();
    if (!entity.level().isClientSide()) {
      Player player = (Player) entity;

      ModTypes.RaceType race = ModPlayerData.getRace(player);
      DragonBlockReborn.LOGGER.info("RACE: {}", race);

      ModTypes.ClassType clazz = ModPlayerData.getClass(player);
      DragonBlockReborn.LOGGER.info("CLASS: {}", clazz);

      Map<ModAttributes.Attributes, Float> attr = ModPlayerData.getMapAttributes(player);
      DragonBlockReborn.LOGGER.info("ATTR: {}", attr);

      Map<ModStats.Stats, Float> stats = ModPlayerData.getMapStats(player);
      DragonBlockReborn.LOGGER.info("STATS: {}", stats);
    }
  }

  @SubscribeEvent
  public static void onPlayerTick(PlayerTickEvent.Post event) {
      Player player = event.getEntity();
      if(ModLevel.hasAvailableFreePoints(player)){
          DragonBlockReborn.LOGGER.info("HAS POINTS: {}", ModLevel.getAvailableFreePoints(player));
      }
			AuraEntity entity = new AuraEntity(AURA_ENTITY.get(), event.getEntity().level());
			if(toggleAura.isDown()){
					entity.setActiveAndSync(true);
			}else {
					entity.setActiveAndSync(false);
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

			event.registerEntityRenderer(ModEntities.AURA_ENTITY.get(), AuraEntityRenderer::new);
  }

  @SubscribeEvent
  public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(DragonBallModel.LAYER_LOCATION, DragonBallModel::createBodyLayer);
    event.registerLayerDefinition(AuraModel.LAYER_LOCATION, AuraModel::createBodyLayer);
  }

  @SubscribeEvent
  public static void registerScreens(RegisterMenuScreensEvent event) {}

  @SubscribeEvent
  public static void registerParticleFactories(RegisterParticleProvidersEvent event) {}

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public static void onCommandsRegister(RegisterCommandsEvent event) {
    ConfigCommand.register(event.getDispatcher());
    ModCommands.statsCommand(event.getDispatcher());
		ModCommands.getLevel(event.getDispatcher());
    ModCommands.setLevel(event.getDispatcher());
  }

	public static KeyMapping toggleAura;
	@SubscribeEvent
		public static void registerKeyBindings(RegisterKeyMappingsEvent event){
			toggleAura = new KeyMapping(Component.literal("Aura").toString(), GLFW.GLFW_KEY_TAB, "key.categories.creative");
			event.register(toggleAura);
	}
}
