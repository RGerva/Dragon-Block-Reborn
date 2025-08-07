/**
 * Record: StatsSyncC2SPacket Immutable data structure for simplified object representation.
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
import com.rgerva.dbr.mechanics.stats.ModStats;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record StatsSyncC2SPacket(Map<ModStats.Stats, Float> stats) implements CustomPacketPayload {
  public static final Type<StatsSyncC2SPacket> ID =
      new Type<>(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "client_stats"));

  public static final StreamCodec<RegistryFriendlyByteBuf, StatsSyncC2SPacket> STREAM_CODEC =
      StreamCodec.ofMember(StatsSyncC2SPacket::write, StatsSyncC2SPacket::new);

  private static Map<ModStats.Stats, Float> readMap(RegistryFriendlyByteBuf buf) {
    int size = buf.readVarInt();
    Map<ModStats.Stats, Float> map = new EnumMap<>(ModStats.Stats.class);
    for (int i = 0; i < size; i++) {
      ModStats.Stats attr = ModStats.Stats.valueOf(buf.readUtf());
      float value = buf.readFloat();
      map.put(attr, value);
    }
    return map;
  }

  public StatsSyncC2SPacket(RegistryFriendlyByteBuf buf) {
    this(readMap(buf));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeVarInt(stats.size());
    for (Map.Entry<ModStats.Stats, Float> entry : stats.entrySet()) {
      buf.writeUtf(entry.getKey().name());
      buf.writeFloat(entry.getValue());
    }
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  public static void handle(StatsSyncC2SPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          if (!(context.player().level() instanceof ServerLevel level)
              || !(context.player() instanceof ServerPlayer player)) return;

          data.stats.forEach(
              (str, value) -> {
                ModPlayerData playerData = new ModPlayerData(player);
                playerData.setStats(str, value);
              });
        });
  }
}
