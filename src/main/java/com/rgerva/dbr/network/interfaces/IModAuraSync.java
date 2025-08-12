/**
 * Interface: IModAuraSync
 * Defines the contract for implementations of this type.
 * <p>
 * Created by: rgerv
 * On: 2025/ago.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

package com.rgerva.dbr.network.interfaces;

import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.packages.ClientToServer.AuraSyncC2SPackage;
import com.rgerva.dbr.network.packages.ServertToClient.AuraSyncS2CPackage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public interface IModAuraSync {

		boolean activateAura();

		default void syncAuraToServer() {
				ModNetwork.sendToServer(new AuraSyncC2SPackage(activateAura()));
		}

		default void syncAuraToClient(Player player) {
				if (player instanceof ServerPlayer serverPlayer) {
						ModNetwork.sendToPlayer(new AuraSyncS2CPackage(activateAura()), serverPlayer);
				}
		}
}
