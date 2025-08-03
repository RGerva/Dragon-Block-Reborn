package com.rgerva.dbr.network.packages;

import com.rgerva.dbr.DragonBlockReborn;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public record UpgradeAttributePacket(String attributeName) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<UpgradeAttributePacket> ID =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID,
                    "upgrade_attribute"));

    @Override
    public Type<UpgradeAttributePacket> type() {
        return ID;
    }

    public static UpgradeAttributePacket read(FriendlyByteBuf buf) {
        return new UpgradeAttributePacket(buf.readUtf());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeUtf(attributeName);
    }

    public void handle(ServerPlayer player) {
        CompoundTag tag = player.getPersistentData();

        String key = "dbr:" + attributeName.toLowerCase();
        int current = tag.getIntOr(key, 0);
        tag.putInt(key, current + 1); // Incrementa o atributo

        System.out.println("Upgrade no atributo " + attributeName + " → " + (current + 1));
    }
}

