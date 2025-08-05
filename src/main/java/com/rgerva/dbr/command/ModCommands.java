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
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

public class ModCommands {

    public static void statsCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(
                Commands.literal("dbr")
                        .then(Commands.literal("restALL")
                                .requires(ctx -> ctx.hasPermission(0))
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    ModPlayerData playerData = new ModPlayerData(player);
                                    playerData.restAttributes();
                                    return Command.SINGLE_SUCCESS;
                                })
                        )
        );
    }
}
