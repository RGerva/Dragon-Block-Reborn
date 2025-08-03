package com.rgerva.dbr.network.packages;

import com.rgerva.dbr.DragonBlockReborn;
import com.rgerva.dbr.gui.screen.ModStartScreen;
import com.rgerva.dbr.mechanics.ModStats;
import com.rgerva.dbr.network.ModMessages;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record OpenScreenSyncS2CPacket(ModStats.AttributeModifiers stats) implements CustomPacketPayload {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(DragonBlockReborn.MOD_ID, "open_screen");
    public static final Type<OpenScreenSyncS2CPacket> TYPE = new Type<>(ID);

    public static final StreamCodec<ByteBuf, OpenScreenSyncS2CPacket> STREAM_CODEC =
            StreamCodec.composite(
                    ModStats.AttributeModifiers.STREAM_CODEC,
                    OpenScreenSyncS2CPacket::stats,
                    OpenScreenSyncS2CPacket::new
            );


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            Minecraft.getInstance().setScreen(new ModStartScreen(stats));
        });
    }
}

