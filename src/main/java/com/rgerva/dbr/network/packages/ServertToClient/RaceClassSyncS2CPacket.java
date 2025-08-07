/**
 * Record: RaceClassSyncS2CPacket Immutable data structure for simplified object representation.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.network.packages.ServertToClient;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.types.ModTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record RaceClassSyncS2CPacket(ModTypes.RaceType raceType, ModTypes.ClassType classType)
    implements CustomPacketPayload {

  public static final Type<RaceClassSyncS2CPacket> ID =
      new Type<>(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "sync_race_class"));

  public static final StreamCodec<RegistryFriendlyByteBuf, RaceClassSyncS2CPacket> STREAM_CODEC =
      StreamCodec.ofMember(RaceClassSyncS2CPacket::write, RaceClassSyncS2CPacket::new);

  public RaceClassSyncS2CPacket(RegistryFriendlyByteBuf buffer) {
    this(buffer.readEnum(ModTypes.RaceType.class), buffer.readEnum(ModTypes.ClassType.class));
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeEnum(raceType);
    buf.writeEnum(classType);
  }

  public static void handle(RaceClassSyncS2CPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          if (context.player() == null || context.player().level().isClientSide()) return;

          ModPlayerData playerData = new ModPlayerData(context.player());
          playerData.setRace(data.raceType);
          playerData.setClass(data.classType);
        });
  }
}
