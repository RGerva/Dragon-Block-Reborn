package com.rgerva.dbr.mechanics.stats;

import com.rgerva.dbr.mechanics.attributes.ModAttributes;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.network.chat.Component;

public class ModStats {

  public enum Stats {
    MELEE_DAMAGE(2.5F),
    DEFENSE(4),
    PASSIVE_DEFENSE(0.2F),
    RUN_SPEED(1F),
    FLY_SPEED(1F),
    BODY(20F),
    ACTION_TIME(3.5F),
    REGEN_BODY(1F),
    REGEN_STAMINA(1F),
    KI_POWER(5.2F),
    MAX_KI(40F),
    REGEN_ENERGY(1F),
    MIND_VALUE(1F),
    TRAINING_BONUS(1F);

    private final float baseValue;

    Stats(float baseValue) {
      this.baseValue = baseValue;
    }

    public String getName() {
      return name();
    }

    public Component getFullName() {
      return Component.translatable("mechanic.dragon_block_reborn." + getName().toLowerCase());
    }

    public float getBaseValue() {
      return baseValue;
    }
  }

  public Map<ModStats.Stats, Float> calculateStats(
      Map<ModAttributes.Attributes, Float> attributes) {
    return calculateStats(attributes, 5F);
  }

  public Map<ModStats.Stats, Float> calculateStats(
      Map<ModAttributes.Attributes, Float> attributes, float powerRelease) {
    Map<ModStats.Stats, Float> result = new HashMap<>();

    float melee = attributes.get(ModAttributes.Attributes.STR) * Stats.MELEE_DAMAGE.getBaseValue();
    float def = attributes.get(ModAttributes.Attributes.DEX) * Stats.DEFENSE.getBaseValue();
    float passive = def * Stats.PASSIVE_DEFENSE.getBaseValue();
    float run = attributes.get(ModAttributes.Attributes.DEX) * Stats.RUN_SPEED.getBaseValue();
    float fly = attributes.get(ModAttributes.Attributes.DEX) * Stats.FLY_SPEED.getBaseValue();
    float body = attributes.get(ModAttributes.Attributes.CON) * Stats.BODY.getBaseValue();
    float at = attributes.get(ModAttributes.Attributes.CON) * Stats.ACTION_TIME.getBaseValue();
    float regenBody =
        attributes.get(ModAttributes.Attributes.CON) * Stats.REGEN_BODY.getBaseValue();
    float regenStamina =
        attributes.get(ModAttributes.Attributes.CON) * Stats.REGEN_STAMINA.getBaseValue();
    float kiPower = attributes.get(ModAttributes.Attributes.WIL) * Stats.KI_POWER.getBaseValue();
    float maxKi = attributes.get(ModAttributes.Attributes.SPI) * Stats.MAX_KI.getBaseValue();
    float regenEnergy =
        attributes.get(ModAttributes.Attributes.SPI) * Stats.REGEN_ENERGY.getBaseValue();
    float mind = attributes.get(ModAttributes.Attributes.MND) * Stats.MIND_VALUE.getBaseValue();
    float training =
        Stats.TRAINING_BONUS.getBaseValue()
            + (2F
                * (float) (Math.floor(attributes.get(ModAttributes.Attributes.MND) / 5.0F))
                * (powerRelease / 100f));

    result.put(Stats.MELEE_DAMAGE, melee);
    result.put(Stats.DEFENSE, def);
    result.put(Stats.PASSIVE_DEFENSE, passive);
    result.put(Stats.RUN_SPEED, run);
    result.put(Stats.FLY_SPEED, fly);
    result.put(Stats.BODY, body);
    result.put(Stats.ACTION_TIME, at);
    result.put(Stats.REGEN_BODY, regenBody);
    result.put(Stats.REGEN_STAMINA, regenStamina);
    result.put(Stats.KI_POWER, kiPower);
    result.put(Stats.MAX_KI, maxKi);
    result.put(Stats.REGEN_ENERGY, regenEnergy);
    result.put(Stats.MIND_VALUE, mind);
    result.put(Stats.TRAINING_BONUS, training);

    return result;
  }
}
