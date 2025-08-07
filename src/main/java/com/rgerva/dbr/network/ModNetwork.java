/**
 * Generic Class: ModNetwork <T> A generic structure that works with type parameters.
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

import com.rgerva.dbr.network.packages.ClientToServer.AttributesSyncC2SPacket;
import com.rgerva.dbr.network.packages.ClientToServer.RaceClassSyncC2SPacket;
import com.rgerva.dbr.network.packages.ClientToServer.StatsSyncC2SPacket;
import com.rgerva.dbr.network.packages.ServertToClient.AttributesSyncS2CPacket;
import com.rgerva.dbr.network.packages.ServertToClient.ChooseTypeScreenSyncS2CPacket;
import com.rgerva.dbr.network.packages.ServertToClient.RaceClassSyncS2CPacket;
import com.rgerva.dbr.network.packages.ServertToClient.StatsSyncS2CPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModNetwork {

  public static void register(final RegisterPayloadHandlersEvent event) {
    final PayloadRegistrar registrar = event.registrar("1.0");

    // Server -> Client
    registrar.playToClient(
        ChooseTypeScreenSyncS2CPacket.ID,
        ChooseTypeScreenSyncS2CPacket.STREAM_CODEC,
        ChooseTypeScreenSyncS2CPacket::handle);

    registrar.playToClient(
        AttributesSyncS2CPacket.ID,
        AttributesSyncS2CPacket.STREAM_CODEC,
        AttributesSyncS2CPacket::handle);

    registrar.playToClient(
        StatsSyncS2CPacket.ID, StatsSyncS2CPacket.STREAM_CODEC, StatsSyncS2CPacket::handle);

    registrar.playToClient(
        RaceClassSyncS2CPacket.ID,
        RaceClassSyncS2CPacket.STREAM_CODEC,
        RaceClassSyncS2CPacket::handle);

    // Client -> Server
    registrar.playToServer(
        AttributesSyncC2SPacket.ID,
        AttributesSyncC2SPacket.STREAM_CODEC,
        AttributesSyncC2SPacket::handle);

    registrar.playToServer(
        StatsSyncC2SPacket.ID, StatsSyncC2SPacket.STREAM_CODEC, StatsSyncC2SPacket::handle);

    registrar.playToServer(
        RaceClassSyncC2SPacket.ID,
        RaceClassSyncC2SPacket.STREAM_CODEC,
        RaceClassSyncC2SPacket::handle);
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

  public static void sendToAllPlayers(CustomPacketPayload message) {
    PacketDistributor.sendToAllPlayers(message);
  }
}
