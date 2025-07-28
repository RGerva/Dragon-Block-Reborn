/**
 * Generic Class: ModGameEvents <T> A generic structure that works with type parameters.
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID, value = Dist.DEDICATED_SERVER)
public class ModGameEvents {

  @SubscribeEvent
  public static void onCommandsRegister(RegisterCommandsEvent event) {
    ConfigCommand.register(event.getDispatcher());
  }
}
