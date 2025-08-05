package com.rgerva.dbr.mechanics.stats;

public class ModStats {

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

//    public static final StreamCodec<ByteBuf, AttributeModifiers> STREAM_CODEC = StreamCodec.composite(
//            ByteBufCodecs.FLOAT, AttributeModifiers::str,
//            ByteBufCodecs.FLOAT, AttributeModifiers::dex,
//            ByteBufCodecs.FLOAT, AttributeModifiers::con,
//            ByteBufCodecs.FLOAT, AttributeModifiers::wil,
//            ByteBufCodecs.FLOAT, AttributeModifiers::mnd,
//            ByteBufCodecs.FLOAT, AttributeModifiers::spi,
//            AttributeModifiers::new
//    );

//    public static class StatUtils {
//        public static DerivedStats calculate(ModAttributes attr, float powerRelease) {
//            float melee = attr.str() * 2.5f;
//            float def = attr.dex() * 4;
//            float passive = def * 0.2f;
//            float run = attr.dex();
//            float fly = attr.dex();
//            float body = attr.con() * 20f;
//            float at = attr.con() * 3.5f;
//            float regenBody = attr.con();
//            float regenStamina = attr.con();
//            float kiPower = attr.wil() * 5.2f;
//            float maxKi = attr.spi() * 40f;
//            float regenEnergy = attr.spi();
//            float mind = attr.mnd();
//            float training = 2f + 2f * (float)(Math.floor(attr.mnd() / 5f)) * (powerRelease / 100f);
//
//            return new DerivedStats(melee, def, passive, run, fly, body, at, regenBody, regenStamina, kiPower, maxKi, regenEnergy, mind, training);
//        }
//    }
//
//    public static class PlayerStatCalculator {
//        public static DerivedStats calculate(RaceType race, ClassType clazz, ModAttributes attrs, float powerRelease) {
//            AttributeModifiers mod = ModifiersRegistry.get(race, clazz);
//
//            ModAttributes modified = new ModAttributes(
//                    Math.round(attrs.str() * mod.strPercent()),
//                    Math.round(attrs.dex() * mod.dexPercent()),
//                    Math.round(attrs.con() * mod.conPercent()),
//                    Math.round(attrs.wil() * mod.wilPercent()),
//                    Math.round(attrs.mnd() * mod.mndPercent()),
//                    Math.round(attrs.spi() * mod.spiPercent())
//            );
//
//            return StatUtils.calculate(modified, powerRelease);
//        }
//    }
}
