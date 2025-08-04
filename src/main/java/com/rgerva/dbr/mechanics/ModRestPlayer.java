/**
 * Generic Class: ModRestPlayer <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics;

import com.rgerva.dbr.network.ModNetwork;
import com.rgerva.dbr.network.interfaces.IModChooseTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class ModRestPlayer implements IModChooseTypes {

    private final ModTypes.RaceType raceType;
    private final ModTypes.ClassType classType;

    public ModRestPlayer(ModTypes.RaceType raceType, ModTypes.ClassType classType) {
        this.raceType = raceType;
        this.classType = classType;
    }

    @Override
    public ModTypes.RaceType getInterfaceSyncRaceType() {
        return raceType;
    }

    @Override
    public ModTypes.ClassType getInterfaceSyncClassType() {
        return classType;
    }

    public static void Rest(Player player) {
        ModRestPlayer rest = new ModRestPlayer(ModTypes.RaceType.SAIYAN, ModTypes.ClassType.MARTIAL_ARTIST);
        rest.syncTypesToPlayer(player);
        clear(player);
    }

    public static void clear(Player player) {
        CompoundTag tag = player.getPersistentData();
        for (ModTypes.Attributes attr : ModTypes.Attributes.values()) {
            String key = "dbr.visual." + attr.name().toLowerCase();
            tag.remove(key);
        }
    }
}
