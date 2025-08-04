/**
 *  Interface: IModAttributes
 *  Defines the contract for implementations of this type.
 *  <p>
 *  Created by: D56V1OK
 *  On: 2025/ago.
 *  <p>
 *  GitHub: https://github.com/RGerva
 *  <p>
 *  Copyright (c) 2025 @RGerva. All Rights Reserved.
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.network.interfaces;

import com.rgerva.dbr.mechanics.ModTypes;
import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.AttributesSyncS2CPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.Map;

public interface IModAttributes {

    Map<ModTypes.Attributes, Float> setVisualAttributes();

    default void syncAttributesToPlayer(Player player){
        ModNetwork.sendToPlayer(new AttributesSyncS2CPacket(
                        setVisualAttributes()),
                (ServerPlayer) player);
    }

    default void syncAttributesToPlayers(Player player){
        ModNetwork.sendToServer(new AttributesSyncS2CPacket(setVisualAttributes()));
    }
}
