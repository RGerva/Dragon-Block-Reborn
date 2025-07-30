package JinRyuu.JRMCore.server.config.dbc;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.config.JGConfigBase;
import java.util.HashMap;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class JGConfigRaces extends JGConfigBase {
   public static final int FLAT_COST = 0;
   public static final int PERCENTAGE_COST = 1;
   public static final int DAMAGE_MULTI = 0;
   public static final int HEALTH_MULTI = 1;
   public static final int KI_POWER_MULTI = 2;
   public static final int TICK_EXISTED = 0;
   public static final int COUNTDOWN_TIMER = 1;
   public static final int CLASSES;
   public static final String CATEGORY_RACES_SERVERSIDED = "Race Main Attribute";
   public static final String CATEGORY_RACE_SPECIAL_SERVERSIDED = "Race Special";
   private static byte lastRaceID;
   public static double[][][] CONFIG_RACES_ATTRIBUTE_MULTI;
   public static double[][][] cCONFIG_RACES_ATTRIBUTE_MULTI;
   public static int[][][] CONFIG_RACES_ATTRIBUTE_START;
   public static int[][][] cCONFIG_RACES_ATTRIBUTE_START;
   public static float[][][] CONFIG_RACES_STATS_MULTI;
   public static float[][][] cCONFIG_RACES_STATS_MULTI;
   public static int[][][] CONFIG_RACES_STAT_BONUS;
   public static int[][][] cCONFIG_RACES_STAT_BONUS;
   public static boolean CONFIG_MAJIN_ENABLED;
   public static boolean cCONFIG_MAJIN_ENABLED;
   public static boolean CONFIG_MAJIN_ABSORPTION_ENABLED;
   public static boolean cCONFIG_MAJIN_ABSORPTION_ENABLED;
   public static boolean CONFIG_MAJIN_SUPER_REGEN_ENABLED;
   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES;
   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES;
   public static float[][] CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES;
   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES;
   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES;
   public static float[] CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES;
   public static float[] CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI;
   public static float[] cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI;
   public static float[][] CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI;
   public static float[][] CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI;
   public static float[][] CONFIG_MAJIN_ABSORPTON_HEALTH_COST;
   public static int[] CONFIG_MAJIN_ABSORPTON_CD_TIMER;
   public static int[][] CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE;
   public static float[] CONFIG_MAJIN_ABSORPTON_SPEED_MULTI;
   public static float[] cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI;
   public static int CONFIG_MAJIN_ABSORPTON_MAX_LEVEL;
   public static int CONFIG_MAJIN_ABSORPTON_MIN_GAIN;
   public static float CONFIG_MAJIN_ABSORPTON_GAIN_MULTI;
   public static boolean CONFIG_MAJIN_ADD_GAIN_ENABLED;
   public static HashMap<String, Boolean> CONFIG_MAJIN_ENTITY_BLACKLIST;
   public static boolean CONFIG_MAJIN_PURE_PINK_SKIN;
   public static boolean cCONFIG_MAJIN_PURE_PINK_SKIN;
   public static boolean CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
   public static boolean cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
   public static float[][][] CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS;
   public static float[][][] cCONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS;
   public static float[][][] CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS;
   public static float[][][] cCONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS;

   public static void init(Configuration config, byte raceID) {
      lastRaceID = raceID;
      config.load();
      init_races(config, raceID);
      config.save();
   }

   private static void init_races(Configuration config, byte raceID) {
      String name = "DBC " + JRMCoreH.Races[raceID];
      String CATEGORY = "Race Main Attribute";
      String percentage = " (Percentage)";
      String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
      String server = "Server Sided!";
      String var10000 = JRMCoreH.Races[raceID];
      String[] defaultsAttributeMulti = new String[JRMCoreH.attrInit[1].length];
      String[] defaultsStartAttributes = new String[JRMCoreH.attrInit[1].length];
      String[] defaultsStarts = new String[JRMCoreH.statNames[1].length];
      String[][] defaultsStartBonus = new String[CLASSES][JRMCoreH.statNames[1].length];

      int i;
      for(i = 0; i < JRMCoreH.attrInit[1].length; ++i) {
         defaultsAttributeMulti[i] = JRMCoreH.attrInit[1][i] + (JRMCoreH.attrInit[1][i].contains(" ") ? "" : " ") + 1.0D;
         defaultsStartAttributes[i] = JRMCoreH.attrInit[1][i] + (JRMCoreH.attrInit[1][i].contains(" ") ? "" : " ") + JRMCoreH.attrStart[1][i][lastRaceID];
      }

      for(i = 0; i < JRMCoreH.statNames[1].length; ++i) {
         defaultsStarts[i] = JRMCoreH.statNames[1][i] + (JRMCoreH.statNames[1][i].contains(" ") ? "" : " ") + JRMCoreH.statInc[1][i];
      }

      int i;
      for(i = 0; i < JRMCoreH.ClassesDBC.length; ++i) {
         for(i = 0; i < JRMCoreH.statNames[1].length; ++i) {
            defaultsStartBonus[i][i] = JRMCoreH.statNames[1][i] + (JRMCoreH.statNames[1][i].contains(" ") ? "" : " ") + (JRMCoreH.statIncBonusRaceDBC[i][lastRaceID] + JRMCoreH.statIncBonusClass[1][i][i]);
         }
      }

      Property property;
      String title;
      int max;
      String[] defaultArrayS;
      String line;
      for(i = 0; i < JRMCoreH.ClassesDBC.length; ++i) {
         line = JRMCoreH.ClassesDBC[i];
         int min = -100000;
         max = 100000;
         title = " Attribute Multiplier";
         property = config.get(CATEGORY, name + " " + line + title, defaultsAttributeMulti, "Server Sided! " + name + title + getDefault("" + min, "" + max));
         String text = property.getString();
         defaultArrayS = property.getStringList();

         int j;
         String value;
         for(j = 0; j < defaultArrayS.length; ++j) {
            if (defaultArrayS[j].split(" ").length > 1) {
               value = defaultArrayS[j].split(" ")[1];
            } else {
               value = defaultArrayS[j];
            }

            cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] = Double.parseDouble(value);
            if (cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] < (double)min) {
               cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] = (double)min;
            } else if (cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] > (double)max) {
               cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] = (double)max;
            }

            CONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j] = cCONFIG_RACES_ATTRIBUTE_MULTI[lastRaceID][i][j];
         }

         min = -1000000000;
         max = 1000000000;
         title = " Starting Attribute";
         property = config.get(CATEGORY, name + " " + line + title, defaultsStartAttributes, "Server Sided! " + name + title + getDefault("" + min, "" + max));
         text = property.getString();
         defaultArrayS = property.getStringList();

         for(j = 0; j < defaultArrayS.length; ++j) {
            if (defaultArrayS[j].split(" ").length > 1) {
               value = defaultArrayS[j].split(" ")[1];
            } else {
               value = defaultArrayS[j];
            }

            cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] = Integer.parseInt(value);
            if (cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] < min) {
               cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] = min;
            } else if (cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] > max) {
               cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] = max;
            }

            CONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j] = cCONFIG_RACES_ATTRIBUTE_START[lastRaceID][i][j];
         }

         min = -100000;
         max = 100000;
         title = " Stat Multiplier from Attribute";
         property = config.get(CATEGORY, name + " " + line + title, defaultsStarts, "Server Sided! " + name + title + getDefault("" + min, "" + max));
         text = property.getString();
         defaultArrayS = property.getStringList();

         for(j = 0; j < defaultArrayS.length; ++j) {
            if (defaultArrayS[j].split(" ").length > 1) {
               value = defaultArrayS[j].split(" ")[1];
            } else {
               value = defaultArrayS[j];
            }

            cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j] = Float.parseFloat(value);
            if (cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j] < (float)min) {
               cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j] = (float)min;
            } else if (cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j] > (float)max) {
               cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j] = (float)max;
            }

            CONFIG_RACES_STATS_MULTI[lastRaceID][i][j] = cCONFIG_RACES_STATS_MULTI[lastRaceID][i][j];
         }

         min = -1000000000;
         max = 1000000000;
         title = " Stat Bonus";
         property = config.get(CATEGORY, name + " " + line + title, defaultsStartBonus[i], "Server Sided! " + name + title + getDefault("" + min, "" + max));
         text = property.getString();
         defaultArrayS = property.getStringList();

         for(j = 0; j < defaultArrayS.length; ++j) {
            if (defaultArrayS[j].split(" ").length > 1) {
               value = defaultArrayS[j].split(" ")[1];
            } else {
               value = defaultArrayS[j];
            }

            cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j] = Integer.parseInt(value);
            if (cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j] < min) {
               cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j] = min;
            } else if (cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j] > max) {
               cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j] = max;
            }

            CONFIG_RACES_STAT_BONUS[lastRaceID][i][j] = cCONFIG_RACES_STAT_BONUS[lastRaceID][i][j];
         }
      }

      if (JRMCoreH.isRaceMajin(raceID)) {
         CATEGORY = "Race Special";
         boolean defaultB = true;
         title = " Ki Powertype Enabled";
         String description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         cCONFIG_MAJIN_ENABLED = property.getBoolean();
         CONFIG_MAJIN_ENABLED = cCONFIG_MAJIN_ENABLED;
         defaultB = true;
         title = " Super Regeneration Enabled";
         description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         CONFIG_MAJIN_SUPER_REGEN_ENABLED = property.getBoolean();
         defaultB = true;
         title = " Absorption Enabled";
         description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         cCONFIG_MAJIN_ABSORPTION_ENABLED = property.getBoolean();
         CONFIG_MAJIN_ABSORPTION_ENABLED = cCONFIG_MAJIN_ABSORPTION_ENABLED;
         defaultB = true;
         title = " Pure Form Pink Skin Color Enabled";
         description = "(true = Enabled, false = Disabled) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         cCONFIG_MAJIN_PURE_PINK_SKIN = property.getBoolean();
         CONFIG_MAJIN_PURE_PINK_SKIN = cCONFIG_MAJIN_PURE_PINK_SKIN;
         defaultB = false;
         title = " Absorption Multiplies Bonus Attribute Multipliers Enabled";
         description = "Enabled = Multiplies Bonus Attribute Multipliers, Disabled = Adds to the Bonus Attribute Multipliers. (true = Enabled, false = Disabled) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = property.getBoolean();
         CONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS = cCONFIG_MAJIN_ABSORPTON_MULTIPLIES_BONUS_ATTRIBUTE_MULTIPLIERS;
         int min = 0;
         max = 1000000000;
         String[] defaultStringArray = new String[]{"Base 1 0.05", "Evil 2 0.075", "Full 3 0.1", "Pure 5 0.175", "God 4 0.125", "Mystic 3 0.125", "UI 5 0.125", "G.O.D. 5 0.125"};
         title = " Super Regeneration Health Gain";
         description = "Set the Health Gain of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         String[] data = property.getStringList();

         String[] values;
         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][0] = (float)max;
            }

            CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES[i][1] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 1 0.05", "Evil 2 0.06", "Full 3 0.07", "Pure 5 0.09", "God 4 0.08", "Mystic 3 0.07", "UI 4 0.08", "G.O.D. 4 0.08"};
         title = " Super Regeneration Ki Cost";
         description = "Set the Ki Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][0] = (float)max;
            }

            CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES[i][1] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 1 0.025", "Evil 2 0.03", "Full 3 0.035", "Pure 5 0.045", "God 4 0.04", "Mystic 3 0.035", "UI 4 0.04", "G.O.D. 4 0.04"};
         title = " Super Regeneration Stamina Cost";
         description = "Set the Stamina Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][0] = (float)max;
            }

            CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES[i][1] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"0.9", "0.95", "0.1", "1.05", "1.1"};
         title = " Super Regeneration Health Gain multiplier per Racial Skill Level";
         description = "Set the Health Gain of using the Skill per Form" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = Float.parseFloat(line);
            if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES[i] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"0.9", "0.95", "0.1", "1.15", "1.2"};
         title = " Super Regeneration Ki Cost multiplier per Racial Skill Level";
         description = "Set the Ki Cost of using the Skill per Form" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = Float.parseFloat(line);
            if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES[i] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"0.9", "0.95", "0.1", "1.15", "1.2"};
         title = " Super Regeneration Stamina Cost multiplier per Racial Skill Level";
         description = "Set the Stamina Cost of using the Skill per Form" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = Float.parseFloat(line);
            if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] < (float)min) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = (float)min;
            } else if (CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] > (float)max) {
               CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES[i] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 0.01", "Evil 0.01", "Full 0.01", "Pure 0.01", "God 0.01", "Mystic 0.01", "UI 0.01", "G.O.D. 0.01"};
         title = " Absorption Attribute Multiplier";
         description = "Set the Attribute Multiplier of using the Skill per Form " + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = Float.parseFloat(values[1]);
            if (cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] < (float)min) {
               cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = (float)min;
            } else if (cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] > (float)max) {
               cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i] = cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI[i];
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 0.25 0.05 0.25", "Evil 0.25 0.05 0.25", "Full 0.25 0.05 0.25", "Pure 0.25 0.05 0.25", "God 0.25 0.05 0.25", "Mystic 0.25 0.05 0.25", "UI 0.25 0.05 0.25", "G.O.D. 0.25 0.05 0.25"};
         title = " Absorption User Power Multiplier";
         description = "Set the Power Multiplier of using the Skill per Form, which decides whether or not you can Absorb the target (DamageMulti HealthMulti KiPowerMulti)" + getDefault("" + min, "" + max) + " Power Result = (UserDamage * DamageMulti + UserHealth * HealthMulti + UserKiPower * KiPowerMulti)";
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][0] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][1] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = values.length > 3 ? Float.parseFloat(values[3]) : 0.25F;
            if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[i][2] = (float)max;
            }

            defaultArrayS = defaultStringArray[i].split(" ");
            if (values.length > defaultArrayS.length) {
               data[i] = values[0] + " " + values[1] + " " + values[2] + " " + values[3];
            } else if (values.length == 3) {
               data[i] = data[i] + " " + defaultArrayS[3];
            }
         }

         property.set(data);
         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 0.25 0.05 0.25", "Evil 0.25 0.05 0.25", "Full 0.25 0.05 0.25", "Pure 0.25 0.05 0.25", "God 0.25 0.05 0.25", "Mystic 0.25 0.05 0.25", "UI 0.25 0.05 0.25", "G.O.D. 0.25 0.05 0.25"};
         title = " Absorption Target Power Multiplier";
         description = "Set the Power Multiplier of using the Skill per Absorption User's Form, which decides whether or not you can Absorb the target (DamageMulti HealthMulti KiPowerMulti)" + getDefault("" + min, "" + max) + " Power Result = (TargetDamage * DamageMulti + TargetHealth * HealthMulti + TargetKiPower * KiPowerMulti)";
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][0] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][1] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = values.length > 3 ? Float.parseFloat(values[3]) : 0.25F;
            if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI[i][2] = (float)max;
            }

            defaultArrayS = defaultStringArray[i].split(" ");
            if (values.length > defaultArrayS.length) {
               data[i] = values[0] + " " + values[1] + " " + values[2] + " " + values[3];
            } else if (values.length == 3) {
               data[i] = data[i] + " " + defaultArrayS[3];
            }
         }

         property.set(data);
         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 10 0.1", "Evil 10 0.1", "Full 10 0.1", "Pure 10 0.1", "God 10 0.1", "Mystic 10 0.1", "UI 10 0.1", "G.O.D. 10 0.1"};
         title = " Absorption Health Cost";
         description = "Set the Health Cost of using the Skill per Form (FlatCost PercentageCost)" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = Float.parseFloat(values[1]);
            if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][0] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = Float.parseFloat(values[2]);
            if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] < (float)min) {
               CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = (float)min;
            } else if (CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] > (float)max) {
               CONFIG_MAJIN_ABSORPTON_HEALTH_COST[i][1] = (float)max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 3", "Evil 3", "Full 3", "Pure 3", "God 3", "Mystic 3", "UI 3", "G.O.D. 3"};
         title = " Absorption Cooldown";
         description = "Skill Cooldown timer per Form. Result is ConfigValue multiplied by 5 Seconds! Timer until the Skill can be used again" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = Integer.parseInt(values[1]);
            if (CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] < min) {
               CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = min;
            } else if (CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] > max) {
               CONFIG_MAJIN_ABSORPTON_CD_TIMER[i] = max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 500 80", "Evil 525 80", "Full 550 80", "Pure 650 80", "God 575 80", "Mystic 550 80", "UI 575 80", "G.O.D. 575 80"};
         title = " Absorption Max Tick Life";
         description = "Absorption Entity Max Life Tick TImer (TicksExisted CountdownTimer). The Absorption Entity will vanish once the CountdownTimer is done. The CountdownTimer start either when the TicksExisted timer is reached OR if the Entity stops moving" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = Integer.parseInt(values[1]);
            if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] < min) {
               CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = min;
            } else if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] > max) {
               CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][0] = max;
            }

            CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = Integer.parseInt(values[2]);
            if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] < min) {
               CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = min;
            } else if (CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] > max) {
               CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE[i][1] = max;
            }
         }

         min = 0;
         max = 1000000000;
         defaultStringArray = new String[]{"Base 0.75", "Evil 0.75", "Full 0.75", "Pure 0.75", "God 0.75", "Mystic 0.75", "UI 0.75", "G.O.D. 0.75"};
         title = " Absorption Entity Speed Multiplier";
         description = "Set the Speed Multiplier of the Skill per Form" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();

         for(i = 0; i < data.length; ++i) {
            line = data[i];
            values = line.split(" ");
            cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = Float.parseFloat(values[1]);
            if (cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] < (float)min) {
               cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = (float)min;
            } else if (cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] > (float)max) {
               cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = (float)max;
            }

            CONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i] = cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI[i];
         }

         min = 0;
         max = 1000000000;
         title = " Absorption Max Level";
         description = "Max Absorption Level you can reach" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, name + title, 50);
         property.comment = "Server Sided! " + description;
         CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = property.getInt();
         if (CONFIG_MAJIN_ABSORPTON_MAX_LEVEL < min) {
            CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = min;
         } else if (CONFIG_MAJIN_ABSORPTON_MAX_LEVEL > max) {
            CONFIG_MAJIN_ABSORPTON_MAX_LEVEL = max;
         }

         min = 0;
         max = 1000000000;
         title = " Absorption Min Gain";
         description = "Minimum Gain from Absorbing someone" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, name + title, 3);
         property.comment = "Server Sided! " + description;
         CONFIG_MAJIN_ABSORPTON_MIN_GAIN = property.getInt();
         if (CONFIG_MAJIN_ABSORPTON_MIN_GAIN < min) {
            CONFIG_MAJIN_ABSORPTON_MIN_GAIN = min;
         } else if (CONFIG_MAJIN_ABSORPTON_MIN_GAIN > max) {
            CONFIG_MAJIN_ABSORPTON_MIN_GAIN = max;
         }

         min = 0;
         max = 1000000000;
         title = " Absorption Gain Multiplier";
         description = "Gain Multiplier when Absorbing someone. Result = (attackTarget / userAttack * THIS_CONFIG)" + getDefault("" + min, "" + max);
         property = config.get(CATEGORY, name + title, 500.0D);
         property.comment = "Server Sided! " + description;
         CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = (float)property.getDouble();
         if (CONFIG_MAJIN_ABSORPTON_GAIN_MULTI < (float)min) {
            CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = (float)min;
         } else if (CONFIG_MAJIN_ABSORPTON_GAIN_MULTI > (float)max) {
            CONFIG_MAJIN_ABSORPTON_GAIN_MULTI = (float)max;
         }

         defaultB = true;
         title = " Absorption Add Gain Enabled";
         description = "(true = Enabled (Add to Absorption Level), false = Disabled (Replace the Absorption Level)) (Default: " + defaultB + ")";
         property = config.get(CATEGORY, name + title, defaultB);
         property.comment = "Server Sided! " + description;
         CONFIG_MAJIN_ADD_GAIN_ENABLED = property.getBoolean();
         defaultStringArray = new String[]{"JinRyuu.JRMCore.entity.EntitySafeZone", "JinRyuu.JRMCore.entity.EntityNPCshadow"};
         title = " Absorption LivingEntity Blacklist";
         description = "List down the Class paths and name of the Entities.";
         property = config.get(CATEGORY, title, defaultStringArray, "Server Sided! " + description);
         data = property.getStringList();
         String[] var31 = data;
         i = data.length;

         for(int var30 = 0; var30 < i; ++var30) {
            String line = var31[var30];
            CONFIG_MAJIN_ENTITY_BLACKLIST.put(line, true);
         }
      }

   }

   static {
      CLASSES = JRMCoreH.ClassesDBC.length;
      CONFIG_RACES_ATTRIBUTE_MULTI = new double[JRMCoreH.Races.length][CLASSES][JRMCoreH.attrInit[1].length];
      cCONFIG_RACES_ATTRIBUTE_MULTI = new double[JRMCoreH.Races.length][CLASSES][JRMCoreH.attrInit[1].length];
      CONFIG_RACES_ATTRIBUTE_START = new int[JRMCoreH.Races.length][CLASSES][JRMCoreH.attrInit[1].length];
      cCONFIG_RACES_ATTRIBUTE_START = new int[JRMCoreH.Races.length][CLASSES][JRMCoreH.attrInit[1].length];
      CONFIG_RACES_STATS_MULTI = new float[JRMCoreH.Races.length][CLASSES][JRMCoreH.statNames[1].length];
      cCONFIG_RACES_STATS_MULTI = new float[JRMCoreH.Races.length][CLASSES][JRMCoreH.statNames[1].length];
      CONFIG_RACES_STAT_BONUS = new int[JRMCoreH.Races.length][CLASSES][JRMCoreH.statNames[1].length];
      cCONFIG_RACES_STAT_BONUS = new int[JRMCoreH.Races.length][CLASSES][JRMCoreH.statNames[1].length];
      CONFIG_MAJIN_SUPER_REGEN_FORM_HEALTH_VALUES = new float[JRMCoreH.TransNms[5].length + 3][2];
      CONFIG_MAJIN_SUPER_REGEN_FORM_COST_KI_VALUES = new float[JRMCoreH.TransNms[5].length + 3][2];
      CONFIG_MAJIN_SUPER_REGEN_FORM_COST_ST_VALUES = new float[JRMCoreH.TransNms[5].length + 3][2];
      CONFIG_MAJIN_SUPER_REGEN_RACIAL_HEALTH_VALUES = new float[5];
      CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_KI_VALUES = new float[5];
      CONFIG_MAJIN_SUPER_REGEN_RACIAL_COST_ST_VALUES = new float[5];
      CONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI = new float[JRMCoreH.TransNms[5].length + 3];
      cCONFIG_MAJIN_ABSORPTON_ATTRIBUTE_MULTI = new float[JRMCoreH.TransNms[5].length + 3];
      CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI = new float[JRMCoreH.TransNms[5].length + 3][3];
      CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTI = new float[JRMCoreH.TransNms[5].length + 3][3];
      CONFIG_MAJIN_ABSORPTON_HEALTH_COST = new float[JRMCoreH.TransNms[5].length + 3][2];
      CONFIG_MAJIN_ABSORPTON_CD_TIMER = new int[JRMCoreH.TransNms[5].length + 3];
      CONFIG_MAJIN_ABSORPTON_MAX_TICK_LIFE = new int[JRMCoreH.TransNms[5].length + 3][2];
      CONFIG_MAJIN_ABSORPTON_SPEED_MULTI = new float[JRMCoreH.TransNms[5].length + 3];
      cCONFIG_MAJIN_ABSORPTON_SPEED_MULTI = new float[JRMCoreH.TransNms[5].length + 3];
      CONFIG_MAJIN_ENTITY_BLACKLIST = new HashMap();
      CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS = new float[JRMCoreH.TransNms[5].length + 3][][];
      cCONFIG_MAJIN_ABSORPTON_USER_POWER_MULTIS = new float[JRMCoreH.TransNms[5].length + 3][][];
      CONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS = new float[JRMCoreH.TransNms[5].length + 3][][];
      cCONFIG_MAJIN_ABSORPTON_TARGET_POWER_MULTIS = new float[JRMCoreH.TransNms[5].length + 3][][];
   }
}
