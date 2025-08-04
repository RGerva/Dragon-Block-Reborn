/**
 * Interface: IModChooseTypes Defines the contract for implementations of this type.
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

import com.rgerva.dbr.mechanics.ModTypes;
import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.ChooseTypeScreenSyncS2CPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public interface IModChooseTypes {

    ModTypes.RaceType getInterfaceSyncRaceType();
    ModTypes.ClassType getInterfaceSyncClassType();

    default void syncTypesToPlayer(Player player){
    ModNetwork.sendToPlayer(new ChooseTypeScreenSyncS2CPacket(
            getInterfaceSyncRaceType(),
            getInterfaceSyncClassType()),
            (ServerPlayer) player);
    }

    default void syncTypesToPlayers(Player player){
    ModNetwork.sendToServer(new ChooseTypeScreenSyncS2CPacket(getInterfaceSyncRaceType(),getInterfaceSyncClassType()));
    }
}
