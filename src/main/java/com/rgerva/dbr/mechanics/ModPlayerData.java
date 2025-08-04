/**
 * Generic Class: ModPlayerData <T> A generic structure that works with type parameters.
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

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.EnumMap;
import java.util.Map;

public class ModPlayerData {

    public static void saveData(Player player, Map<ModTypes.Attributes, Float> attributes){
        CompoundTag tag = player.getPersistentData();
        attributes.forEach((attribute, value) ->
                tag.putFloat("player.attribute." + attribute.name().toLowerCase(), value)
        );
    }

    public static float get(Player player, ModTypes.Attributes attribute) {
        CompoundTag tag = player.getPersistentData();
        return tag.getFloatOr("player.attribute." + attribute.name().toLowerCase(), attribute.getDefaultValue());
    }

    public static Map<ModTypes.Attributes, Float> getAll(Player player) {
        Map<ModTypes.Attributes, Float> result = new EnumMap<>(ModTypes.Attributes.class);
        for (ModTypes.Attributes attr : ModTypes.Attributes.values()) {
            float value = get(player, attr);
            result.put(attr, value);
        }
        return result;
    }
}
