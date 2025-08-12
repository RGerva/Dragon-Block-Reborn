/**
 * Record: RaceClassSyncC2SPacket Immutable data structure for simplified object representation.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.network.packages.ClientToServer;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.types.ModTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record RaceClassSyncC2SPacket(ModTypes.RaceType raceType, ModTypes.ClassType classType)
    implements CustomPacketPayload {
  public static final Type<RaceClassSyncC2SPacket> ID =
      new Type<>(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "client_race_class"));

  public static final StreamCodec<RegistryFriendlyByteBuf, RaceClassSyncC2SPacket> STREAM_CODEC =
      StreamCodec.ofMember(RaceClassSyncC2SPacket::write, RaceClassSyncC2SPacket::new);

  public RaceClassSyncC2SPacket(RegistryFriendlyByteBuf buf) {
    this(buf.readEnum(ModTypes.RaceType.class), buf.readEnum(ModTypes.ClassType.class));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeEnum(raceType);
    buf.writeEnum(classType);
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  public static void handle(RaceClassSyncC2SPacket data, IPayloadContext context) {

    context.enqueueWork(
        () -> {
          if (!(context.player().level() instanceof ServerLevel)
              || !(context.player() instanceof ServerPlayer player)) return;

          ModPlayerData playerData = new ModPlayerData(player);
          playerData.setRace(data.raceType);
          playerData.setClass(data.classType);
        });
  }
}
