/**
 * Interface: IModRaceClassSync Defines the contract for implementations of this type.
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

import com.rgerva.dbr.mechanics.types.ModTypes;
import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.ClientToServer.RaceClassSyncC2SPacket;
import com.rgerva.dbr.network.packages.ServertToClient.RaceClassSyncS2CPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public interface IModRaceClassSync {

  ModTypes.RaceType getRaceType();

  ModTypes.ClassType getClassType();

  default void syncRaceClassToServer() {
    ModNetwork.sendToServer(new RaceClassSyncC2SPacket(getRaceType(), getClassType()));
  }

  default void syncRaceClassToClient(Player player) {
    if (player instanceof ServerPlayer serverPlayer) {
      ModNetwork.sendToPlayer(
          new RaceClassSyncS2CPacket(getRaceType(), getClassType()), serverPlayer);
    }
  }
}
