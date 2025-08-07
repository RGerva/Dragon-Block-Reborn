/**
 * Generic Class: ModCommands <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.level.ModLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

public class ModCommands {

  public static void statsCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
        Commands.literal("dbr")
            .then(
                Commands.literal("restALL")
                    .requires(ctx -> ctx.hasPermission(0))
                    .executes(
                        context -> {
                          ServerPlayer player = context.getSource().getPlayerOrException();

                          ModPlayerData playerData = new ModPlayerData(player);
                          playerData.restAttributes();
                          return Command.SINGLE_SUCCESS;
                        })));
  }

  public static void getLevel(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
        Commands.literal("dbr")
            .then(
                Commands.literal("level")
                    .requires(ctx -> ctx.hasPermission(0))
                    .executes(
                        context -> {
                          ServerPlayer player = context.getSource().getPlayerOrException();
                          DragonBlockReborn.LOGGER.info(
                              "Level: {}", ModLevel.calculateLevel(player));
                          return Command.SINGLE_SUCCESS;
                        })));
  }

  public static void setLevel(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(
        Commands.literal("dbr")
            .then(
                Commands.literal("setlevel")
                    .then(
                        Commands.argument("value", IntegerArgumentType.integer())
                            .requires(ctx -> ctx.hasPermission(0))
                            .executes(
                                context -> {
                                  int valor = IntegerArgumentType.getInteger(context, "value");
                                  ServerPlayer player = context.getSource().getPlayerOrException();
                                  ModPlayerData.setLevel(player, valor);
                                  return Command.SINGLE_SUCCESS;
                                }))));
  }
}
