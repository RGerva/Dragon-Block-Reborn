/**
 * Generic Class: ModAttributes <T> A generic structure that works with type parameters.
 *
 * <p>Created by: D56V1OK On: 2025/ago.
 *
 * <p>GitHub: https://github.com/RGerva
 *
 * <p>Copyright (c) 2025 @RGerva. All Rights Reserved.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.rgerva.dbr.mechanics.attributes;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.rgerva.dbr.mechanics.types.ModTypes;
import com.rgerva.dbr.mechanics.types.ModTypes.*;
import net.minecraft.network.chat.Component;

public class ModAttributes {
    public enum Attributes {
        STR,
        DEX,
        CON,
        WIL,
        MND,
        SPI;

        public String getName() {
            return name();
        }

        public Component getFullName() {
            return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
        }

        public static float getDefaultValue() {
            return 10;
        }
    }

    public record AttributeModifiers(float str, float dex, float con, float wil, float mnd,
                                     float spi){}

    private static final EnumMap<Attributes, Function<AttributeModifiers, Float>> accessors =
            new EnumMap<>(Attributes.class);

    static {
        accessors.put(Attributes.STR, AttributeModifiers::str);
        accessors.put(Attributes.DEX, AttributeModifiers::dex);
        accessors.put(Attributes.CON, AttributeModifiers::con);
        accessors.put(Attributes.WIL, AttributeModifiers::wil);
        accessors.put(Attributes.MND, AttributeModifiers::mnd);
        accessors.put(Attributes.SPI, AttributeModifiers::spi);
    }

    public static float getModifier(Attributes attribute, AttributeModifiers modifiers) {
        Function<AttributeModifiers, Float> accessor = accessors.get(attribute);
        return (accessor != null && modifiers != null) ? accessor.apply(modifiers) : 1.0f;
    }


    public static final Map<RaceClassKey, AttributeModifiers> MODIFIERS = new HashMap<>();

    static {
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HUMAN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.0f, 1.0f, 1.3f, 1.1f, 1.1f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HUMAN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.1f, 0.9f, 1.2f, 1.2f, 1.2f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HUMAN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.1f, 0.9f, 1.1f, 1.4f, 1.0f, 1.0f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.SAIYAN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.3f, 1.0f, 1.0f, 1.0f, 1.2f, 1.0f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.SAIYAN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(1.2f, 1.1f, 0.9f, 0.9f, 1.3f, 1.1f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.SAIYAN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.4f, 0.9f, 1.1f, 1.1f, 0.9f, 0.9f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HALF_SAIYAN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.15f, 1.0f, 1.0f, 1.15f, 1.15f, 1.05f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HALF_SAIYAN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(1.05f, 1.1f, 0.9f, 1.05f, 1.25f, 1.15f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.HALF_SAIYAN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.25f, 0.9f, 1.1f, 1.25f, 1.05f, 0.95f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.NAMEKIAN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.0f, 1.1f, 1.0f, 1.3f, 1.2f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.NAMEKIAN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.1f, 1.0f, 0.9f, 1.4f, 1.3f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.NAMEKIAN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.1f, 0.9f, 1.2f, 1.1f, 1.2f, 1.1f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.MAJIN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.1f, 1.0f, 1.0f, 1.3f, 1.1f, 1.0f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.MAJIN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(1.0f, 1.1f, 0.9f, 1.2f, 1.2f, 1.1f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.MAJIN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.2f, 0.9f, 1.1f, 1.4f, 1.0f, 0.9f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.ARCOSIAN, ModTypes.ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.2f, 1.0f, 1.1f, 1.0f, 1.0f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.ARCOSIAN, ModTypes.ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.3f, 0.9f, 1.0f, 1.1f, 1.1f));
        MODIFIERS.put(new RaceClassKey(ModTypes.RaceType.ARCOSIAN, ModTypes.ClassType.WARRIOR), new AttributeModifiers(1.1f, 1.2f, 1.1f, 1.2f, 0.9f, 0.9f));
    }

    public static Map<Attributes, Float> showAttributes(AttributeModifiers modifiers) {
        Map<Attributes, Float> result = new EnumMap<>(Attributes.class);

        for (Attributes attr : Attributes.values()) {
            float valorBase = ModAttributes.getModifier(attr, modifiers);
            result.put(attr, (float) Math.round(valorBase * attr.getDefaultValue()));
        }
        return result;
    }
}
