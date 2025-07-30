package JinRyuu.JRMCore.server;

import net.minecraft.entity.Entity;

public class JGMathHelper {
   public static double StringMethod(String method, double n1, double n2) {
      if (method.equals("+")) {
         n1 += n2;
      } else if (method.equals("-")) {
         n1 -= n2;
      } else if (method.equals("*")) {
         n1 *= n2;
      } else if (method.equals("/")) {
         n1 /= n2;
      } else if (method.equals("%")) {
         n1 %= n2;
      }

      return n1;
   }

   public static long StringMethod(String method, long n1, long n2) {
      if (method.equals("+")) {
         n1 += n2;
      } else if (method.equals("-")) {
         n1 -= n2;
      } else if (method.equals("*")) {
         n1 *= n2;
      } else if (method.equals("/")) {
         n1 /= n2;
      } else if (method.equals("%")) {
         n1 %= n2;
      }

      return n1;
   }

   public static double doubleLimit(double value, double max) {
      boolean minus = value < 0.0D;
      if (minus) {
         value *= -1.0D;
      }

      if (value > max) {
         value = max;
      }

      if (minus) {
         value *= -1.0D;
      }

      return value;
   }

   public static boolean doubleHigherThan(double value, double min) {
      return value < 0.0D ? -value > min : value > min;
   }

   public static boolean doubleSmallerThan(double value, double min) {
      return value < 0.0D ? -value < min : value < min;
   }

   public static boolean isMotionSmallerThanN(Entity entity, double minMotion, boolean doX, boolean doY, boolean doZ, boolean methodOne) {
      double motion;
      double x;
      double y;
      if (!methodOne) {
         motion = 0.0D;
         x = doX ? entity.field_70159_w : 0.0D;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         y = doY ? entity.field_70181_x : 0.0D;
         if (y < 0.0D) {
            y *= -1.0D;
         }

         double z = doZ ? entity.field_70179_y : 0.0D;
         if (z < 0.0D) {
            z *= -1.0D;
         }

         motion += x + y + z;
         return motion < minMotion;
      } else {
         motion = entity.field_70159_w;
         x = entity.field_70181_x;
         y = entity.field_70179_y;
         boolean canDoX = doX ? motion <= minMotion && motion >= -minMotion : true;
         boolean canDoY = doY ? x <= minMotion && x >= -minMotion : true;
         boolean canDoZ = doZ ? y <= minMotion && y >= -minMotion : true;
         return canDoX && canDoY && canDoZ;
      }
   }

   public static boolean isMotionBiggerThanN(Entity entity, double minMotion, boolean doX, boolean doY, boolean doZ, boolean methodOne) {
      double motion;
      double x;
      double y;
      if (!methodOne) {
         motion = 0.0D;
         x = doX ? entity.field_70159_w : 0.0D;
         if (x < 0.0D) {
            x *= -1.0D;
         }

         y = doY ? entity.field_70181_x : 0.0D;
         if (y < 0.0D) {
            y *= -1.0D;
         }

         double z = doZ ? entity.field_70179_y : 0.0D;
         if (z < 0.0D) {
            z *= -1.0D;
         }

         motion += x + y + z;
         return motion > minMotion;
      } else {
         motion = entity.field_70159_w;
         x = entity.field_70181_x;
         y = entity.field_70179_y;
         boolean canDoX = doX ? motion >= minMotion && motion <= -minMotion : false;
         boolean canDoY = doY ? x >= minMotion && x <= -minMotion : false;
         boolean canDoZ = doZ ? y >= minMotion && y <= -minMotion : false;
         return canDoX || canDoY || canDoZ;
      }
   }

   public static boolean isMotionSmallerThanN(Entity entity, double minMotion) {
      return isMotionSmallerThanN(entity, minMotion, true, true, true, true);
   }

   public static boolean isMotionBiggerThanN(Entity entity, double minMotion) {
      return isMotionBiggerThanN(entity, minMotion, true, true, true, true);
   }
}
