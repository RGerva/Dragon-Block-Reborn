/**
 * Record: ModPlayerData Immutable data structure for simplified object representation.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics.data;

import com.rgerva.dbr.mechanics.types.ModTypes;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.network.interfaces.IModChooseTypes;
import net.minecraft.world.entity.player.Player;
import com.rgerva.dbr.attachment.ModAttachments;

public record ModPlayerData(Player player) implements IModChooseTypes {

  public float getAttribute(ModAttributes.Attributes attr) {
    return player.getData(ModAttachments.ATTRIBUTES.get(attr).get());
  }

  public void setAttribute(ModAttributes.Attributes attr, float value) {
    player.setData(ModAttachments.ATTRIBUTES.get(attr).get(), value);
  }

  public void restAttributes(){
      for(ModAttributes.Attributes attr : ModAttributes.Attributes.values()){
          player.setData(ModAttachments.ATTRIBUTES.get(attr),
                  ModAttributes.Attributes.getDefaultValue());
      }
      syncTypesToPlayer(player);
  }

    @Override
    public ModTypes.RaceType getInterfaceSyncRaceType() {
        return ModTypes.RaceType.SAIYAN;
    }

    @Override
    public ModTypes.ClassType getInterfaceSyncClassType() {
        return ModTypes.ClassType.MARTIAL_ARTIST;
    }
}
