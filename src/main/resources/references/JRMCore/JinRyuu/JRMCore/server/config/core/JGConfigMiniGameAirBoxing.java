package JinRyuu.JRMCore.server.config.core;

import JinRyuu.JRMCore.server.config.JGConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class JGConfigMiniGameAirBoxing extends JGConfigBase {
   public static final String CATEGORY_MINIGAME_SERVERSIDED = "MiniGame";
   public static final String CATEGORY_MINIGAME_AIRBOXING_SERVERSIDED = "MiniGame AirBoxing";
   public static final String CATEGORY_MINIGAME_MODE_SERVERSIDED = "MiniGame Mode";
   public static boolean TPGainOn;
   public static boolean cTPGainOn;
   public static float TPlimitIncreasesWithPlayerLevel;
   public static float cTPlimitIncreasesWithPlayerLevel;
   public static float TPMultiplier;
   public static float cTPMultiplier;
   public static int TPDailyLimit;
   public static int cTPDailyLimit;
   public static final int MODES = 4;
   public static int StartLife;
   public static int cStartLife;
   public static float[] KeySpawnSpeed = new float[4];
   public static float[] cKeySpawnSpeed = new float[4];
   public static float[] KeySpeed = new float[4];
   public static float[] cKeySpeed = new float[4];
   public static int[] KeyLifeTaken = new int[4];
   public static int[] cKeyLifeTaken = new int[4];
   public static int[][] KeyTypeIDs = new int[4][];
   public static int[][] cKeyTypeIDs = new int[4][];

   public static void init(Configuration config) {
      config.load();
      init_minigame(config);
      config.save();
   }

   private static void init_minigame(Configuration config) {
      String name = "";
      String CATEGORY = "MiniGame AirBoxing";
      String percentage = " (Percentage)";
      String SERVERSIDE = "Server Sided! ";
      String defaultValue = ". (true).";
      String title = "TP Gain On";
      String description = "If 'true' then from this minigame the TP gain feature will be enabled, if 'false' then players can't earn TP";
      Property property = config.get(CATEGORY, "" + title, true);
      property.comment = "Server Sided! " + description + defaultValue;
      cTPGainOn = property.getBoolean();
      TPGainOn = cTPGainOn;
      int min = 0;
      int max = 100000;
      defaultValue = "" + getDefault("" + min, "" + max);
      title = "TP Limit Increases With Player Level Multiplier";
      description = "If value is above 0 then the minigame's TP daily limit will increase based on the player's level multiplied with the config. Setting it to 0 disables this";
      property = config.get(CATEGORY, "" + title, 1.0D);
      property.comment = "Server Sided! " + description + defaultValue;
      cTPlimitIncreasesWithPlayerLevel = (float)property.getDouble();
      if (cTPlimitIncreasesWithPlayerLevel < (float)min) {
         cTPlimitIncreasesWithPlayerLevel = (float)min;
      } else if (cTPlimitIncreasesWithPlayerLevel > (float)max) {
         cTPlimitIncreasesWithPlayerLevel = (float)max;
      }

      TPlimitIncreasesWithPlayerLevel = cTPlimitIncreasesWithPlayerLevel;
      min = 0;
      max = 100000;
      defaultValue = "" + getDefault("" + min, "" + max);
      title = "TP Multiplier";
      description = "TP gain reward multiplier";
      property = config.get(CATEGORY, "" + title, 0.035D);
      property.comment = "Server Sided! " + description + defaultValue;
      cTPMultiplier = (float)property.getDouble();
      if (cTPMultiplier < (float)min) {
         cTPMultiplier = (float)min;
      } else if (cTPMultiplier > (float)max) {
         cTPMultiplier = (float)max;
      }

      TPMultiplier = cTPMultiplier;
      min = 0;
      max = 1000000000;
      defaultValue = "" + getDefault("" + min, "" + max);
      title = "TP Daily Limit";
      description = "TP daily reward limitation";
      property = config.get(CATEGORY, "" + title, 20);
      property.comment = "Server Sided! " + description + defaultValue;
      cTPDailyLimit = property.getInt();
      if (cTPDailyLimit < min) {
         cTPDailyLimit = min;
      } else if (cTPDailyLimit > max) {
         cTPDailyLimit = max;
      }

      TPDailyLimit = cTPDailyLimit;
      min = 0;
      max = 1000000;
      defaultValue = "" + getDefault("" + min, "" + max);
      title = "Starting Life";
      description = "Starting Life points";
      property = config.get(CATEGORY, "" + title, 1);
      property.comment = "Server Sided! " + description + defaultValue;
      cStartLife = property.getInt();
      if (cStartLife < min) {
         cStartLife = min;
      } else if (cStartLife > max) {
         cStartLife = max;
      }

      StartLife = cStartLife;
      double[] KeySpawnSpeed2 = new double[]{1.0D, 0.8D, 0.7D, 1.0D};
      double[] KeySpeed2 = new double[]{0.09D, 0.085D, 0.08D, 0.1D};
      int[] KeyLifeTaken2 = new int[]{0, 0, 0, 0};
      String[][] KeyTypeIDs2 = new String[][]{{"W"}, {"W", "A"}, {"W", "A", "S"}, {"W", "A", "S", "D"}};

      for(int i = 0; i < 4; ++i) {
         CATEGORY = "MiniGame Mode" + i;
         min = 0;
         int max = 1000;
         defaultValue = "" + getDefault("" + min, "" + max);
         title = "Key Spawn Timer";
         description = "Key Spawn Speed in seconds";
         property = config.get(CATEGORY, "" + title, KeySpawnSpeed2[i]);
         property.comment = "Server Sided! " + description + defaultValue;
         cKeySpawnSpeed[i] = (float)property.getDouble();
         if (cKeySpawnSpeed[i] < (float)min) {
            cKeySpawnSpeed[i] = (float)min;
         } else if (cKeySpawnSpeed[i] > (float)max) {
            cKeySpawnSpeed[i] = (float)max;
         }

         KeySpawnSpeed[i] = cKeySpawnSpeed[i];
         min = 0;
         max = 1000;
         defaultValue = "" + getDefault("" + min, "" + max);
         title = "Key Movement Speed";
         description = "Key Movement Speed value";
         property = config.get(CATEGORY, "" + title, KeySpeed2[i]);
         property.comment = "Server Sided! " + description + defaultValue;
         cKeySpeed[i] = (float)property.getDouble();
         if (cKeySpeed[i] < (float)min) {
            cKeySpeed[i] = (float)min;
         } else if (cKeySpeed[i] > (float)max) {
            cKeySpeed[i] = (float)max;
         }

         KeySpeed[i] = cKeySpeed[i];
         min = 0;
         max = 1000;
         defaultValue = "" + getDefault("" + min, "" + max);
         title = "Life Taken on Miss";
         description = "Life lost on Key Miss";
         property = config.get(CATEGORY, "" + title, KeyLifeTaken2[i]);
         property.comment = "Server Sided! " + description + defaultValue;
         cKeyLifeTaken[i] = property.getInt();
         if (cKeyLifeTaken[i] < min) {
            cKeyLifeTaken[i] = min;
         } else if (cKeyLifeTaken[i] > max) {
            cKeyLifeTaken[i] = max;
         }

         KeyLifeTaken[i] = cKeyLifeTaken[i];
         min = 0;
         int max = 4;
         defaultValue = ". (W A S D).";
         String[] defaultValueS = KeyTypeIDs2[i];
         title = "Key Types";
         description = "Key Types in the mode";
         property = config.get(CATEGORY, "" + title, defaultValueS, "Server Sided! " + description + defaultValue);
         String text = property.getString();
         String[] keyValues = property.getStringList();
         cKeyTypeIDs[i] = new int[keyValues.length];
         KeyTypeIDs[i] = new int[keyValues.length];

         for(int j = 0; j < keyValues.length; ++j) {
            cKeyTypeIDs[i][j] = keyToId(keyValues[j]);
            if (cKeyTypeIDs[i][j] < min) {
               cKeyTypeIDs[i][j] = min;
            } else if (cKeyTypeIDs[i][j] > max) {
               cKeyTypeIDs[i][j] = max;
            }

            KeyTypeIDs[i][j] = cKeyTypeIDs[i][j];
         }
      }

   }

   public static int keyToId(String s) {
      if (s.equals("W")) {
         return 0;
      } else if (s.equals("A")) {
         return 1;
      } else {
         return s.equals("S") ? 2 : 3;
      }
   }
}
