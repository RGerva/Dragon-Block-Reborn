/**
 * Interface: IModStatsSync Defines the contract for implementations of this type.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.network.interfaces;

import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.stats.ModStats;
import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.AttributesSyncC2SPacket;
import com.rgerva.dbr.network.packages.AttributesSyncS2CPacket;
import com.rgerva.dbr.network.packages.StatsSyncC2SPacket;
import com.rgerva.dbr.network.packages.StatsSyncS2CPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.Map;

public interface IModStatsSync {

    Map<ModStats.Stats, Float> getInterfaceStats();

    default void syncStatToServer() {
        ModNetwork.sendToServer(new StatsSyncC2SPacket(getInterfaceStats()));
    }

    default void syncStatToClient(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            ModNetwork.sendToPlayer(new StatsSyncS2CPacket(getInterfaceStats()), serverPlayer);
        }
    }
}
