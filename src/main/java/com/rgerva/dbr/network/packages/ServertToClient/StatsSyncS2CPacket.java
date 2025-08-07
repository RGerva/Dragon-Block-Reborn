/**
 * Record: StatsSyncS2CPacket Immutable data structure for simplified object representation.
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
import com.rgerva.dbr.mechanics.stats.ModStats;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record StatsSyncS2CPacket(Map<ModStats.Stats, Float> stats) implements CustomPacketPayload {

  public static final Type<StatsSyncS2CPacket> ID =
      new Type<>(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "sync_stats"));

  public static final StreamCodec<RegistryFriendlyByteBuf, StatsSyncS2CPacket> STREAM_CODEC =
      StreamCodec.ofMember(StatsSyncS2CPacket::write, StatsSyncS2CPacket::new);

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  private static Map<ModStats.Stats, Float> readMap(RegistryFriendlyByteBuf buf) {
    int size = buf.readVarInt();
    Map<ModStats.Stats, Float> map = new EnumMap<>(ModStats.Stats.class);
    for (int i = 0; i < size; i++) {
      ModStats.Stats stats = ModStats.Stats.valueOf(buf.readUtf());
      float value = buf.readFloat();
      map.put(stats, value);
    }
    return map;
  }

  public StatsSyncS2CPacket(RegistryFriendlyByteBuf buffer) {
    this(readMap(buffer));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeVarInt(stats.size());
    for (Map.Entry<ModStats.Stats, Float> entry : stats.entrySet()) {
      buf.writeUtf(entry.getKey().name());
      buf.writeFloat(entry.getValue());
    }
  }

  public static void handle(StatsSyncS2CPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          Player player = context.player();
          if (player == null || player.level().isClientSide()) return;

          data.stats.forEach(
              (str, value) -> {
                ModPlayerData playerData = new ModPlayerData(player);
                playerData.setStats(str, value);
              });
        });
  }
}
