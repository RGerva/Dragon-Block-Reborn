/**
 * Record: AttributesSyncS2CPacket Immutable data structure for simplified object representation.
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
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.data.ModPlayerData;
import java.util.EnumMap;
import java.util.Map;

import com.rgerva.dbr.mechanics.level.ModLevel;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AttributesSyncS2CPacket(Map<ModAttributes.Attributes, Float> attributes)
    implements CustomPacketPayload {

  public static final Type<AttributesSyncS2CPacket> ID =
      new Type<>(
          ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "sync_attributes"));

  public static final StreamCodec<RegistryFriendlyByteBuf, AttributesSyncS2CPacket> STREAM_CODEC =
      StreamCodec.ofMember(AttributesSyncS2CPacket::write, AttributesSyncS2CPacket::new);

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

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

  public AttributesSyncS2CPacket(RegistryFriendlyByteBuf buffer) {
    this(readMap(buffer));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeVarInt(attributes.size());
    for (Map.Entry<ModAttributes.Attributes, Float> entry : attributes.entrySet()) {
      buf.writeUtf(entry.getKey().name());
      buf.writeFloat(entry.getValue());
    }
  }

  public static void handle(AttributesSyncS2CPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          Player player = context.player();
          if (player == null || player.level().isClientSide()) return;

          data.attributes.forEach(
              (attr, value) -> {
                ModPlayerData playerData = new ModPlayerData(player);
                playerData.setAttribute(attr, value);
              });
          ModPlayerData.setLevel(player, ModLevel.calculateLevel(player));
        });
  }
}
