package JinRyuu.JRMCore.entity.aai;

import java.util.Random;

public class AAi {
   public AAiSystem aaiSystem;

   public void update() {
   }

   public boolean checkChanceToUse(double rate) {
      if (rate >= 1.0D) {
         return true;
      } else if (rate <= 0.0D) {
         return false;
      } else {
         return (new Random()).nextInt(100) < (int)(rate * 100.0D);
      }
   }
}
