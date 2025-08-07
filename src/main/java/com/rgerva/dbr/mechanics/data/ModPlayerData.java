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

import com.rgerva.dbr.attachment.ModAttachments;
import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import com.rgerva.dbr.mechanics.stats.ModStats;
import com.rgerva.dbr.mechanics.types.ModTypes;
import com.rgerva.dbr.network.interfaces.IModChooseTypes;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.entity.player.Player;

public record ModPlayerData(Player player) implements IModChooseTypes {

  public static ModTypes.RaceType getRace(Player player) {
    String race = player.getData(ModAttachments.RACE_TYPE.get());
	return switch (race){
		case "HUMAN" -> ModTypes.RaceType.HUMAN;
		case "SAIYAN" -> ModTypes.RaceType.SAIYAN;
		case "HALF_SAIYAN" -> ModTypes.RaceType.HALF_SAIYAN;
		case "NAMEKIAN" -> ModTypes.RaceType.NAMEKIAN;
		case "MAJIN" -> ModTypes.RaceType.MAJIN;
		case "ARCOSIAN" -> ModTypes.RaceType.ARCOSIAN;

		default -> throw new IllegalStateException("Unexpected value: " + race);
	};
  }

  public void setRace(ModTypes.RaceType race) {
	  switch (race){
		  case HUMAN ->  player.setData(ModAttachments.RACE_TYPE.get(), "HUMAN");
		  case SAIYAN -> player.setData(ModAttachments.RACE_TYPE.get(), "SAIYAN");
		  case HALF_SAIYAN -> player.setData(ModAttachments.RACE_TYPE.get(), "HALF_SAIYAN");
		  case NAMEKIAN -> player.setData(ModAttachments.RACE_TYPE.get(), "NAMEKIAN");
		  case MAJIN -> player.setData(ModAttachments.RACE_TYPE.get(), "MAJIN");
		  case ARCOSIAN -> player.setData(ModAttachments.RACE_TYPE.get(), "ARCOSIAN");
	  }
  }

  /*====*/

  public static ModTypes.ClassType getClass(Player player) {
	return switch (player.getData(ModAttachments.CLASS_TYPE.get())){
		case "MARTIAL_ARTIST" -> 	ModTypes.ClassType.MARTIAL_ARTIST;
		case "SPIRITUALIST" -> 	ModTypes.ClassType.SPIRITUALIST;
		case "WARRIOR" -> 	ModTypes.ClassType.WARRIOR;
		default ->
				throw new IllegalStateException("Unexpected value: " + player.getData(ModAttachments.CLASS_TYPE.get()));
	};
  }

  public void setClass(ModTypes.ClassType clazz) {
	switch (clazz){
		case MARTIAL_ARTIST -> player.setData(ModAttachments.CLASS_TYPE.get(), "MARTIAL_ARTIST");
		case SPIRITUALIST -> player.setData(ModAttachments.CLASS_TYPE.get(), "SPIRITUALIST");
		case WARRIOR -> player.setData(ModAttachments.CLASS_TYPE.get(), "WARRIOR");
	}
  }

  /*====*/

  public static Map<ModAttributes.Attributes, Float> getMapAttributes(Player player) {
    Map<ModAttributes.Attributes, Float> attributes = new HashMap<>();
    for (ModAttributes.Attributes attr : ModAttributes.Attributes.values()) {
      attributes.put(attr, getAttribute(player, attr));
    }
    return attributes;
  }

  public static float getAttribute(Player player, ModAttributes.Attributes attr) {
    return player.getData(ModAttachments.ATTRIBUTES.get(attr).get());
  }

  public void setAttribute(ModAttributes.Attributes attr, float value) {
    player.setData(ModAttachments.ATTRIBUTES.get(attr).get(), value);
  }

  /*====*/

  public static Map<ModStats.Stats, Float> getMapStats(Player player) {
    Map<ModStats.Stats, Float> stats = new HashMap<>();
    for (ModStats.Stats str : ModStats.Stats.values()) {
      stats.put(str, getStats(player, str));
    }
    return stats;
  }

  public static float getStats(Player player, ModStats.Stats stats) {
    return player.getData(ModAttachments.STATS.get(stats).get());
  }

  public void setStats(ModStats.Stats stats, float value) {
    player.setData(ModAttachments.STATS.get(stats).get(), value);
  }

  /*====*/

  public void restAttributes() {
    for (ModAttributes.Attributes attr : ModAttributes.Attributes.values()) {
      player.setData(
          ModAttachments.ATTRIBUTES.get(attr), ModAttributes.Attributes.getDefaultValue());
    }

    for (ModStats.Stats stats : ModStats.Stats.values()) {
      player.setData(ModAttachments.STATS.get(stats), 0F);
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
