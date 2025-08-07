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
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@EventBusSubscriber(modid = DragonBlockReborn.MOD_ID)
public class ModGameEvents {

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public static void onCommandsRegister(RegisterCommandsEvent event) {
    ConfigCommand.register(event.getDispatcher());
    //    ModCommands.statsCommand(event.getDispatcher());
  }
}
