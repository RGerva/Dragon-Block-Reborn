/**
 * Interface: IModSyncPlayer Defines the contract for implementations of this type.
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

import net.minecraft.world.entity.player.Player;

public interface IModSyncPlayer extends IModAttributesSync, IModStatsSync{

    default void syncToClient(Player player){
        syncAttrToClient(player);
        syncStatToClient(player);
    }

    default void syncToServer(){
        syncAttrToServer();
        syncStatToServer();
    }
}
