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
package com.rgerva.dbr.network.packages;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.mechanics.ModPlayerData;
import com.rgerva.dbr.mechanics.ModTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.HashMap;
import java.util.Map;

public record AttributesSyncS2CPacket(Map<ModTypes.Attributes, Float> visualAttributes) implements CustomPacketPayload {

    public static final Type<AttributesSyncS2CPacket> ID =
            new Type<>(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID,
                    "update_attributes"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AttributesSyncS2CPacket> STREAM_CODEC =
            StreamCodec.ofMember(AttributesSyncS2CPacket::write, AttributesSyncS2CPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }

    public static Map<ModTypes.Attributes, Float> readAttributeMap(RegistryFriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        Map<ModTypes.Attributes, Float> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String keyStr = buffer.readUtf();
            float value = buffer.readFloat();
            ModTypes.Attributes key = ModTypes.Attributes.valueOf(keyStr);
            map.put(key, value);
        }
        return map;
    }


    public AttributesSyncS2CPacket(RegistryFriendlyByteBuf buffer){
        this(readAttributeMap(buffer));
    }

    public void write(RegistryFriendlyByteBuf buf) {
        buf.writeVarInt(visualAttributes.size());
        for (Map.Entry<ModTypes.Attributes, Float> entry : visualAttributes.entrySet()) {
            buf.writeUtf(entry.getKey().name());
            buf.writeFloat(entry.getValue());
        }

    }

    public static void handle(AttributesSyncS2CPacket data, IPayloadContext context){
        context.enqueueWork(() -> {
            Player player = context.player();
            ModPlayerData.saveData(player, data.visualAttributes);
        });

    }
}
