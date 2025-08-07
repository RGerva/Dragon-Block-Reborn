/**
 * Record: OpenFirstScreenSyncS2CPacket Immutable data structure for simplified object
 * representation.
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
import com.rgerva.dbr.gui.screen.ChooseTypeScreen;
import com.rgerva.dbr.mechanics.types.ModTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ChooseTypeScreenSyncS2CPacket(
    ModTypes.RaceType raceType, ModTypes.ClassType classType) implements CustomPacketPayload {

  public static final Type<ChooseTypeScreenSyncS2CPacket> ID =
      new Type<>(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "choose_type"));

  public static final StreamCodec<RegistryFriendlyByteBuf, ChooseTypeScreenSyncS2CPacket>
      STREAM_CODEC =
          StreamCodec.ofMember(
              ChooseTypeScreenSyncS2CPacket::write, ChooseTypeScreenSyncS2CPacket::new);

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return ID;
  }

  public ChooseTypeScreenSyncS2CPacket(RegistryFriendlyByteBuf buffer) {
    this(ModTypes.RaceType.valueOf(buffer.readUtf()), ModTypes.ClassType.valueOf(buffer.readUtf()));
  }

  public void write(RegistryFriendlyByteBuf buf) {
    buf.writeUtf(raceType.name());
    buf.writeUtf(classType.name());
  }

  public static void handle(ChooseTypeScreenSyncS2CPacket data, IPayloadContext context) {
    context.enqueueWork(
        () -> {
          if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance()
                .setScreen(
                    new ChooseTypeScreen(
                        Minecraft.getInstance().player, data.raceType(), data.classType()));
          }
        });
  }
}
