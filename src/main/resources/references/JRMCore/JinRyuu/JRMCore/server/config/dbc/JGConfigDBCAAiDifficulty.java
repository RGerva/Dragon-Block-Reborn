package JinRyuu.JRMCore.server.config.dbc;

import JinRyuu.JRMCore.server.config.JGConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class JGConfigDBCAAiDifficulty extends JGConfigBase {
   public static final String[] DIFFICULTIES = new String[]{"Easy", "Medium", "Hard", "Insane"};
   public static final String[] AAIs = new String[]{"Ground Dash", "Jump", "Flying Dash", "Ki Attack Charge", "Teleport"};
   public static double[] SpeedMulti;
   public static double[] GroundDashSpeedMulti;
   public static double[] GroundDashSpeedMulti2;
   public static double[] GroundDashLimit;
   public static double[] JumpMulti;
   public static double[] JumpMulti2;
   public static double[] JumpLimit;
   public static double[] JumpLimit2;
   public static double[] JumpRate;
   public static double[] FlyingDashMulti;
   public static double[] FlyingDashLimit;
   public static double[] KiAttackChargeMulti;
   public static double[] KiAttackChargeLimit;
   public static int[] TeleportRateMin;
   public static int[] TeleportRateMax;
   public static double[] cSpeedMulti;
   public static double[] cGroundDashSpeedMulti;
   public static double[] cGroundDashSpeedMulti2;
   public static double[] cGroundDashLimit;
   public static double[] cJumpMulti;
   public static double[] cJumpMulti2;
   public static double[] cJumpLimit;
   public static double[] cJumpLimit2;
   public static double[] cJumpRate;
   public static double[] cFlyingDashMulti;
   public static double[] cFlyingDashLimit;
   public static double[] cKiAttackChargeMulti;
   public static double[] cKiAttackChargeLimit;
   public static int[] cTeleportRateMin;
   public static int[] cTeleportRateMax;

   public static void init(Configuration config, byte difficultyID) {
      config.load();
      init_difficulty(config, difficultyID);
      config.save();
   }

   private static void init_difficulty(Configuration config, byte difficultyID) {
      String name = "DBC " + DIFFICULTIES[difficultyID];
      String percentage = " (Percentage)";
      String server = "Server Sided! ";
      String CATEGORY = "Main Settings";
      int min = 0;
      int max = 10000;
      String title = CATEGORY + " Speed Multiplier";
      Property property = config.get(CATEGORY, title, (new double[]{-1.0D, 1.3D, 1.8D, 2.3D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cSpeedMulti[difficultyID] = property.getDouble();
      if (cSpeedMulti[difficultyID] < (double)min) {
         cSpeedMulti[difficultyID] = (double)min;
      } else if (cSpeedMulti[difficultyID] > (double)max) {
         cSpeedMulti[difficultyID] = (double)max;
      }

      SpeedMulti[difficultyID] = cSpeedMulti[difficultyID];
      CATEGORY = AAIs[0];
      min = 0;
      max = 10000;
      title = CATEGORY + " Speed Multiplier";
      property = config.get(CATEGORY, title, (new double[]{1.2D, 1.3D, 1.4D, 1.5D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cGroundDashSpeedMulti[difficultyID] = property.getDouble();
      if (cGroundDashSpeedMulti[difficultyID] < (double)min) {
         cGroundDashSpeedMulti[difficultyID] = (double)min;
      } else if (cGroundDashSpeedMulti[difficultyID] > (double)max) {
         cGroundDashSpeedMulti[difficultyID] = (double)max;
      }

      GroundDashSpeedMulti[difficultyID] = cGroundDashSpeedMulti[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Position Difference Speed Multiplier";
      property = config.get(CATEGORY, title, (new double[]{0.3D, 0.4D, 0.5D, 0.8D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cGroundDashSpeedMulti2[difficultyID] = property.getDouble();
      if (cGroundDashSpeedMulti2[difficultyID] < (double)min) {
         cGroundDashSpeedMulti2[difficultyID] = (double)min;
      } else if (cGroundDashSpeedMulti2[difficultyID] > (double)max) {
         cGroundDashSpeedMulti2[difficultyID] = (double)max;
      }

      GroundDashSpeedMulti2[difficultyID] = cGroundDashSpeedMulti2[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Speed Limit";
      property = config.get(CATEGORY, title, (new double[]{0.2D, 0.3D, 0.4D, 0.5D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cGroundDashLimit[difficultyID] = property.getDouble();
      if (cGroundDashLimit[difficultyID] < (double)min) {
         cGroundDashLimit[difficultyID] = (double)min;
      } else if (cGroundDashLimit[difficultyID] > (double)max) {
         cGroundDashLimit[difficultyID] = (double)max;
      }

      GroundDashLimit[difficultyID] = cGroundDashLimit[difficultyID];
      CATEGORY = AAIs[1];
      min = 0;
      max = 10000;
      title = CATEGORY + " Upwards Multiplier";
      property = config.get(CATEGORY, title, (new double[]{0.9D, 0.9D, 0.9D, 0.9D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cJumpMulti[difficultyID] = property.getDouble();
      if (cJumpMulti[difficultyID] < (double)min) {
         cJumpMulti[difficultyID] = (double)min;
      } else if (cJumpMulti[difficultyID] > (double)max) {
         cJumpMulti[difficultyID] = (double)max;
      }

      JumpMulti[difficultyID] = cJumpMulti[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Sideways Multiplier";
      property = config.get(CATEGORY, title, (new double[]{0.5D, 0.8D, 1.0D, 1.2D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cJumpMulti2[difficultyID] = property.getDouble();
      if (cJumpMulti2[difficultyID] < (double)min) {
         cJumpMulti2[difficultyID] = (double)min;
      } else if (cJumpMulti2[difficultyID] > (double)max) {
         cJumpMulti2[difficultyID] = (double)max;
      }

      JumpMulti2[difficultyID] = cJumpMulti2[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Sideways Limit";
      property = config.get(CATEGORY, title, (new double[]{2.5D, 4.0D, -1.0D, -1.0D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cJumpLimit[difficultyID] = property.getDouble();
      if (cJumpLimit[difficultyID] < (double)min) {
         cJumpLimit[difficultyID] = (double)min;
      } else if (cJumpLimit[difficultyID] > (double)max) {
         cJumpLimit[difficultyID] = (double)max;
      }

      JumpLimit[difficultyID] = cJumpLimit[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Upwards Limit";
      property = config.get(CATEGORY, title, (new double[]{2.0D, 3.0D, 7.0D, 7.0D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cJumpLimit2[difficultyID] = property.getDouble();
      if (cJumpLimit2[difficultyID] < (double)min) {
         cJumpLimit2[difficultyID] = (double)min;
      } else if (cJumpLimit2[difficultyID] > (double)max) {
         cJumpLimit2[difficultyID] = (double)max;
      }

      JumpLimit2[difficultyID] = cJumpLimit2[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Rate";
      property = config.get(CATEGORY, title, (new double[]{0.6D, 0.8D, 0.9D, 0.9D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cJumpRate[difficultyID] = property.getDouble();
      if (cJumpRate[difficultyID] < (double)min) {
         cJumpRate[difficultyID] = (double)min;
      } else if (cJumpRate[difficultyID] > (double)max) {
         cJumpRate[difficultyID] = (double)max;
      }

      JumpRate[difficultyID] = cJumpRate[difficultyID];
      CATEGORY = AAIs[2];
      min = 0;
      max = 10000;
      title = CATEGORY + " Speed Multiplier";
      property = config.get(CATEGORY, title, (new double[]{1.0D, 2.0D, 4.0D, 6.0D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cFlyingDashMulti[difficultyID] = property.getDouble();
      if (cFlyingDashMulti[difficultyID] < (double)min) {
         cFlyingDashMulti[difficultyID] = (double)min;
      } else if (cFlyingDashMulti[difficultyID] > (double)max) {
         cFlyingDashMulti[difficultyID] = (double)max;
      }

      FlyingDashMulti[difficultyID] = cFlyingDashMulti[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Speed Limit";
      property = config.get(CATEGORY, title, (new double[]{0.15D, 0.2D, 0.8D, 1.0D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cFlyingDashLimit[difficultyID] = property.getDouble();
      if (cFlyingDashLimit[difficultyID] < (double)min) {
         cFlyingDashLimit[difficultyID] = (double)min;
      } else if (cFlyingDashLimit[difficultyID] > (double)max) {
         cFlyingDashLimit[difficultyID] = (double)max;
      }

      FlyingDashLimit[difficultyID] = cFlyingDashLimit[difficultyID];
      CATEGORY = AAIs[3];
      min = 0;
      max = 10000;
      title = CATEGORY + " Runaway Speed Multiplier";
      property = config.get(CATEGORY, title, (new double[]{0.6D, 0.7D, 0.9D, 1.1D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cKiAttackChargeMulti[difficultyID] = property.getDouble();
      if (cKiAttackChargeMulti[difficultyID] < (double)min) {
         cKiAttackChargeMulti[difficultyID] = (double)min;
      } else if (cKiAttackChargeMulti[difficultyID] > (double)max) {
         cKiAttackChargeMulti[difficultyID] = (double)max;
      }

      KiAttackChargeMulti[difficultyID] = cKiAttackChargeMulti[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Runaway Speed Limit";
      property = config.get(CATEGORY, title, (new double[]{0.2D, 0.4D, 0.7D, 1.0D})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cKiAttackChargeLimit[difficultyID] = property.getDouble();
      if (cKiAttackChargeLimit[difficultyID] < (double)min) {
         cKiAttackChargeLimit[difficultyID] = (double)min;
      } else if (cKiAttackChargeLimit[difficultyID] > (double)max) {
         cKiAttackChargeLimit[difficultyID] = (double)max;
      }

      KiAttackChargeLimit[difficultyID] = cKiAttackChargeLimit[difficultyID];
      CATEGORY = AAIs[4];
      min = 0;
      max = 10000;
      title = CATEGORY + " Minimum Rate";
      property = config.get(CATEGORY, title, (new int[]{120, 100, 90, 75})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cTeleportRateMin[difficultyID] = property.getInt();
      if (cTeleportRateMin[difficultyID] < min) {
         cTeleportRateMin[difficultyID] = min;
      } else if (cTeleportRateMin[difficultyID] > max) {
         cTeleportRateMin[difficultyID] = max;
      }

      TeleportRateMin[difficultyID] = cTeleportRateMin[difficultyID];
      min = 0;
      max = 10000;
      title = CATEGORY + " Maximum Rate";
      property = config.get(CATEGORY, title, (new int[]{50, 50, 45, 45})[difficultyID]);
      property.comment = "Server Sided! " + title + getDefault("" + min, "" + max);
      cTeleportRateMax[difficultyID] = property.getInt();
      if (cTeleportRateMax[difficultyID] < min) {
         cTeleportRateMax[difficultyID] = min;
      } else if (cTeleportRateMax[difficultyID] > max) {
         cTeleportRateMax[difficultyID] = max;
      }

      TeleportRateMax[difficultyID] = cTeleportRateMax[difficultyID];
   }

   static {
      SpeedMulti = new double[DIFFICULTIES.length];
      GroundDashSpeedMulti = new double[DIFFICULTIES.length];
      GroundDashSpeedMulti2 = new double[DIFFICULTIES.length];
      GroundDashLimit = new double[DIFFICULTIES.length];
      JumpMulti = new double[DIFFICULTIES.length];
      JumpMulti2 = new double[DIFFICULTIES.length];
      JumpLimit = new double[DIFFICULTIES.length];
      JumpLimit2 = new double[DIFFICULTIES.length];
      JumpRate = new double[DIFFICULTIES.length];
      FlyingDashMulti = new double[DIFFICULTIES.length];
      FlyingDashLimit = new double[DIFFICULTIES.length];
      KiAttackChargeMulti = new double[DIFFICULTIES.length];
      KiAttackChargeLimit = new double[DIFFICULTIES.length];
      TeleportRateMin = new int[DIFFICULTIES.length];
      TeleportRateMax = new int[DIFFICULTIES.length];
      cSpeedMulti = new double[DIFFICULTIES.length];
      cGroundDashSpeedMulti = new double[DIFFICULTIES.length];
      cGroundDashSpeedMulti2 = new double[DIFFICULTIES.length];
      cGroundDashLimit = new double[DIFFICULTIES.length];
      cJumpMulti = new double[DIFFICULTIES.length];
      cJumpMulti2 = new double[DIFFICULTIES.length];
      cJumpLimit = new double[DIFFICULTIES.length];
      cJumpLimit2 = new double[DIFFICULTIES.length];
      cJumpRate = new double[DIFFICULTIES.length];
      cFlyingDashMulti = new double[DIFFICULTIES.length];
      cFlyingDashLimit = new double[DIFFICULTIES.length];
      cKiAttackChargeMulti = new double[DIFFICULTIES.length];
      cKiAttackChargeLimit = new double[DIFFICULTIES.length];
      cTeleportRateMin = new int[DIFFICULTIES.length];
      cTeleportRateMax = new int[DIFFICULTIES.length];
   }
}
