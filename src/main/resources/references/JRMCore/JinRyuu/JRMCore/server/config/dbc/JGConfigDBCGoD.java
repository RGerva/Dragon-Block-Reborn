package JinRyuu.JRMCore.server.config.dbc;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.config.JGConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class JGConfigDBCGoD extends JGConfigBase {
   public static final String CATEGORY_FORM_GOD_SERVERSIDED = "God of Destruction";
   public static final int FLAT_COST = 0;
   public static final int PERCENTAGE_COST = 1;
   public static boolean CONFIG_GOD_ENABLED;
   public static float CONFIG_GOD_ATTRIBUTE_MULTI;
   public static int CONFIG_GOD_TP_COST;
   public static int CONFIG_GOD_MIND_REQUIREMENT;
   public static int CONFIG_GOD_MAX_ALIGNMENT;
   public static int CONFIG_GOD_LEVEL_REQUIREMENT;
   public static int CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT;
   public static boolean CONFIG_GOD_IGNORE_BASE_CONFIG;
   public static boolean CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG;
   public static String[] CONFIG_GOD_IGNORED_DAMAGE_SOURCES;
   public static String[] CONFIG_GOD_IGNORED_ENTITIES;
   public static float CONFIG_GOD_IGNORE_DAMAGE_MULTI;
   public static boolean CONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
   public static boolean CONFIG_GOD_AURA_ENABLED;
   public static boolean CONFIG_GOD_AURA_ENABLED_WITH_AURA;
   public static float[] CONFIG_GOD_AURA_KI_COST = new float[2];
   public static boolean CONFIG_GOD_ENERGY_ENABLED;
   public static float CONFIG_GOD_ENERGY_DAMAGE_MULTI;
   public static float[] CONFIG_GOD_ATTRIBUTE_MULTI_RACE;
   public static boolean cCONFIG_GOD_ENABLED;
   public static float cCONFIG_GOD_ATTRIBUTE_MULTI;
   public static int cCONFIG_GOD_TP_COST;
   public static int cCONFIG_GOD_MIND_REQUIREMENT;
   public static boolean cCONFIG_GOD_IGNORE_BASE_CONFIG;
   public static String[] cCONFIG_GOD_IGNORED_DAMAGE_SOURCES;
   public static String[] cCONFIG_GOD_IGNORED_ENTITIES;
   public static float cCONFIG_GOD_IGNORE_DAMAGE_MULTI;
   public static boolean cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
   public static boolean cCONFIG_GOD_AURA_ENABLED;
   public static boolean cCONFIG_GOD_AURA_ENABLED_WITH_AURA;
   public static boolean cCONFIG_GOD_ENERGY_ENABLED;
   public static float cCONFIG_GOD_ENERGY_DAMAGE_MULTI;
   public static float[] cCONFIG_GOD_ATTRIBUTE_MULTI_RACE;

   public static void init(Configuration config) {
      config.load();
      init_god(config);
      config.save();
   }

   private static void init_god(Configuration config) {
      String form = "God of Destruction";
      String CATEGORY = "God of Destruction";
      String percentage = " (Percentage)";
      String warning = " Change only to your own responsibility! Having too high multiplier will cause glitches!";
      String server = "Server Sided!";
      int min = 0;
      int max = 100000;
      String title = "Attribute Multiplier";
      String desc = title + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault2("" + min, "" + max) + getDefaultValue2("3.8");
      Property property = config.get(CATEGORY, "God of Destruction " + title, 3.8D);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_ATTRIBUTE_MULTI = (float)property.getDouble();
      if (cCONFIG_GOD_ATTRIBUTE_MULTI < (float)min) {
         cCONFIG_GOD_ATTRIBUTE_MULTI = (float)min;
      } else if (cCONFIG_GOD_ATTRIBUTE_MULTI > (float)max) {
         cCONFIG_GOD_ATTRIBUTE_MULTI = (float)max;
      }

      CONFIG_GOD_ATTRIBUTE_MULTI = cCONFIG_GOD_ATTRIBUTE_MULTI;
      min = 0;
      max = 100000;
      String defS = "";
      String[] defaultList = new String[]{"1.0", "1.0", "1.0", "1.0", "1.0", "0.75"};

      for(int j = 0; j < defaultList.length; ++j) {
         defaultList[j] = JRMCoreH.Races[j] + " " + defaultList[j];
         defS = defS + defaultList[j];
      }

      title = "Attribute Multiplier per Race";
      desc = title + " Change only to your own responsibility! Having too high multiplier will cause glitches!" + getDefault2("" + min, "" + max) + getDefaultValue2(defS);
      property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
      property.comment = "Server Sided! " + desc;
      String[] listString = property.getStringList();

      int i;
      for(i = 0; i < listString.length; ++i) {
         String[] values = listString[i].split(" ");
         float value = Float.parseFloat(values[1]);
         cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] = value;
         if (cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] < (float)min) {
            cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] = (float)min;
         } else if (cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] > (float)max) {
            cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] = (float)max;
         }

         CONFIG_GOD_ATTRIBUTE_MULTI_RACE[i] = cCONFIG_GOD_ATTRIBUTE_MULTI_RACE[i];
      }

      int min = -1;
      max = 2000000000;
      title = "TP Cost";
      desc = title + getDefault("" + min, "" + max) + getDefaultValue2("50000");
      property = config.get(CATEGORY, "God of Destruction " + title, 50000);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_TP_COST = property.getInt();
      if (cCONFIG_GOD_TP_COST < min) {
         cCONFIG_GOD_TP_COST = min;
      } else if (cCONFIG_GOD_TP_COST > max) {
         cCONFIG_GOD_TP_COST = max;
      }

      CONFIG_GOD_TP_COST = cCONFIG_GOD_TP_COST;
      min = 0;
      max = 2000000000;
      title = "Mind Cost/Requirement";
      desc = title + getDefault("" + min, "" + max) + getDefaultValue2("10");
      property = config.get(CATEGORY, "God of Destruction " + title, 10);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_MIND_REQUIREMENT = property.getInt();
      if (cCONFIG_GOD_MIND_REQUIREMENT < min) {
         cCONFIG_GOD_MIND_REQUIREMENT = min;
      } else if (cCONFIG_GOD_MIND_REQUIREMENT > max) {
         cCONFIG_GOD_MIND_REQUIREMENT = max;
      }

      CONFIG_GOD_MIND_REQUIREMENT = cCONFIG_GOD_MIND_REQUIREMENT;
      min = 0;
      max = 1000000;
      title = "Level Requirement";
      desc = title + getDefault("" + min, "" + max) + getDefaultValue2("200");
      property = config.get(CATEGORY, "God of Destruction " + title, 200);
      property.comment = "Server Sided! " + desc;
      CONFIG_GOD_LEVEL_REQUIREMENT = property.getInt();
      if (CONFIG_GOD_LEVEL_REQUIREMENT < min) {
         CONFIG_GOD_LEVEL_REQUIREMENT = min;
      } else if (CONFIG_GOD_LEVEL_REQUIREMENT > max) {
         CONFIG_GOD_LEVEL_REQUIREMENT = max;
      }

      min = 0;
      int max = 100;
      title = "Regardless Level Requirement";
      desc = title + getDefault("" + min, "" + max) + getDefaultValue2("10");
      property = config.get(CATEGORY, "God of Destruction " + title, 10);
      property.comment = "Server Sided! " + desc;
      CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = property.getInt();
      if (CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT < min) {
         CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = min;
      } else if (CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT > max) {
         CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT = max;
      }

      title = "Ignore Base Attribute Multiplier Config while in GoD Enabled";
      desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_IGNORE_BASE_CONFIG = property.getBoolean();
      CONFIG_GOD_IGNORE_BASE_CONFIG = cCONFIG_GOD_IGNORE_BASE_CONFIG;
      title = "Ignore Base Ki Regen Config Multiplier while in GoD Enabled";
      desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      CONFIG_GOD_IGNORE_BASE_KI_REGEN_CONFIG = property.getBoolean();
      defaultList = new String[]{""};
      title = "Can Ignore these Damage Source Damages";
      desc = "List of Damage Source names which this form can ignore.";
      property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
      property.comment = "Server Sided! " + desc;
      String[] list = property.getStringList();
      cCONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[list.length];
      CONFIG_GOD_IGNORED_DAMAGE_SOURCES = new String[list.length];

      for(i = 0; i < list.length; ++i) {
         cCONFIG_GOD_IGNORED_DAMAGE_SOURCES[i] = list[i];
         CONFIG_GOD_IGNORED_DAMAGE_SOURCES[i] = list[i];
      }

      defaultList = new String[]{""};
      title = "Can Ignore these Entity Damages";
      desc = "List of Entity names which this form can ignore.";
      property = config.get(CATEGORY, "God of Destruction " + title, defaultList);
      property.comment = "Server Sided! " + desc;
      list = property.getStringList();
      cCONFIG_GOD_IGNORED_ENTITIES = new String[list.length];
      CONFIG_GOD_IGNORED_ENTITIES = new String[list.length];

      for(i = 0; i < list.length; ++i) {
         cCONFIG_GOD_IGNORED_ENTITIES[i] = list[i];
         CONFIG_GOD_IGNORED_ENTITIES[i] = list[i];
      }

      min = 0;
      max = 100000;
      title = "Ignore Damage Multiplier";
      desc = "In Destroyer Aura Mode when a GoD form user is attacked then they can completely negate the damage dealt to them IF their melee attack multiplied by this value is stronger than the received damage" + getDefault("" + min, "" + max) + getDefaultValue2("0.8");
      property = config.get(CATEGORY, "God of Destruction " + title, 0.8D);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_IGNORE_DAMAGE_MULTI = (float)property.getDouble();
      if (cCONFIG_GOD_IGNORE_DAMAGE_MULTI < (float)min) {
         cCONFIG_GOD_IGNORE_DAMAGE_MULTI = (float)min;
      } else if (cCONFIG_GOD_IGNORE_DAMAGE_MULTI > (float)max) {
         cCONFIG_GOD_IGNORE_DAMAGE_MULTI = (float)max;
      }

      CONFIG_GOD_IGNORE_DAMAGE_MULTI = cCONFIG_GOD_IGNORE_DAMAGE_MULTI;
      title = "Ignore Projectile Entity Damages Enabled";
      desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED = property.getBoolean();
      CONFIG_GOD_IGNORE_PROJECTILES_ENABLED = cCONFIG_GOD_IGNORE_PROJECTILES_ENABLED;
      title = "Form Enabled";
      desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_ENABLED = property.getBoolean();
      CONFIG_GOD_ENABLED = cCONFIG_GOD_ENABLED;
      title = "Destroyer Aura Enabled";
      desc = "(true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_AURA_ENABLED = property.getBoolean();
      CONFIG_GOD_AURA_ENABLED = cCONFIG_GOD_AURA_ENABLED;
      title = "Destroyer Aura Only in Turbo Mode Enabled";
      desc = "Destroyer Aura is ONLY enabled in Turbo Aura Mode. (true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_AURA_ENABLED_WITH_AURA = property.getBoolean();
      CONFIG_GOD_AURA_ENABLED_WITH_AURA = cCONFIG_GOD_AURA_ENABLED_WITH_AURA;
      title = "Destroyer Energy Enabled";
      desc = "All Custom Ki Attacks are converted to Destroyer Attacks. (true = Enabled, false = Disabled)" + getDefaultValue2("true");
      property = config.get(CATEGORY, "God of Destruction " + title, true);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_ENERGY_ENABLED = property.getBoolean();
      CONFIG_GOD_ENERGY_ENABLED = cCONFIG_GOD_ENERGY_ENABLED;
      min = 0;
      max = 100000;
      title = "Destroyer Energy Damage Multiplier";
      desc = "When a Destroyer Ki Attack hits another Ki Attack then it instantly destroy the other one IF their damage multiplied by this value is stronger than the received damage" + getDefault("" + min, "" + max) + getDefaultValue2("0.8");
      property = config.get(CATEGORY, "God of Destruction " + title, 0.8D);
      property.comment = "Server Sided! " + desc;
      cCONFIG_GOD_ENERGY_DAMAGE_MULTI = (float)property.getDouble();
      if (cCONFIG_GOD_ENERGY_DAMAGE_MULTI < (float)min) {
         cCONFIG_GOD_ENERGY_DAMAGE_MULTI = (float)min;
      } else if (cCONFIG_GOD_ENERGY_DAMAGE_MULTI > (float)max) {
         cCONFIG_GOD_ENERGY_DAMAGE_MULTI = (float)max;
      }

      CONFIG_GOD_ENERGY_DAMAGE_MULTI = cCONFIG_GOD_ENERGY_DAMAGE_MULTI;
      min = 0;
      max = 100;
      title = "Max Alignment Limit";
      desc = "Using the Form above this Alignment value is not possible" + getDefault("" + min, "" + max) + getDefaultValue2("80");
      property = config.get(CATEGORY, "God of Destruction " + title, 80);
      property.comment = "Server Sided! " + desc;
      CONFIG_GOD_MAX_ALIGNMENT = property.getInt();
      if (CONFIG_GOD_MAX_ALIGNMENT < min) {
         CONFIG_GOD_MAX_ALIGNMENT = min;
      } else if (CONFIG_GOD_MAX_ALIGNMENT > max) {
         CONFIG_GOD_MAX_ALIGNMENT = max;
      }

      min = 0;
      max = 1000000000;
      title = "Destroyer Aura Ki Cost";
      desc = "Aura Cost per Server update. (FlatCost PercentageCost)" + getDefault("" + min, "" + max) + getDefaultValue2("10 0.0025");
      property = config.get(CATEGORY, "God of Destruction " + title, "10 0.0025");
      property.comment = "Server Sided! " + desc;
      defaultList = property.getString().split(" ");

      for(i = 0; i < defaultList.length; ++i) {
         float value = Float.parseFloat(defaultList[i]);
         CONFIG_GOD_AURA_KI_COST[i] = value;
         if (CONFIG_GOD_AURA_KI_COST[i] < (float)min) {
            CONFIG_GOD_AURA_KI_COST[i] = (float)min;
         } else if (CONFIG_GOD_AURA_KI_COST[i] > (float)max) {
            CONFIG_GOD_AURA_KI_COST[i] = (float)max;
         }
      }

   }

   static {
      CONFIG_GOD_ATTRIBUTE_MULTI_RACE = new float[JRMCoreH.Races.length];
      cCONFIG_GOD_ATTRIBUTE_MULTI_RACE = new float[JRMCoreH.Races.length];
   }
}
