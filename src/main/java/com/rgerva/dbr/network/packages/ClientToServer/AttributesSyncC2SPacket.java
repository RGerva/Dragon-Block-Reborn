/**
 * Record: AttributesSyncC2SPacket Immutable data structure for simplified object representation.
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
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import com.rgerva.dbr.mechanics.level.ModLevel;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AttributesSyncC2SPacket(Map<ModAttributes.Attributes, Float> attributes)
    implements CustomPacketPayload {
  public static final Type<AttributesSyncC2SPacket> ID =
      new Type<>(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "client_attributes"));

  public static final StreamCodec<RegistryFriendlyByteBuf, AttributesSyncC2SPacket> STREAM_CODEC =
      StreamCodec.ofMember(AttributesSyncC2SPacket::write, AttributesSyncC2SPacket::new);

  private static Map<ModAttributes.Attributes, Float> readMap(RegistryFriendlyByteBuf buf) {
    int size = buf.readVarInt();
    Map<ModAttributes.Attributes, Float> map = new EnumMap<>(ModAttributes.Attributes.class);
    for (int i = 0; i < size; i++) {
      ModAttributes.Attributes attr = ModAttributes.Attributes.valueOf(buf.readUtf());
      float value = buf.readFloat();
      map.put(attr, value);
    }
    return map;
  }

  public AttributesSyncC2SPacket(RegistryFriendlyByteBuf buf) {
    this(readMap(buf));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeVarInt(attributes.size());
    for (Map.Entry<ModAttributes.Attributes, Float> entry : attributes.entrySet()) {
      buf.writeUtf(entry.getKey().name());
      buf.writeFloat(entry.getValue());
    }
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  public static void handle(AttributesSyncC2SPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          if (!(context.player().level() instanceof ServerLevel level)
              || !(context.player() instanceof ServerPlayer player)) return;

          data.attributes.forEach(
              (attr, value) -> {
                ModPlayerData playerData = new ModPlayerData(player);
                playerData.setAttribute(attr, value);
              });
          ModPlayerData.setLevel(player, ModLevel.calculateLevel(player));
        });
  }
}
