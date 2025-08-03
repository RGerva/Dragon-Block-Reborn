/**
 * Generic Class: ModMessages <T> A generic structure that works with type parameters.
 *
 * <p>Created by: rgerv On: 2025/jul.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.network;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.gui.screen.ModStartScreen;
import com.rgerva.dbr.network.packages.OpenScreenSyncS2CPacket;
import com.rgerva.dbr.network.packages.UpgradeAttributePacket;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModMessages {

  public static void register(final RegisterPayloadHandlersEvent event) {
    final PayloadRegistrar registrar = event.registrar("1.0");

    registrar.playToClient(
            OpenScreenSyncS2CPacket.TYPE,
            OpenScreenSyncS2CPacket.STREAM_CODEC,
            OpenScreenSyncS2CPacket::handle
    );

//    registrar.playToServer(
//            UpgradeAttributePacket.ID,
//            UpgradeAttributePacket::read,
//            UpgradeAttributePacket::write,
//            UpgradeAttributePacket::handle
//    );

  }

  public static void sendToServer(CustomPacketPayload message) {
    ClientPacketDistributor.sendToServer(message);
  }

  public static void sendToPlayer(CustomPacketPayload message, ServerPlayer player) {
    PacketDistributor.sendToPlayer(player, message);
  }

  public static void sendToPlayersWithinXBlocks(
      CustomPacketPayload message, BlockPos pos, ServerLevel level, int distance) {
    PacketDistributor.sendToPlayersNear(
        level, null, pos.getX(), pos.getY(), pos.getZ(), distance, message);
  }
}
