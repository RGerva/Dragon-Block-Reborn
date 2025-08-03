package com.rgerva.dbr.mechanics;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ModStats {

    public enum RaceType {
        HUMAN,
        SAIYAN,
        HALF_SAIYAN,
        NAMEKIAN,
        MAJIN,
        ARCOSIAN
    }

    public enum ClassType {
        MARTIAL_ARTIST,
        SPIRITUALIST,
        WARRIOR
    }

    public record ModAttributes(int str, int dex, int con, int wil, int mnd, int spi) {}

    public record DerivedStats(
            float meleeDamage,
            float defense,
            float passiveDefense,
            float runSpeed,
            float flySpeed,
            float body,
            float actionTime,
            float regenBody,
            float regenStamina,
            float kiPower,
            float maxKi,
            float regenEnergy,
            float mindValue,
            float trainingBonus) {}

    public record AttributeModifiers(float str, float dex, float con, float wil, float mnd, float spi) {

        public static final StreamCodec<ByteBuf, AttributeModifiers> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.FLOAT, AttributeModifiers::str,
                ByteBufCodecs.FLOAT, AttributeModifiers::dex,
                ByteBufCodecs.FLOAT, AttributeModifiers::con,
                ByteBufCodecs.FLOAT, AttributeModifiers::wil,
                ByteBufCodecs.FLOAT, AttributeModifiers::mnd,
                ByteBufCodecs.FLOAT, AttributeModifiers::spi,
                AttributeModifiers::new
        );

        public float strPercent() { return str; }
        public float dexPercent() { return dex; }
        public float conPercent() { return con; }
        public float wilPercent() { return wil; }
        public float mndPercent() { return mnd; }
        public float spiPercent() { return spi; }
    }

    public record RaceClassKey(RaceType race, ClassType clazz) {}

    public static class ModifiersRegistry {
        public static final Map<RaceClassKey, AttributeModifiers> MODIFIERS = new HashMap<>();

        public static AttributeModifiers get(RaceType race, ClassType characterClass) {
            return MODIFIERS.get(new ModStats.RaceClassKey(race, characterClass));
        }

        static {
            MODIFIERS.put(new RaceClassKey(RaceType.HUMAN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.0f, 1.0f, 1.3f, 1.1f, 1.1f));
            MODIFIERS.put(new RaceClassKey(RaceType.HUMAN, ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.1f, 0.9f, 1.2f, 1.2f, 1.2f));
            MODIFIERS.put(new RaceClassKey(RaceType.HUMAN, ClassType.WARRIOR), new AttributeModifiers(1.1f, 0.9f, 1.1f, 1.4f, 1.0f, 1.0f));
            MODIFIERS.put(new RaceClassKey(RaceType.SAIYAN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.3f, 1.0f, 1.0f, 1.0f, 1.2f, 1.0f));
            MODIFIERS.put(new RaceClassKey(RaceType.SAIYAN, ClassType.SPIRITUALIST), new AttributeModifiers(1.2f, 1.1f, 0.9f, 0.9f, 1.3f, 1.1f));
            MODIFIERS.put(new RaceClassKey(RaceType.SAIYAN, ClassType.WARRIOR), new AttributeModifiers(1.4f, 0.9f, 1.1f, 1.1f, 0.9f, 0.9f));
            MODIFIERS.put(new RaceClassKey(RaceType.HALF_SAIYAN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.15f, 1.0f, 1.0f, 1.15f, 1.15f, 1.05f));
            MODIFIERS.put(new RaceClassKey(RaceType.HALF_SAIYAN, ClassType.SPIRITUALIST), new AttributeModifiers(1.05f, 1.1f, 0.9f, 1.05f, 1.25f, 1.15f));
            MODIFIERS.put(new RaceClassKey(RaceType.HALF_SAIYAN, ClassType.WARRIOR), new AttributeModifiers(1.25f, 0.9f, 1.1f, 1.25f, 1.05f, 0.95f));
            MODIFIERS.put(new RaceClassKey(RaceType.NAMEKIAN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.0f, 1.1f, 1.0f, 1.3f, 1.2f));
            MODIFIERS.put(new RaceClassKey(RaceType.NAMEKIAN, ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.1f, 1.0f, 0.9f, 1.4f, 1.3f));
            MODIFIERS.put(new RaceClassKey(RaceType.NAMEKIAN, ClassType.WARRIOR), new AttributeModifiers(1.1f, 0.9f, 1.2f, 1.1f, 1.2f, 1.1f));
            MODIFIERS.put(new RaceClassKey(RaceType.MAJIN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.1f, 1.0f, 1.0f, 1.3f, 1.1f, 1.0f));
            MODIFIERS.put(new RaceClassKey(RaceType.MAJIN, ClassType.SPIRITUALIST), new AttributeModifiers(1.0f, 1.1f, 0.9f, 1.2f, 1.2f, 1.1f));
            MODIFIERS.put(new RaceClassKey(RaceType.MAJIN, ClassType.WARRIOR), new AttributeModifiers(1.2f, 0.9f, 1.1f, 1.4f, 1.0f, 0.9f));
            MODIFIERS.put(new RaceClassKey(RaceType.ARCOSIAN, ClassType.MARTIAL_ARTIST), new AttributeModifiers(1.0f, 1.2f, 1.0f, 1.1f, 1.0f, 1.0f));
            MODIFIERS.put(new RaceClassKey(RaceType.ARCOSIAN, ClassType.SPIRITUALIST), new AttributeModifiers(0.9f, 1.3f, 0.9f, 1.0f, 1.1f, 1.1f));
            MODIFIERS.put(new RaceClassKey(RaceType.ARCOSIAN, ClassType.WARRIOR), new AttributeModifiers(1.1f, 1.2f, 1.1f, 1.2f, 0.9f, 0.9f));
        }
    }

    public static class StatUtils {
        public static DerivedStats calculate(ModAttributes attr, float powerRelease) {
            float melee = attr.str() * 2.5f;
            float def = attr.dex() * 4;
            float passive = def * 0.2f;
            float run = attr.dex();
            float fly = attr.dex();
            float body = attr.con() * 20f;
            float at = attr.con() * 3.5f;
            float regenBody = attr.con();
            float regenStamina = attr.con();
            float kiPower = attr.wil() * 5.2f;
            float maxKi = attr.spi() * 40f;
            float regenEnergy = attr.spi();
            float mind = attr.mnd();
            float training = 2f + 2f * (float)(Math.floor(attr.mnd() / 5f)) * (powerRelease / 100f);

            return new DerivedStats(melee, def, passive, run, fly, body, at, regenBody, regenStamina, kiPower, maxKi, regenEnergy, mind, training);
        }
    }

    public static class PlayerStatCalculator {
        public static DerivedStats calculate(RaceType race, ClassType clazz, ModAttributes attrs, float powerRelease) {
            AttributeModifiers mod = ModifiersRegistry.get(race, clazz);

            ModAttributes modified = new ModAttributes(
                    Math.round(attrs.str() * mod.strPercent()),
                    Math.round(attrs.dex() * mod.dexPercent()),
                    Math.round(attrs.con() * mod.conPercent()),
                    Math.round(attrs.wil() * mod.wilPercent()),
                    Math.round(attrs.mnd() * mod.mndPercent()),
                    Math.round(attrs.spi() * mod.spiPercent())
            );

            return StatUtils.calculate(modified, powerRelease);
        }
    }
}
