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
import com.rgerva.dbr.gui.screen.ModStartScreen;
import com.rgerva.dbr.mechanics.ModStats;
import com.rgerva.dbr.network.ModMessages;
import com.rgerva.dbr.network.packages.OpenScreenSyncS2CPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ModCommands {

    public static void statsCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(
                Commands.literal("dbr")
                        .then(Commands.literal("open")
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    // Exemplo fictício de como extrair atributos
                                    CompoundTag tag = player.getPersistentData();
                                    ModStats.AttributeModifiers stats = new ModStats.AttributeModifiers(
                                            tag.getFloatOr("dbr:str", 0),
                                            tag.getFloatOr("dbr:dex",0),
                                            tag.getFloatOr("dbr:con",0),
                                            tag.getFloatOr("dbr:wil",0),
                                            tag.getFloatOr("dbr:mnd",0),
                                            tag.getFloatOr("dbr:spi",0)
                                    );

                                    // Envia o pacote com os atributos
                                    ModMessages.sendToPlayer(new OpenScreenSyncS2CPacket(stats), player);

                                    context.getSource().sendSuccess(() ->
                                            Component.literal("Abrindo tela com atributos..."), false);

                                    return Command.SINGLE_SUCCESS;
                                })
                        )
        );


    }
}
